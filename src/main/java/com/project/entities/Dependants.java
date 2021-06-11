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
public class Dependants {
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
	@NotBlank(message = "Last name should not be empty")
	@Length(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
	private String lastName;
	
	@Column
	@NotNull(message = "Birth date cannot be empty")
	private int dateOfBirth;
	
	@Column
	@NotBlank(message = "Relationship should not be empty")
	private String relationship;
	
	@Column
	private String gender;

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

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Dependants [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", relationship=" + relationship + ", gender=" + gender + "]";
	}
	
	
	
}
