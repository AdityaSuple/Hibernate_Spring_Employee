package com.aditya.springdemo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aditya.springdemo.entity.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();

	void saveEmployee(Employee theEmployee);

	Employee getEmployee(int theId);

	void deleteEmployee(int theId);
	
	List<Employee> getEmployeeByLoginId(String loginId);

}