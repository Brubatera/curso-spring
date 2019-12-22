package com.bruno.dev.spring.resources;

import com.bruno.dev.spring.services.ServiceCategory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/categories")
public class ResourceCategory {

    private ServiceCategory service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> search(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.search(id));
    }
}
