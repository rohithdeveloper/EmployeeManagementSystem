	package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
		@Autowired
		private EmployeeService empService;
		
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee employee){
			return empService.saveEmployee(employee);
		
			
		}
//		public ResponseEntity < Employee > addEmployee(@RequestBody Employee employee) {
//	        return ResponseEntity.ok().body(this.empService.saveEmployee(employee));
//	    }
		@GetMapping("/employees")
		public List<Employee> getEmployee(Employee employee){
			List<Employee> emp=empService.getAllEmployees();
			return emp;
			
		}
		
		@GetMapping("/employees/{id}")
		public Employee findById(@PathVariable int id)
		{
			return empService.getEmployeeById(id);
			
		}
		
		@DeleteMapping("/employees/{id}")
		public String deleteEmployee(@PathVariable int id)
		{
			return empService.deleteEmployee(id);
			
		}
		
		@PutMapping("/employees/{id}")
		public String updateEmployee(@PathVariable int id, @RequestBody Employee employee)
		{
			
			return empService.updateEmployee(id, employee) ;
			
		}
		@DeleteMapping("/employees")
		public String deleteAll() {
			empService.deleteAll();
			return "Successfully deleted all enitities";
		}
		
}
