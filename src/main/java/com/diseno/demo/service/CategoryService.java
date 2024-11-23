package com.diseno.demo.service;

import com.diseno.demo.dto.request.CategoryDTO;
import com.diseno.demo.dto.response.GetCategoryDTO;
import com.diseno.demo.dto.response.UpdateCategoryDTO;
import com.diseno.demo.entity.Category;
import jakarta.persistence.PersistenceUnit;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.diseno.demo.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TypeService TypeService;
    private final ModelMapper modelMapper;

    public void createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getDescription(), TypeService.getTypeById(categoryDTO.getTypeId()));
        categoryRepository.save(category);
    }

    public ResponseEntity<GetCategoryDTO> getCategoryDTOById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(getCategoryById(id), GetCategoryDTO.class));
    }

    public ResponseEntity<List<GetCategoryDTO>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories.stream().map(category -> modelMapper.map(category, GetCategoryDTO.class)).toList());
    }

    public void updateCategory(Long id, UpdateCategoryDTO category) {
        Category categoryToUpdate = getCategoryById(id);
        if (category.getDescription() != null){
            categoryToUpdate.setDescription(category.getDescription());
        }
        if (category.getTypeId() != null){
            categoryToUpdate.setType(TypeService.getTypeById(category.getTypeId()));
        }
        categoryRepository.save(categoryToUpdate);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
    }

}
