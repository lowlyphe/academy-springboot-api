package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller for the student class. Mappings: GET, POST, PUT, DELETE. Interacts with StudentService for logic
 */
@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    /**
     * Instance of the StudentService class
     */
    private final StudentService studentService;

    /**
     * Constructor for StudentController
     * @param studentService Instance of the StudentService class
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Returns a list of all Students in the database
     * @return List of Student Objects
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    /**
     * Creates a new student and adds it to the database
     * @param student Request body containing student information
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        try {
            studentService.addNewStudent(student);
        }
        catch (IllegalStateException ise) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(409), "User with that email already exists", ise
            );
        }
    }

    /**
     * Deletes student from database as the requested ID
     * @param studentId ID of the student to be deleted
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        try {
            studentService.deleteStudent(studentId);
        }
        catch (IllegalStateException ise) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(404), "Student ID " + studentId + " not found", ise
            );
        }
    }

    /**
     * Updates the student at the requested Student ID
     * @param studentId ID of the student to be managed
     * @param name new name for the requested Student ID
     * @param email new email for the requested Student ID
     */
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        try {
            studentService.updateStudent(studentId, name, email);
        }
        catch (IllegalStateException ise) {
            if (ise.getMessage().contains("does not exist")) {
                throw new ResponseStatusException(
                        HttpStatusCode.valueOf(404), "Student ID " + studentId + " not found", ise
                );
            }
            else if (ise.getMessage().contains("Email")){
                throw new ResponseStatusException(
                        HttpStatusCode.valueOf(309), "Email " + email + " already in use", ise
                );
            }
            else {
                throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Internal Server Error", ise);
            }

        }

    }
}
