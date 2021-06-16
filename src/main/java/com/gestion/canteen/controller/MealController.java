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

import com.gestion.canteen.modal.Meal;
import com.gestion.canteen.modal.RecipeMeal;
import com.gestion.canteen.service.MealService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class MealController {

	@Autowired
	MealService mealService;
	
	@PostMapping("/addMeal/{id}/{idRecipe}")
	Meal addMeal(@RequestBody Meal meal, @PathVariable long id, @PathVariable long idRecipe) {
		return mealService.addMeal(meal, id, idRecipe);
	}
	@PutMapping("/updateMeal/{id}")
	Meal updateMeal(@RequestBody Meal meal, @PathVariable long id) {
		return mealService.updateMeal(meal, id);
	}
	@DeleteMapping("/deleteMeal/{id}")
	void deleteMeal(@PathVariable long id) {
		mealService.deleteMeal(id);
	}
	@GetMapping("/findMeal/{id}")
	Meal findMeal(@PathVariable long id) {
		return mealService.findMeal(id);
	}
	@GetMapping("/findMeals/{id}")
	List<Meal> findMeals(@PathVariable long id) {
		return mealService.findMeals(id);
	}
	@GetMapping("/findRecipesForMeal/{id}")
	List<RecipeMeal> findRecipesForMeal(@PathVariable long id) {
		return mealService.findRecipesForMeal(id);
	}
}
