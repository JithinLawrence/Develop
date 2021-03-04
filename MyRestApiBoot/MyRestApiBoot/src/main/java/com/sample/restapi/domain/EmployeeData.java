package com.sample.restapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "FIRST_NAME")
	@NotBlank(message = "Please provide valid First Name")
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotBlank(message = "Please provide valid Last Name")
	private String lastName;

	@Column(name = "DEPT")
	@NotBlank(message = "Please provide Department")
	private String department;

	@Column(name = "EMAIL", unique = true)
	@NotBlank(message = "Please provide valid Email")
	private String email;

	@Column(name = "AGE")
//	@NotBlank(message = "Please provide Age")
	private Integer age;

	@Column(name = "SALARY")
//	@NotBlank(message = "Please provide Salary")
	private Long salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	

	
	

}
