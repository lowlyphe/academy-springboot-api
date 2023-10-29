package com.example.demo.student;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Kyle",
                        "kyle.jones@gmail.com",
                        LocalDate.of(1993, Month.JANUARY, 28),
                        30
                )
        );
    }
}
