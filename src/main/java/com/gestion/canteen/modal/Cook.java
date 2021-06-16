package com.gestion.canteen.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstname;
	
	private String lastname;
	
	@JsonBackReference(value = "recipeMeals")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cook")
	private List<RecipeMeal> recipeMeals;
	
	@JsonBackReference(value = "canteen")
	@ManyToOne
	private Canteen canteen;

	public Cook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cook(String firstname, String lastname, List<RecipeMeal> recipeMeals, Canteen canteen) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.recipeMeals = recipeMeals;
		this.canteen = canteen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Canteen getCanteen() {
		return canteen;
	}

	public void setCanteen(Canteen canteen) {
		this.canteen = canteen;
	}

	public List<RecipeMeal> getRecipeMeals() {
		return recipeMeals;
	}

	public void setRecipeMeals(List<RecipeMeal> recipeMeals) {
		this.recipeMeals = recipeMeals;
	}
	
	public void addRecipeMealToCook(RecipeMeal recipeMeal) {
		if(getRecipeMeals()==null) {
			this.recipeMeals = new ArrayList<>();
		}
		getRecipeMeals().add(recipeMeal);
		recipeMeal.setCook(this);
	}

}
