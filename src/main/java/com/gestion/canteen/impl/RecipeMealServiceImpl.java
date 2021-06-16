package com.gestion.canteen.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.canteen.dao.CookDao;
import com.gestion.canteen.dao.MealDao;
import com.gestion.canteen.dao.RecipeMealDao;
import com.gestion.canteen.modal.Cook;
import com.gestion.canteen.modal.Meal;
import com.gestion.canteen.modal.RecipeMeal;
import com.gestion.canteen.service.RecipeMealService;

@Transactional
@Component
public class RecipeMealServiceImpl implements RecipeMealService {
	
	@Autowired
	RecipeMealDao recipeMealDao;
	
	@Autowired
	CookDao cookDao;
	
	@Autowired
	MealDao mealDao;

	@Override
	public RecipeMeal addRecipeMeal(RecipeMeal recipeMeal, long id) {
		Meal meal = mealDao.getById(id);
		meal.addRecipeMeal(recipeMeal);
		return recipeMealDao.save(recipeMeal);
	}

	@Override
	public RecipeMeal addRecipeMealToCook(RecipeMeal recipeMeal, long id) {
		Cook cook = cookDao.getById(id);
		cook.addRecipeMealToCook(recipeMeal);
		return recipeMealDao.save(recipeMeal);
	}

	@Override
	public RecipeMeal updateRecipeMeal(RecipeMeal recipeMeal, long id) {
		RecipeMeal existRecipeMeal = recipeMealDao.getById(id);
		existRecipeMeal.setDescription(recipeMeal.getDescription());
		existRecipeMeal.setName(recipeMeal.getName());
		existRecipeMeal.setPhoto(recipeMeal.getPhoto());
		return recipeMealDao.save(existRecipeMeal);
	}

	@Override
	public void deleteRecipeMeal(long id) {
		recipeMealDao.deleteById(id);
	}

	@Override
	public RecipeMeal findRecipeMeal(long id) {
		return recipeMealDao.findById(id).get();
	}

	@Override
	public List<RecipeMeal> findRecipeMeals() {
		return recipeMealDao.findAll();
	}

	@Override
	public List<RecipeMeal> findRecipeMealsForMeal(long id) {
		Meal meal = mealDao.getById(id);
		return meal.getRecipeMeals();
	}

}
