package com.common.classes;

public class Employee {

	private Integer age;
	private String name;
	
	

	public Employee(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Employee(Integer age) {
		super();
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
