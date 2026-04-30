package com.foodsystem.backend.controller;

import com.foodsystem.backend.entity.Category;
import com.foodsystem.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }
}