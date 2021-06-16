package com.gestion.canteen.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonBackReference(value = "canteen")
	@ManyToOne(cascade = CascadeType.ALL)
	private Canteen canteen;
	
	@JsonBackReference
	@ManyToMany(cascade = CascadeType.ALL)
	private List<RecipeMeal> recipeMeals;
	
	@JsonBackReference(value = "students")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meal")
	private List<Student> students;

	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meal(Canteen canteen, List<RecipeMeal> recipeMeals, List<Student> students) {
		super();
		this.canteen = canteen;
		this.recipeMeals = recipeMeals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addRecipeMeal(RecipeMeal recipeMeal) {
		if (getRecipeMeals()==null) {
			this.recipeMeals = new ArrayList<>();
		}
		if (!getRecipeMeals().contains(recipeMeal)) {
			getRecipeMeals().add(recipeMeal);
		}
	}
	
	public void addStudent(Student student) {
		if (getStudents()==null) {
			this.students = new ArrayList<>();
		}
		getStudents().add(student);
		student.setMeal(this);
	}
	
}
