package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.entities.Employee;
import com.project.repositories.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);


	@Override
	public Employee addEmployee(Employee employee) {
		Employee employeeSaved = new Employee();
		
		try {
			logger.info("Adding employee to database : {}",employee);
			employeeSaved = employeeRepo.save(employee);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return employeeSaved;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> listOfEmployees= new ArrayList<>();
		
		try {
			logger.info("Fetching all employees");
			listOfEmployees = employeeRepo.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return listOfEmployees;
	}

}
