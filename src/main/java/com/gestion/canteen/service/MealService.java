package com.gestion.canteen.service;

import java.util.List;

import com.gestion.canteen.modal.Meal;
import com.gestion.canteen.modal.RecipeMeal;

public interface MealService {
	
	Meal addMeal(Meal meal, long id, long idRecipe);
	
	Meal updateMeal(Meal meal, long id);
	
	void deleteMeal(long id);
	
	Meal findMeal(long id);
	
	List<Meal> findMeals(long id);
	
	List<RecipeMeal> findRecipesForMeal(long id);

}
