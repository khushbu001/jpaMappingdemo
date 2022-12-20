package com.example.jpa.jparelationshipdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.jparelationshipdemo.entity.Employee;
import com.example.jpa.jparelationshipdemo.repo.EmpRepo;
import com.example.jpa.jparelationshipdemo.repo.EmpaddressRepo;


@Service
public class EmployeeService {
	Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private EmpaddressRepo addresssRepo;
	

	public Employee createEmployee(Employee employee) {

		LOG.info("EmployeeService::createEmployee::Start");
		Employee emp = empRepo.save(employee);
		LOG.info("EmployeeService::createEmployee::End");

		return emp;
	}

	public Employee updateEmployee(Long empId, Employee employee) {

		LOG.info("EmployeeService::updateEmployee::Start");
		LOG.debug("empId: {}, employee: {}", empId, employee);

		Optional<Employee> updateEmployee = empRepo.findById(empId);
		LOG.debug("employee: {}", employee);
		Employee emp = new Employee();
		if (updateEmployee.isPresent()) {
			emp = updateEmployee.get();
		}
		emp.setEmpId(empId);
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
		emp.setEmpAddress(employee.getEmpAddress());
	

		LOG.info("EmployeeService::updateEmployee::End");
		return emp;

	}

	public void deleteEmpById(Long empId) {
		LOG.info("EmployeeService::deleteEmpById::Start");
		LOG.debug("empId: {}", empId);

		empRepo.deleteById(empId);

		LOG.info("EmployeeService::deleteEmpById::End");
	}

	public Employee getOneEmployee(Long empId) {

		LOG.info("EmployeeService::getOneEmployee::Start");

		LOG.debug("empId: {}", empId);
		Optional<Employee> emp = empRepo.findById(empId);
		Employee employee = new Employee();
		if (emp.isPresent()) {
			employee = emp.get();
		}
		LOG.info("EmployeeService::getOneEmployee::End");

		return employee;
	}

	public List<Employee> getAllEmployee() {

		LOG.debug("EmployeeService::getAllEmployee::Start");

		List<Employee> allEmployee = new ArrayList<>();
		empRepo.findAll().forEach(allEmployee::add);

		LOG.debug("EmployeeService::getAllEmployee::End");

		return allEmployee;
	}



}
