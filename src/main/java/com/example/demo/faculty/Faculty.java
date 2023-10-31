package com.example.demo.faculty;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Faculty {

    @Id
    @SequenceGenerator(
            name = "faculty_sequence",
            sequenceName = "faculty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "faculty_sequence"
    )

    private Long id;
    private String name;
    private int employeeId;
    private String department;
    private String position;
    private String manager;
    private String email;
    private LocalDate dob;

    public Faculty() {
    }

    public Faculty(Long id, String name, int employeeId, String department, String position, String manager, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.manager = manager;
        this.email = email;
        this.dob = dob;
    }

    public Faculty(String name, int employeeId, String department, String position, String manager, String email, LocalDate dob) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.manager = manager;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", manager='" + manager + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
