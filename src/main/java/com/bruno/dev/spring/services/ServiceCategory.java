package com.bruno.dev.spring.services;

import com.bruno.dev.spring.domain.Category;
import com.bruno.dev.spring.exceptions.CategoryNotFoundException;
import com.bruno.dev.spring.repositories.RepositoryCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServiceCategory {

    private RepositoryCategory repo;

    public Category search(Long id) {
        return repo.findById(id).get();
    }
}
