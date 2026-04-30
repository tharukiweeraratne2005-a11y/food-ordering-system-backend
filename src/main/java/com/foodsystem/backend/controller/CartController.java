package com.foodsystem.backend.controller;

import com.foodsystem.backend.entity.CartItem;
import com.foodsystem.backend.service.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public List<CartItem> getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addItemToCart(item);
    }

    @PutMapping("/update/{itemId}")
    public CartItem updateQuantity(@PathVariable Long itemId, @RequestParam Integer quantity) {
        return cartService.updateItemQuantity(itemId, quantity);
    }

    @DeleteMapping("/remove/{itemId}")
    public void removeFromCart(@PathVariable Long itemId) {
        cartService.removeItem(itemId);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCartByUserId(userId);
    }
}