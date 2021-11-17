package com.dbsedm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbsedm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee findByCode(Integer code);

}
