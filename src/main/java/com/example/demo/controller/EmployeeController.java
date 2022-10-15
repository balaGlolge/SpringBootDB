package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	//get mapping to get all the records from the database
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//post mapping to save the employee detail in the database
	@PostMapping("/employee")
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
		logger.info("employeeService Implementation: saveEmployee");
		Employee emp = employeeService.saveEmplyoee(employee);
		return ResponseEntity.ok().body(emp);
	}
	
	//get mapping to retrieves the detail of a specific employee
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<Employee>> getEmpById(@PathVariable("id") int id){
		Optional<Employee> emp = employeeService.getEmpById(id);
		return ResponseEntity.ok().body(emp);
	}
	
	//put mapping to update the employee detail
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		employeeService.updateEmployee(employee, id);
		return employee;
	}
	
	//delete mapping to delete a specified employee 
	@DeleteMapping("/employee/{id}")
	public void deleteEmpoyee(@PathVariable("id") int id) {
		employeeService.deleteEmpById(id);
		return;
	}
	
	//get mapping to retrieve all employees with same city
	@GetMapping("/fetchCity	/{city}")
	public ResponseEntity<List<Employee>> getEmpByCity(@PathVariable("city") String city){
		List<Employee> cityList = employeeService.getEmpByCity(city);
		return ResponseEntity.ok().body(cityList);
	}
}
