package com.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="employee_details", uniqueConstraints= {@UniqueConstraint
		(name="email_name",columnNames="email")})
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name",nullable=false)
	private String firstname;
	
	@Column(name="last_name",nullable=false)
	private String lastname;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="designation",nullable=false)
	private String designation;
	
	@Column(name="salary", nullable=false)
	private long salary;
	
	
	
}
