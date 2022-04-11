package com.qa.demo.domain;

public class Girl {
	
	//ATTRIBUTES
	private Integer id;
	private String name;
	private Integer age;
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
