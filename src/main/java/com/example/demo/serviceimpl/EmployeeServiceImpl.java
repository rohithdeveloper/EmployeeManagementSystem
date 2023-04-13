package com.example.demo.serviceimpl;



import java.util.List

;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeDao;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list=employeedao.findAll();
		return list;
		
	}
	

	@Override
	public Employee saveEmployee(@RequestBody Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.save(employee);
	}

	@Override
	public String updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		 Optional<Employee> emp=employeedao.findById(id);
		 
		 if(emp.isPresent())
		 {
			 Employee updateEmpoyee=emp.get();
			 updateEmpoyee.setFirst_Name(employee.getFirst_Name());
			 updateEmpoyee.setLast_Name(employee.getLast_Name());
			 updateEmpoyee.setEmailId(employee.getEmailId());
			 employeedao.save(updateEmpoyee);
			 return "updated successfully";
		 }
		 else {
			 throw new EmployeeNotFoundException("Employee id not found"+id);
		 }
		
		 
	         
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		 Optional < Employee > emp = this.employeedao.findById(id);

	        if (emp.isPresent()) {
	            this.employeedao.delete(emp.get());
	        }
			return "Deleted successfully"; 
	}

	


	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee =employeedao.findById(id);
		return employee.get();
	}


	
	@Transactional
	public void deleteAll() {
		employeedao.deleteAll();
	}


	

}
