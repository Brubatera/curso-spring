package com.bruno.dev.spring;

import com.bruno.dev.spring.domain.Category;
import com.bruno.dev.spring.repositories.RepositoryCategory;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@AllArgsConstructor
@SpringBootApplication
public class CursoUdemySpringApplication implements CommandLineRunner {

    private RepositoryCategory repository;

    public static void main(String[] args) {
        SpringApplication.run(CursoUdemySpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = Category.builder()
                .name("Informática")
                .build();

        Category cat2 = Category.builder()
                .name("Escritório")
                .build();

        repository.saveAll(Arrays.asList(cat1, cat2));
    }
}
