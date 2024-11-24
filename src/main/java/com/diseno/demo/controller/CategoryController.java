package com.diseno.demo.controller;

import com.diseno.demo.dto.request.CategoryDTO;
import com.diseno.demo.dto.response.GetCategoryDTO;
import com.diseno.demo.dto.response.UpdateCategoryDTO;
import com.diseno.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping
    public void createCategory(CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
    }

    @GetMapping
    public ResponseEntity<List<GetCategoryDTO>> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryDTOById(id);
    }

    @PatchMapping("/{id}")
    public void updateCategory(@PathVariable Long id, UpdateCategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
    }
}
