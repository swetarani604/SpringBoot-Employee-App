package com.cg.SpringJPASample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.SpringJPASample.bean.Employee;
import com.cg.SpringJPASample.dao.EmployeeDao;
import com.cg.SpringJPASample.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeService {

	@Autowired
	private EmployeeDao empldao;
	
	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		//predef
		if(validateEmpl(employee))
			empldao.save(employee);
		return employee; 
	}

	@Override
	public String deleteEmployee(String id) throws EmployeeException{
		// TODO Auto-generated method stub
		//predef
		empldao.deleteById(id);
		return id;
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		//predef
		return empldao.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) throws EmployeeException{
		// TODO Auto-generated method stub
		return empldao.getOne(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee employee2 = getEmployeeById(employee.getEid());
		employee2.setSalary(employee.getSalary());
		return empldao.save(employee2);
	}
	
	private boolean validateEmpl(Employee empl) throws EmployeeException {
		if(empl==null)
			throw new EmployeeException("Employee doesnot exist");
		if(empl.getSalary()<0)
			throw new EmployeeException("Salary must be more than zero");
		if(empl.getEname().isEmpty())
			throw new EmployeeException("Name cannot be empty");
		if(!empl.getEname().matches("[A-Za-z]{2,}"))
			throw new EmployeeException("Employee Name must have only alphabets");
		if(empl.getProject().isEmpty())
			throw new EmployeeException("Project name should not be empty");
		return true;
	}

}
