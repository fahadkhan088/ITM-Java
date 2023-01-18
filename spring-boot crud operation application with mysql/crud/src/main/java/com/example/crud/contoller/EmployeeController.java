package com.example.crud.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(path = "/addEmployee")
	public Employee addEmployee(@RequestBody Employee e) {
		return service.saveEmployee(e);
	}
	
	@GetMapping(path = "/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	@PutMapping(path = "/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee e) {
		return service.updateEmployee(e);
	}
	@DeleteMapping(path = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	
	
	
	
	
	

}
