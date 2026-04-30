package com.foodsystem.backend.controller;

import com.foodsystem.backend.entity.FoodItem;
import com.foodsystem.backend.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin("*")
public class FoodController {
    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public FoodItem addFood(@RequestBody FoodItem foodItem) {
        return foodItemService.saveFoodItem(foodItem);
    }

    @GetMapping
    public List<FoodItem> getAll() {
        return foodItemService.getAllFoodItems();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
    }

    @PutMapping("/{id}")
    public FoodItem update(@PathVariable Long id, @RequestBody FoodItem foodItem) {
        return foodItemService.updateFoodItem(id, foodItem);
    }
}