package com.example.demo.faculty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FacultyConfig {

    @Bean
    CommandLineRunner commandLineRunner(FacultyRepository facultyRepository) {
        return args -> {
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
        };

        facultyRepository.saveAll(
                List.of(alex, janet)
        );


    }
}
