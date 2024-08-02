package com.demoproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.demoproject.model.Employee;
import com.demoproject.repository.EmployeeRepository;
import com.demoproject.servicei.EmployeeServiceI;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
	
	@Autowired
	EmployeeRepository er;

	@Override
	public void saveEmployee(Employee e) {
		er.save(e);		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return er.findAll();
	}

	@Transactional
	@Modifying
	@Override
	public void deleteEmployee(int empId) {
		er.deleteByEmpId(empId);
		
	}

	@Override
	public Employee getSingleEmployee(int empId) {
		
		return er.findByEmpId(empId);
	}

	


}
