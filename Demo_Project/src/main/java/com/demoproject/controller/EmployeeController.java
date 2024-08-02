package com.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.model.Employee;
import com.demoproject.servicei.EmployeeServiceI;

import jakarta.transaction.Transactional;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceI esi;
	
	@PostMapping("/savedata")
	public Employee saveEmployee(@RequestBody Employee e) 
	{
		esi.saveEmployee(e);
		return e;		
	}
	
	@GetMapping("/getdata")
	public List<Employee> getAllEmployee( ) 
	{
		List<Employee> list=esi.getAllEmployee();
		return list;	
	}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable ("empId") int empId) 
	{
		esi.deleteEmployee(empId);
		
		return "delete success";
	}
	
	@PutMapping("/update/{empId}")
    public String updateEmployee(@RequestBody Employee e,@PathVariable("empId") int empId)
	{
		e.setEmpId(empId);	
		esi.saveEmployee(e);
		
		return "update successfully";	
	}
	
	@GetMapping("/getsingleemp/{empId}")
	public Employee getSingleEmployee(@PathVariable ("empId") int empId) 
	{
		Employee e = esi.getSingleEmployee(empId);
		
		return e;
		
	}
	
}
