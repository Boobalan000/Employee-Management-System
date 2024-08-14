package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entity.Employee;
import com.employee.service.Employee_Service;


@Controller
@RequestMapping("/")
public class Employee_Controller {
	
	@Autowired
	private Employee_Service employee_service;
	
	
	@GetMapping("/")
	public String listOfEmployee(Model model)
	{
		model.addAttribute("employees", employee_service.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("/new")
	public String createEmployeeForm(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	
	@PostMapping("/")
	public String saveEmployee(@ModelAttribute("employee")Employee employee)
	{
		employee_service.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("employee", employee_service.getEmployeeById(id));
		return "edit_employee";	}
	
	@PostMapping("/{id}")
	public String UpdateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee, Model model)
	{
		Employee existing_employee=employee_service.getEmployeeById(id);
		existing_employee.setId(id);
		existing_employee.setFirstname(employee.getFirstname());
		existing_employee.setLastname(employee.getLastname());
		existing_employee.setEmail(employee.getEmail());
		existing_employee.setDesignation(employee.getDesignation());
		existing_employee.setSalary(employee.getSalary());
		
		employee_service.UpdateEmployee(existing_employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employee_service.deleteEmployee(id);
		return "redirect:/";
	}
}
