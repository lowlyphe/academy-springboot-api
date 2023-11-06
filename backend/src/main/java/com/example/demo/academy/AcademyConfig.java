package com.example.demo.academy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AcademyConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        return args -> {
            Student kyle = new Student(
                    "Kyle",
                    "kyle.jones@yahoo.com",
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

            Faculty alex = new Faculty(
                    "Simmons, Alex",
                    54521,
                    "Physiology",
                    "Professor",
                    "Jones, Greg",
                    "alex.simmons@university.edu",
                    LocalDate.of(1976, Month.AUGUST, 05));

            Faculty janet = new Faculty(
                    "Jacobs, Janet",
                    62516,
                    "Maintenance",
                    "HVAC Repair Journeyman",
                    "Holland, Tim",
                    "janet.jacobs@university.edu",
                    LocalDate.of(1985, Month.JANUARY, 21));

            facultyRepository.saveAll(
                    List.of(alex, janet)
            );
        };
    }
}
