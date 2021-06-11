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
public class EducationalQualification {
	//sequenceForId
	@Id
	@SequenceGenerator(name = "sequenceForId",sequenceName = "sequenceForId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceForId")
	private int id;
	
	@Column
	@NotNull(message = "Start date cannot be empty")
	private int startDate;
	
	@Column
	@NotNull(message = "End date cannot be empty")
	private int endDate;
	
	@Column
	@NotBlank(message = "type should not be empty")
	private String type;
	
	@Column
	@NotBlank(message = "Instituition should not be empty")
	private String instituition;
	
	@Column
	private String gender;
	
	@Column
	@NotBlank(message = "Percentage should not be empty")
	private String percentage;
	
	@Column
	@NotBlank(message = "Address should not be empty")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstituition() {
		return instituition;
	}

	public void setInstituition(String instituition) {
		this.instituition = instituition;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EducationalQualification [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", type="
				+ type + ", instituition=" + instituition + ", gender=" + gender + ", percentage=" + percentage
				+ ", address=" + address + "]";
	}

	
	
	
	
}
