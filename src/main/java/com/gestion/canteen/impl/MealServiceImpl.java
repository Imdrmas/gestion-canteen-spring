package com.gestion.canteen.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.canteen.dao.CanteenDao;
import com.gestion.canteen.dao.MealDao;
import com.gestion.canteen.dao.RecipeMealDao;
import com.gestion.canteen.modal.Canteen;
import com.gestion.canteen.modal.Meal;
import com.gestion.canteen.modal.RecipeMeal;
import com.gestion.canteen.service.MealService;

@Transactional
@Component
public class MealServiceImpl implements MealService {
	
	@Autowired
	CanteenDao canteenDao;
	
	@Autowired
	MealDao mealDao;
	
	@Autowired
	RecipeMealDao recipeMealDao;

	@Override
	public Meal addMeal(Meal meal, long id, long idRecipe) {
		Canteen canteen = canteenDao.getById(id);
		RecipeMeal recipeMeal = recipeMealDao.getById(idRecipe);
		meal.addRecipeMeal(recipeMeal);
		canteen.addMeal(meal);
		return mealDao.save(meal);
	}

	@Override
	public Meal updateMeal(Meal meal, long id) {
		Meal existMeal = mealDao.getById(id);
		return mealDao.save(existMeal);
	}

	@Override
	public void deleteMeal(long id) {		
		mealDao.deleteById(id);		
	}

	@Override
	public Meal findMeal(long id) {
		return mealDao.findById(id).get();
	}

	@Override
	public List<Meal> findMeals(long id) {
		Canteen canteen = canteenDao.findById(id).get();
		return canteen.getMeals();
	}

	@Override
	public List<RecipeMeal> findRecipesForMeal(long id) {
		Meal existMeal = mealDao.findById(id).get();
		return existMeal.getRecipeMeals();
	}

}
