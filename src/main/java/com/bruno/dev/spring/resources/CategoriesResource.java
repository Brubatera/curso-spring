package com.bruno.dev.spring.resources;

import com.bruno.dev.spring.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> listar() {

        Category cat1 = Category.builder()
                .id(1L)
                .name("Informática")
                .build();

        Category cat2 = Category.builder()
                .id(2L)
                .name("Escritório")
                .build();


        return Arrays.asList(cat1, cat2);
    }
}
