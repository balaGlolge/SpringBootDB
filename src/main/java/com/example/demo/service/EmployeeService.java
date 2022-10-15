package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmplyoee(Employee employee);
	
	public Optional<Employee> getEmpById(int id);

	public List<Employee> getAllEmployees();

	public void updateEmployee(Employee employee, int id);

	public void deleteEmpById(int id);
	
	public List<Employee> getEmpByCity(String city);
}
