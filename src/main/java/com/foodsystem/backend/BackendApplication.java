package com.foodsystem.backend;

import com.foodsystem.backend.entity.FoodItem;
import com.foodsystem.backend.entity.FoodStatus;
import com.foodsystem.backend.repository.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(FoodItemRepository repository) {
		return args -> {

			if (repository.count() == 0) {
				List<FoodItem> foodList = List.of(
						new FoodItem(null, "Classic Beef Burger", "Juicy beef patty with cheddar cheese", 1250.0,
								"https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Cheese Pizza", "Mozzarella and parmesan with tomato sauce", 2100.0,
								"https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Chicken Kottu", "Sri Lankan style spicy shredded roti", 980.0,
								"https://images.pexels.com/photos/12737657/pexels-photo-12737657.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Pasta Carbonara", "Creamy white sauce with bacon and eggs", 1550.0,
								"https://images.pexels.com/photos/1437267/pexels-photo-1437267.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Club Sandwich", "Toasted bread with chicken and egg", 890.0,
								"https://images.pexels.com/photos/1600711/pexels-photo-1600711.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Mixed Fried Rice", "Basmati rice with chicken and prawns", 1150.0,
								"https://images.pexels.com/photos/3926124/pexels-photo-3926124.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Chicken Wings", "Spicy buffalo wings with blue cheese dip", 1400.0,
								"https://images.pexels.com/photos/2338407/pexels-photo-2338407.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Greek Salad", "Cucumbers, tomatoes and feta cheese", 750.0,
								"https://images.pexels.com/photos/1213710/pexels-photo-1213710.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "BBQ Pork Ribs", "Slow-cooked ribs with BBQ sauce", 2450.0,
								"https://images.pexels.com/photos/410648/pexels-photo-410648.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Chocolate Lava Cake", "Warm cake with molten center", 480.0,
								"https://images.pexels.com/photos/45202/brownie-dessert-cake-sweet-45202.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Cheesecake", "Creamy cheesecake with strawberries", 590.0,
								"https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Beef Steak", "Grilled beef steak with garlic butter", 3200.0,
								"https://images.pexels.com/photos/675951/pexels-photo-675951.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Iced Latte", "Cold brewed coffee with milk", 650.0,
								"https://images.pexels.com/photos/2615323/pexels-photo-2615323.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Vanilla Milkshake", "Thick and creamy vanilla milkshake", 780.0,
								"https://images.pexels.com/photos/3727250/pexels-photo-3727250.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Mushroom Soup", "Rich mushroom soup with croutons", 550.0,
								"https://images.pexels.com/photos/539451/pexels-photo-539451.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null),
						new FoodItem(null, "Chicken Tandoori", "Roasted chicken in Indian spices", 1650.0,
								"https://images.pexels.com/photos/12737656/pexels-photo-12737656.jpeg?auto=compress&cs=tinysrgb&w=500",
								FoodStatus.AVAILABLE, null));

				repository.saveAll(foodList);
				System.out.println(">> Database Success: 20 Items with images added!");
			}
		};
	}
}