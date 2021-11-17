package com.dbsedm.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbsedm.dto.EmployeeDto;
import com.dbsedm.model.Employee;
import com.dbsedm.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
    private ModelMapper modelMapper;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/api/employee/add")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDto employee) {
		Employee emp = employeeService.viewEmployee(employee.getCode());
		if (ObjectUtils.isEmpty(emp)) {
			Employee empMapper = modelMapper.map(employee, Employee.class);

			employeeService.addEmployee(empMapper);
		}else {
			return new ResponseEntity<>("Employee with code "+employee.getCode()+" already exists", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Employee Details Added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/api/employee/")
	public ResponseEntity<List<Employee>> viewEmployees() {
		List<Employee> employees = employeeService.viewEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employee/{code}")
	public ResponseEntity<Employee> viewEmployee(@PathVariable(name = "code") Integer code) {
		Employee emp = employeeService.viewEmployee(code);
		if (ObjectUtils.isEmpty(emp)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}


	@PatchMapping("/api/employee/edit")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.viewEmployee(employee.getCode());
		if (ObjectUtils.isEmpty(emp)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			employeeService.editEmployee(employee);
		}
		return new ResponseEntity<>("Employee Details edited succesfully", HttpStatus.OK);
	}

}
