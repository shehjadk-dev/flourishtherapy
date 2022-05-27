package com.flourishtherapy.core.models;

import java.util.List;

public class Employee {
	
	//Attributes
	private Name name;
	private int age;
	private List<Address> address;
	private boolean canBeManager;
	
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public boolean isCanBeManager() {
		return canBeManager;
	}
	public void setCanBeManager(boolean canBeManager) {
		this.canBeManager = canBeManager;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
	
}
