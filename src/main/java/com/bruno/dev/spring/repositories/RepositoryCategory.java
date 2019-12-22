package com.bruno.dev.spring.repositories;

import com.bruno.dev.spring.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategory extends JpaRepository<Category, Long> {
}
