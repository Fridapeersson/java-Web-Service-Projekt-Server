package com.example.demo.model;

public class User {
	
	//skapar vilken information som ska finnas om användarna
	private int id;
	private int age;
	private String name;
	private String city;
	private String pet;
	
	//konstruktor
	public User(int id,String name, int age, String city, String pet) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.city = city;
		this.pet = pet;
	}

	//Getters och setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}
}
