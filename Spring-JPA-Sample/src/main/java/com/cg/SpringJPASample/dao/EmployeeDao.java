package com.cg.SpringJPASample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.SpringJPASample.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, String>{
	
	/*@Query(value="UPDATE Employee E SET E.salary=(:N) WHERE E.eid=(:I)")
	Employee updateEmployee(@Param(value="N")double salary, @Param(value="I")String id);*/
	
}
