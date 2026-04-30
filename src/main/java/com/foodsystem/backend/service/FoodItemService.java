package com.foodsystem.backend.service;

import com.foodsystem.backend.entity.FoodItem;
import com.foodsystem.backend.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItem saveFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }git add .

    public FoodItem updateFoodItem(Long id, FoodItem updatedItem) {
        return foodItemRepository.findById(id).map(food -> {
            food.setName(updatedItem.getName());
            food.setPrice(updatedItem.getPrice());
            food.setDescription(updatedItem.getDescription());
            food.setImage(updatedItem.getImage());
            return foodItemRepository.save(food);
        }).orElseThrow(() -> new RuntimeException("Food item not found"));
    }
}