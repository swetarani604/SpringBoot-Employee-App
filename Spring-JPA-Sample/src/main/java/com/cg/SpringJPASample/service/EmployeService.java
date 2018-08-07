package com.cg.SpringJPASample.service;


import java.util.List;

import com.cg.SpringJPASample.bean.Employee;
import com.cg.SpringJPASample.exception.EmployeeException;


public interface EmployeService{
	
	Employee createEmployee(Employee employee) throws EmployeeException;
	Employee updateEmployee(Employee employee) throws EmployeeException;
	String deleteEmployee(String id) throws EmployeeException;
	List<Employee> getAllEmployee() throws EmployeeException;
	Employee getEmployeeById(String id) throws EmployeeException;
	
}
