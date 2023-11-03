package com.example.demo.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> getFaculty() {
        return facultyService.getFaculty();
    }

    @GetMapping(path = "{facultyId}")
    public Faculty getFacultyById(@PathVariable("facultyId") Long facultyId) {
        try {
            return facultyService.getFacultyById(facultyId);
        }
        catch (IllegalStateException ise) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(404), "Faculty ID " + facultyId + " not found", ise
            );
        }
    }

    @PostMapping
    public void registerNewFaculty(@RequestBody Faculty faculty) {
        try {
            facultyService.addNewFaculty(faculty);
        }
        catch (IllegalStateException ise) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(409), "Member with that email already exists", ise
            );
        }
    }

    @DeleteMapping(path = "{facultyId}")
    public void deleteFaculty(@PathVariable("facultyId") Long facultyId) {
        try {
            facultyService.deleteFaculty(facultyId);
        }
        catch (IllegalStateException ise) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(404), "Faculty ID " + facultyId + " not found", ise
            );
        }
    }

    @PutMapping(path = "{facultyId}")
    public void updateFaculty(
            @PathVariable("facultyId") Long facultyId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String manager,
            @RequestParam(required = false) String email) {
        try {
            facultyService.updateFaculty(facultyId, name, department, position, manager, email);
        }
        catch (IllegalStateException ise) {
            if (ise.getMessage().contains("does not exist")) {
                throw new ResponseStatusException(
                        HttpStatusCode.valueOf(404), "Member ID " + facultyId + " not found", ise
                );
            }
            else if (ise.getMessage().contains("Email")) {
                throw new ResponseStatusException(
                        HttpStatusCode.valueOf(309), "Email " + email + " already in use", ise
                );
            }
            else {
                throw new ResponseStatusException(
                        HttpStatusCode.valueOf(500), "Internal Server Error", ise
                );
            }
        }
    }



}
