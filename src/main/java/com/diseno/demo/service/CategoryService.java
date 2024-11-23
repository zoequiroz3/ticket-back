package com.diseno.demo.service;

import com.diseno.demo.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.diseno.demo.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
    }

}
