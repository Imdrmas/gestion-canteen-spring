package com.gestion.canteen.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Canteen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String open;
	
	private String close;
	
	private int capacity;
	
	@JsonBackReference(value = "cooks")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "canteen")
	private List<Cook> cooks;
	
	@JsonBackReference(value = "meals")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "canteen")
	private List<Meal> meals;	


	public Canteen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Canteen(String open, String close, int capacity, List<Cook> cooks, List<Meal> meals) {
		super();
		this.open = open;
		this.close = close;
		this.capacity = capacity;
		this.cooks = cooks;
		this.meals = meals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}  

	public List<Cook> getCooks() {
		return cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public void addMeal(Meal meal) {
		if (getMeals()==null) {
			this.meals = new ArrayList<>();
		}
		getMeals().add(meal);
		meal.setCanteen(this);
	}
	
	public void addCook(Cook cook) {
		if (getCooks()==null) {
			this.cooks = new ArrayList<>();
		}
		getCooks().add(cook);
		cook.setCanteen(this);
	}
}
