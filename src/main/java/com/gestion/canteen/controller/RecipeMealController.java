package com.gestion.canteen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.canteen.modal.RecipeMeal;
import com.gestion.canteen.service.RecipeMealService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class RecipeMealController {

	@Autowired
	RecipeMealService recipeMealService;
	
	@PostMapping("/addRecipeMeal/{id}")
	RecipeMeal addRecipeMeal(@RequestBody RecipeMeal recipeMeal, @PathVariable long id) {
		return recipeMealService.addRecipeMeal(recipeMeal, id);
	}
	
	@PostMapping("/addRecipeMealToCook/{id}")
	RecipeMeal addRecipeMealToCook(@RequestBody RecipeMeal recipeMeal, @PathVariable long id) {
		return recipeMealService.addRecipeMealToCook(recipeMeal, id);
	}
	@PutMapping("/updateRecipeMeal/{id}")
	RecipeMeal updateRecipeMeal(@RequestBody RecipeMeal recipeMeal, @PathVariable long id) {
		return recipeMealService.updateRecipeMeal(recipeMeal, id);
	}
	@DeleteMapping("/deleteRecipeMeal/{id}")
	void deleteRecipeMeal(@PathVariable long id) {
		recipeMealService.deleteRecipeMeal(id);
	}
	@GetMapping("/findRecipeMeal/{id}")
	RecipeMeal findRecipeMeal(@PathVariable long id) {
		return recipeMealService.findRecipeMeal(id);
	}
	@GetMapping("/findRecipeMeals")
	List<RecipeMeal> findRecipeMeals() {
		return recipeMealService.findRecipeMeals();
	}
	@GetMapping("/findRecipeMealsForMeal/{id}")
	List<RecipeMeal> findRecipeMealsForMeal(@PathVariable long id) {
		return recipeMealService.findRecipeMealsForMeal(id);
	}
}
