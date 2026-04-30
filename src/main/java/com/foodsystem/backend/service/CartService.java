package com.foodsystem.backend.service;

import com.foodsystem.backend.entity.CartItem;
import com.foodsystem.backend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    
    public List<CartItem> getCartByUserId(Long userId) {
        return cartItemRepository.findByCartId(userId);
    }

    
    public CartItem addItemToCart(CartItem item) {
        return cartItemRepository.save(item);
    }

    
    public CartItem updateItemQuantity(Long itemId, Integer quantity) {
        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }

    
    public void removeItem(Long itemId) {
        cartItemRepository.deleteById(itemId);
    }

    
    public void clearCartByUserId(Long userId) {
        List<CartItem> items = cartItemRepository.findByCartId(userId);
        cartItemRepository.deleteAll(items);
    }
}