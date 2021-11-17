package com.dbsactivity.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dbsactivity.dto.EmployeeDto;

public interface EmployeeClient {

	@GetMapping("/api/employee/{code}")
	public ResponseEntity<EmployeeDto> viewEmployee(@PathVariable(name = "code") Integer code);
}
