package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.entities.Employee;

//@Service
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
}
