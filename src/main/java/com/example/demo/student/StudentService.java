package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Business logic for managing Students
 */
@Service
public class StudentService {

    /**
     * Instance of the StudentRepository Interface
     */
    private final StudentRepository studentRepository;

    /**
     * Constructor for StudentService
     * @param studentRepository Instance of the StudentRepository Interface
     */
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Gets all the students from the database
     * @return List containing all students
     */
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    /**
     * Adds new student to the database
     * @param student instance of the Student class
     * @throws IllegalStateException if a user with that email already exists
     */
    public void addNewStudent(Student student) {
        Optional<Student> studentByOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByOptional.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        studentRepository.save(student);
    }

    /**
     * Deletes a student from the database at the given ID
     * @param studentId ID of the student to be deleted
     */
    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    /**
     * Used for updating the fields in a student at the provided ID
     * @param studentId ID of the student ot be managed
     * @param name String containing an updated name
     * @param email String containing an updated email
     * @throws IllegalStateException if the ID does not exist, or if an email is already in use
     */
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exist"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentByOptional = studentRepository.findStudentByEmail(student.getEmail());
            if (studentByOptional.isPresent()) {
                throw new IllegalStateException("Email already in use");
            }
            student.setEmail(email);
        }
    }
}
