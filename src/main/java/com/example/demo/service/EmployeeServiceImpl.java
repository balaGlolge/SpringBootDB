package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/*To get all employees list*/

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(empList ->employeeList.add(empList));;
		return employeeList;
	}
	
	/*To save employee*/
	
	@Override
	public Employee saveEmplyoee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/*To get an employee by ID*/
	
	@Override
	public Optional<Employee> getEmpById(int id) {
		return employeeRepository.findById(id);
	}

	/*To update the employee*/

	@Override
	public void updateEmployee(Employee employee, int id) {
		employeeRepository.save(employee);
	}
	
	/*To delete the employee*/
	
	@Override
	public void deleteEmpById(int id) {
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> getEmpByCity(String city){
		List<Employee> cityList = employeeRepository.getEmpByCity(city);
		return cityList;
	}

}
