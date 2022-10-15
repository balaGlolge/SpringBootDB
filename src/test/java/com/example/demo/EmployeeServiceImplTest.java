package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

	@InjectMocks
	 EmployeeServiceImpl employeeService;
	
	@Mock
	 EmployeeRepository employeeRepository;
	
	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("Lord Corlys");
		employee.setCity("Driftmark");
		employee.setId(18);
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.saveEmplyoee(employee));
	}
	
	/*@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("Lord Corlys");
		employee.setCity("Driftmark");
		employee.setId(18);
		employeeRepository.save(employee);
		employeeRepository.deleteById(employee.getId());
		Optional<Employee> expEmployee = employeeRepository.findById(employee.getId());
		assertEquals(null, expEmployee);
	}*/
	
	@Test
	public void getAllEmployeeTest() {
		List<Employee> empList = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setName("Lord Corlys");
		employee.setCity("Driftmark");
		employee.setId(18);
		
		Employee employee1 = new Employee();
		employee1.setName("Lord Corlys");
		employee1.setCity("Driftmark");
		employee1.setId(18);
		
		empList.add(employee1);
		empList.add(employee);
		
		when(employeeRepository.findAll()).thenReturn(empList);
		Iterable<Employee> list = employeeService.getAllEmployees();
		assertEquals(empList, list);
	}
}
