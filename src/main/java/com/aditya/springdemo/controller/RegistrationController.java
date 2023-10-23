package com.aditya.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aditya.springdemo.entity.Employee;
import com.aditya.springdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class RegistrationController {

	// need to inject our Employee service
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get Employees from the service
		List<Employee> theEmployees = employeeService.getEmployees();
				
		// add the Employees to the model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the Employee using our service
		employeeService.saveEmployee(theEmployee);			
		return "redirect:/index.jsp";
	}
	
	@PostMapping("/login")
	public String loginEmployee(Employee theEmployee, ModelMap theModel) {
		
		List<Employee> dbEmployees = employeeService.getEmployeeByLoginId(theEmployee.getLoginId());
		if (dbEmployees== null || dbEmployees.isEmpty()) {
			theModel.addAttribute("message", "No user found");
			return "redirect:/login.jsp";
			
		} else {
			Employee dbEmployee = dbEmployees.get(0);
			if (!theEmployee.getPassword().equals(dbEmployee.getPassword())) {
				theModel.addAttribute("message", "Password mismatch");
				return "redirect:/login.jsp";
			}
		}
		
		return "redirect:/employee/list";
	}	
}









