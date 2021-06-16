package com.gestion.canteen.service;

import java.util.List;

import com.gestion.canteen.modal.RecipeMeal;

public interface RecipeMealService {

	RecipeMeal addRecipeMeal(RecipeMeal recipeMeal, long id);
	
	RecipeMeal addRecipeMealToCook(RecipeMeal recipeMeal, long id);
	
	RecipeMeal updateRecipeMeal(RecipeMeal recipeMeal, long id);
	
	void deleteRecipeMeal(long id);
	
	RecipeMeal findRecipeMeal(long id);
	
	List<RecipeMeal> findRecipeMeals();
	
	List<RecipeMeal> findRecipeMealsForMeal(long id);
}
