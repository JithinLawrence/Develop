package com.sample.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restapi.domain.EmployeeData;
import com.sample.restapi.exception.CustomException;
import com.sample.restapi.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeData empData) {

		EmployeeData empDetails = employeeService.createEmployee(empData);
		return new ResponseEntity<>(empDetails, HttpStatus.CREATED);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable(required = true) Long empId) {

		EmployeeData empDetails = employeeService.getEmployeeDetails(empId);
		return new ResponseEntity<>(empDetails, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployee(EmployeeData empData) {

		List<EmployeeData> empDetails = employeeService.getAllEmployeeDetails();
		return new ResponseEntity<>(empDetails, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeData empData) {
		if (null == empData.getId() || empData.getId() <= 0) {
			throw new CustomException("Invalid Id");
		}
		EmployeeData empDetails = employeeService.updateEmployee(empData);

		return new ResponseEntity<>(empDetails, HttpStatus.OK);

	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(required = true) Long empId) {

		try {
			if (empId < 0) {

			}
			employeeService.deleteEmployee(empId);
		} catch (Exception e) {
			throw new CustomException("Error while deleting records");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("message", "Record deleted : " + empId);

		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}

}
