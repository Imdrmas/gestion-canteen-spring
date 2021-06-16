package com.gestion.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.canteen.modal.Meal;

public interface MealDao extends JpaRepository<Meal, Long> {

}
