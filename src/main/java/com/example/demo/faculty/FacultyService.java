package com.example.demo.faculty;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getFaculty() {
        return facultyRepository.findAll();
    }
}
