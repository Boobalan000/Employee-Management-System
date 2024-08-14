package com.employee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.dao.Employee_DAO;
import com.employee.entity.Employee;
import com.employee.service.Employee_Service;

@Service
public class Employee_Service_Impl implements Employee_Service {

	@Autowired
	private Employee_DAO employee_dto;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employee_dto.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employee_dto.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employee_dto.findById(id).get();
	}

	@Override
	public Employee UpdateEmployee(Employee employee) {
		
		return employee_dto.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		employee_dto.deleteById(id);
		
	}
	
}
