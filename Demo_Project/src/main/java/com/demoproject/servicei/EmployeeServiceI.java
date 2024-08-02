package com.demoproject.servicei;

import java.util.List;

import com.demoproject.model.Employee;

public interface EmployeeServiceI {

	void saveEmployee(Employee e);

	List<Employee> getAllEmployee();

	void deleteEmployee(int empId);

	Employee getSingleEmployee(int empId);

	

}
