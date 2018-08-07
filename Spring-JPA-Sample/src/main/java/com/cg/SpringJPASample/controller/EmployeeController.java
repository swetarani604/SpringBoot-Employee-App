package com.cg.SpringJPASample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.SpringJPASample.bean.Employee;
import com.cg.SpringJPASample.exception.EmployeeException;
import com.cg.SpringJPASample.service.EmployeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeService service;
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) throws EmployeeException {
		try {
			return service.createEmployee(employee);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			throw new EmployeeException(e.getMessage());
		}
	}
	
	@RequestMapping(value="/updateEmployee", method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) throws EmployeeException {
		try {
			return service.updateEmployee(employee);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
	}
	
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.DELETE)
	public String deleteEmployee(String id) throws EmployeeException {
		try {
			return service.deleteEmployee(id)+"has been deleted...";
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Employee> getAllEmployee() throws EmployeeException{
		try {
			return service.getAllEmployee();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public Employee getEmployeeById(String id) throws EmployeeException{
		try {
			return service.getEmployeeById(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
	}
	
	
	
}
