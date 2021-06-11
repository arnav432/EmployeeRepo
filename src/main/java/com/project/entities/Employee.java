package com.project.entities;

import javax.persistence.Column;

/*
 * Enitity class for employee
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;


@Entity
public class Employee {
	//sequenceForId
	@Id
	@SequenceGenerator(name = "sequenceForId",sequenceName = "sequenceForId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceForId")
	private int id;
	
	@Column
	@NotBlank(message = "First name should not be empty")
	@Length(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	@NotNull(message = "Employment id name cannot be empty")
	private int employmentId;
	
	@Column
	@NotNull(message = "Start date cannot be empty")
	private int startDate;
	
	@Column
	private String designation;
	
	@Column
	private String department;
	
	@Column
	private int endDate;
	
	@Column
	private String status;
	
	@Column
	@NotNull(message = "Birth date cannot be empty")
	private int dateOfBirth;
	
	@Column
	private String reportingManager;
	
	@Column
	private String gender;
	
	@Column
	private String bloodGroup;
	
	@Column
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(int employmentId) {
		this.employmentId = employmentId;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", employmentId="
				+ employmentId + ", startDate=" + startDate + ", designation=" + designation + ", department="
				+ department + ", endDate=" + endDate + ", status=" + status + ", dateOfBirth=" + dateOfBirth
				+ ", reportingManager=" + reportingManager + ", gender=" + gender + ", bloodGroup=" + bloodGroup
				+ ", address=" + address + "]";
	}
	
	
	
}
