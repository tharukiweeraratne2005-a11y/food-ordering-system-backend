package com.foodsystem.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;

    @Enumerated(EnumType.STRING)
    private FoodStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}