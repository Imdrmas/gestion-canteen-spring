package com.gestion.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.canteen.modal.RecipeMeal;

public interface RecipeMealDao extends JpaRepository<RecipeMeal, Long> {

}
