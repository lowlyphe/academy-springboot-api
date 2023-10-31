package com.example.demo.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public List<Faculty> getFaculty() {
        return facultyService.getFaculty();
    }
}
