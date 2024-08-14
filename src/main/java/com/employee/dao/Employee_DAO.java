package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.Employee;

public interface Employee_DAO extends JpaRepository<Employee,Long>{
	
}
