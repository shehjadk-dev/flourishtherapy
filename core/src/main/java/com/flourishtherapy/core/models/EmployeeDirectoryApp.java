package com.flourishtherapy.core.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectoryApp {

	public static void main(String [] args) {
		
		// New employee object
		Address shehjadAddress1 = createAddress("2025 N Magnolia avenue", "3N", "Chicago", "IL", 60614);
		Address shehjadAddress2 = createAddress("2025 N Magnolia avenue", "3N", "Chicago", "IL", 60614);
		List<Address> shehjadAddresses = new ArrayList<>();
		
		Name shehjadName = createName("Shehjad", "", "Khan");
		shehjadAddresses.add(shehjadAddress1);
		shehjadAddresses.add(shehjadAddress2);
		
		
		Employee shehjad = createEmployee(shehjadName, 32, shehjadAddresses);
		

		Name abbyName = createName("Audrey", "Abigail", "Newman");
		Employee abby = createEmployee(abbyName, 26, shehjadAddresses);
		
		printEmployeeDetails(abby);
		printEmployeeDetails(shehjad);
		
		
	}
	
	private static Name createName(String firstName, String middleName, String lastName) {
		Name name = new Name();
		name.setFirstName(firstName);
		name.setMiddleName(middleName);
		name.setLastName(lastName);
		
		return name;
		
	}
	private static Address createAddress(String streetAddress1, String streetAddress2, String city, String state, int zipCode) {
		Address address = new Address();
		address.setStreetAddress1(streetAddress1);
		address.setStreetAddress2(streetAddress2);
		address.setCity(city);
		address.setState(state);
		address.setZipCode(zipCode);
		
		return address;
	}

	static void printEmployeeDetails(Employee employee)
	{
		Name name = employee.getName();
		System.out.println(" Employee " + name.getFirstName() + " " + name.getMiddleName() + " " + name.getLastName());
		System.out.println(name.getFirstName() + "'s age " + employee.getAge());
		System.out.println("Can this employee be manager :: "+ employee.isCanBeManager());
		
		//int count = 1;
	}
	
	static Employee createEmployee(Name name, int age, List<Address> addresses) 
	{
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAge(age);
		//List<String> employeeAddress = new ArrayList<>();
		
		if(age >=30) {
			employee.setCanBeManager(true);
		}else {
			employee.setCanBeManager(false);
		}
		
		return employee;
		
	}
	
	// create new employee
	// Print existing employee data
}
