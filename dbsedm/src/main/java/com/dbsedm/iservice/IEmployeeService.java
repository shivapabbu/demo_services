package com.dbsedm.iservice;

import java.util.List;

import com.dbsedm.model.Employee;

public interface IEmployeeService {

	public void addEmployee(Employee employee);

	public List<Employee> viewEmployees();

	public void editEmployee(Employee employee);

	public Employee viewEmployee(Integer employeeId);

	public void deleteEmployee(Integer employeeId);
}
