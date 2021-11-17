package com.dbsedm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbsedm.iservice.IEmployeeService;
import com.dbsedm.model.Employee;
import com.dbsedm.repo.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> viewEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public void editEmployee(Employee employee) {
		Employee emp = employeeRepository.findByCode(employee.getCode());
		if (emp != null) {
			emp.setCode(employee.getCode());
			emp.setEmailId(employee.getEmailId());
			employeeRepository.save(emp);
		}
	}

	@Override
	public Employee viewEmployee(Integer code) {
		Employee emp = employeeRepository.findByCode(code);
		return emp;
	}

	@Override
	public void deleteEmployee(Integer code) {
		Employee emp = employeeRepository.findByCode(code);
		if (emp != null) {
			employeeRepository.delete(emp);
		}
	}

}
