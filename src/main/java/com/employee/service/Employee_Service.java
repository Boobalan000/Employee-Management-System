package com.employee.service;

import java.util.List;
import com.employee.entity.Employee;

public interface Employee_Service {
	
	List<Employee> getAllEmployee();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	Employee UpdateEmployee(Employee employee);
	
	void deleteEmployee(Long id);
}
