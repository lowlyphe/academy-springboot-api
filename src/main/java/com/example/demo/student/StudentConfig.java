package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student kyle = new Student(
                    "Kyle",
                    "kyle.jones@gmail.com",
                    LocalDate.of(1993, Month.JANUARY, 28)
            );

            Student tim = new Student(
                    "Tim",
                    "Tim.shelling@gmail.com",
                    LocalDate.of(1990, Month.MARCH, 15)
            );

            studentRepository.saveAll(
                    List.of(kyle, tim)
            );
        };
    }
}
