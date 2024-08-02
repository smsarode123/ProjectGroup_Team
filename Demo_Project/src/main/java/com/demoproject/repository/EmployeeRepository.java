package com.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	void deleteByEmpId(int empId);

	Employee findByEmpId(int empId);

	

}
