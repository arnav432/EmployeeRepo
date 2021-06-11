package com.project.services;


import java.util.List;

import com.project.entities.Employee;

public interface EmployeeService {
	
	public boolean addEmployee(Employee employee);

	List<Employee> getAllEmployees();
	
	
}
