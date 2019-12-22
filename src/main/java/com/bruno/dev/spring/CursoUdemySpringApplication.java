package com.bruno.dev.spring;

import com.bruno.dev.spring.domain.Category;
import com.bruno.dev.spring.domain.City;
import com.bruno.dev.spring.domain.Product;
import com.bruno.dev.spring.domain.State;
import com.bruno.dev.spring.repositories.RepositoryCategory;
import com.bruno.dev.spring.repositories.RepositoryCity;
import com.bruno.dev.spring.repositories.RepositoryProduct;
import com.bruno.dev.spring.repositories.RepositoryState;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@AllArgsConstructor
@SpringBootApplication
public class CursoUdemySpringApplication implements CommandLineRunner {

    private RepositoryCategory repositoryCategory;
    private RepositoryProduct repositoryProduct;
    private RepositoryState repositoryState;
    private RepositoryCity repositoryCity;

    public static void main(String[] args) {
        SpringApplication.run(CursoUdemySpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = Category.builder()
                .name("Informática")
                .products(new ArrayList<>())
                .build();

        Category cat2 = Category.builder()
                .name("Escritório")
                .products(new ArrayList<>())
                .build();

        Product p1 = Product.builder()
                .name("Computador")
                .price(2000.00)
                .categories(new ArrayList<>())
                .build();

        Product p2 = Product.builder()
                .name("Impressora")
                .price(800.00)
                .categories(new ArrayList<>())
                .build();

        Product p3 = Product.builder()
                .name("Mouse")
                .price(80.00)
                .categories(new ArrayList<>())
                .build();

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Collections.singletonList(p2));

        p1.getCategories().addAll(Collections.singletonList(cat1));
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().addAll(Collections.singletonList(cat1));

        repositoryCategory.saveAll(Arrays.asList(cat1, cat2));
        repositoryProduct.saveAll(Arrays.asList(p1, p2, p3));

        State st1 = State.builder()
                .name("Minas Gerais")
                .cities(new ArrayList<>())
                .build();

        State st2 = State.builder()
                .name("São Paulo")
                .cities(new ArrayList<>())
                .build();

        City c1 = City.builder()
                .name("Uberlândia")
                .state(st1)
                .build();

        City c2 = City.builder()
                .name("São Paulo")
                .state(st2)
                .build();

        City c3 = City.builder()
                .name("Campinas")
                .state(st2)
                .build();

        st1.getCities().addAll(Collections.singletonList(c1));
        st2.getCities().addAll(Arrays.asList(c2, c3));

        repositoryState.saveAll(Arrays.asList(st1, st2));
        repositoryCity.saveAll(Arrays.asList(c1, c2, c3));
    }
}
