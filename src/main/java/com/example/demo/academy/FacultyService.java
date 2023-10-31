package com.example.demo.academy;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(() -> new IllegalStateException(
                "member with id " + facultyId + " does not exist"
        ));
    }

    public void addNewFaculty(Faculty faculty) {
        Optional<Faculty> facultyOptional = facultyRepository.findFacultyByEmail(faculty.getEmail());
        if (facultyOptional.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) {
        if (!facultyRepository.existsById(facultyId)) {
            throw new IllegalStateException("Member with id " + facultyId + " already exists");
        }
        facultyRepository.deleteById(facultyId);
    }

    @Transactional
    public void updateFaculty(Long facultyId, String name, String department, String position, String manager,
                              String email) {
        Faculty faculty = facultyRepository.findById(facultyId).orElseThrow(() -> new IllegalStateException(
                "member with id " + facultyId + " not found"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(faculty.getName(), name)) {
            faculty.setName(name);
        }

        if (department != null && department.length() > 0 && !Objects.equals(faculty.getName(), department)) {
            faculty.setDepartment(department);
        }

        if (position != null && position.length() > 0 && !Objects.equals(faculty.getName(), position)) {
            faculty.setPosition(position);
        }

        if (manager != null && manager.length() > 0 && !Objects.equals(faculty.getName(), manager)) {
            faculty.setManager(manager);
        }

        if (email != null && email.length() > 0 && !Objects.equals(faculty.getName(), email)) {
            Optional<Faculty> facultyOptional = facultyRepository.findFacultyByEmail(faculty.getEmail());
            if (facultyOptional.isPresent()) {
                throw new IllegalStateException("Email already in use");
            }
            faculty.setName(email);
        }
    }
}
