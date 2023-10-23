package com.aditya.springdemo.dao;

import java.util.List;

import com.aditya.springdemo.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getEmployees();

	void saveEmployee(Employee theEmployee);

	Employee getEmployee(int theId);

	void deleteEmployee(int theId);

	List<Employee> getEmployeeByLoginId(String theLoginId);

}