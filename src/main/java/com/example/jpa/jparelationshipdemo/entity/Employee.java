package com.example.jpa.jparelationshipdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // table A
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	private String name;

	private Integer age;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empAddress")
	private EmpAddress empAddress;

	public Employee() {
		super();
	}

	public Employee(Long empId, String name, Integer age, EmpAddress empAddress) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.empAddress = empAddress;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public EmpAddress getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(EmpAddress empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", empAddress=" + empAddress + "]";
	}

}