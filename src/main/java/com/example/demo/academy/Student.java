package com.example.demo.academy;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class for holding information needed for a Student in the database
 */
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    /**
     * ID for students, generated sequentially on creation
     */
    private Long id;
    /**
     * String, name for Student
     */
    private String name;
    /**
     * String, email for Student
     */
    private String email;
    /**
     * LocalDate, Student date of birth. yyyy-MM-dd e.g. '1990-01-01'
     */
    private LocalDate dob;

    /**
     * Age ofn the student. calculated from the difference between current date and dob
     */
    @Transient
    private int age;

    /**
     * Default constructor for Student
     */
    public Student() {
    }

    /**
     * Overloaded constructor for student
     * @param id ID of the student
     * @param name name of the student
     * @param email email of the student
     * @param dob date of birth for the student
     */
    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    /**
     * Overloaded constructor for the student
     * @param name name of the student
     * @param email email of the student
     * @param dob date of birth for the student
     */
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    /**
     * Accessor for student ID
     * @return Long, ID of the student
     */
    public Long getId() {
        return id;
    }

    /**
     * Mutator for student ID
     * @param id student ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Accessor for student name
     * @return String, name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator for student name
     * @param name student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for student email
     * @return String, email for the student
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mutator for student email
     * @param email Student email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Accessor for student dob
     * @return LocalDate, student date of birth
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Mutator for student dob
     * @param dob student dob
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Accessor for student age. Calculates the years between dob and current date
     * @return int of age in years
     */
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    /**
     * Mutator for student age
     * @param age student age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Converts student object to a string representation
     * @return String representation of Student object
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
