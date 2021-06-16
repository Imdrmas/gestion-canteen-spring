package com.gestion.canteen.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class RecipeMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private String photo;
	
	@JsonBackReference(value = "cook")
	@ManyToOne
	private Cook cook;

	public RecipeMeal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeMeal(String name, String description, String photo, Cook cook) {
		super();
		this.name = name;
		this.description = description;
		this.photo = photo;
		this.cook = cook;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Cook getCook() {
		return cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}
	
	
}