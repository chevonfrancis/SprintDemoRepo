package com.qa.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //this tells Spring its a table
public class Girl {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO-INCREMENT
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Integer age;
	
	@Column(nullable=false)
	private String hairColor;
	
	//CONSTRUCTORS
	public Girl(Integer id, String name, Integer age, String hairColor) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
	}

	public Girl() {
		super();
	}

	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	//TO STRING METHOD
	@Override
	public String toString() {
		return "Girl [id=" + id + ", name=" + name + ", age=" + age + ", hairColor=" + hairColor + "]";
	}
	
	
}
