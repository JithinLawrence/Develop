package com.example.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Developer;
import com.example.api.exception.CustomException;
import com.example.api.service.DeveloperService;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
	final Map<String, Object> map = new HashMap<>();

	@Autowired
	DeveloperService developerService;

	@PostMapping
	public ResponseEntity<?> createDeveloper(@RequestBody Developer developerData) {

		developerService.createDeveloper(developerData);
		map.put("message", "Developer created Successfully");
		return new ResponseEntity<Map>(map, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getAllDevelopers(Developer developerData) {

		List<Developer> getDeveloper = developerService.getAllDeveloperDetails();
		return new ResponseEntity<>(getDeveloper, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateDeveloper(@RequestBody Developer developerData,
			@PathVariable(required = true) Long id) {
		if (id < 0) {
			throw new CustomException("id less than zero");
		}
		developerService.updateDeveloper(developerData, id);
		map.put("message", "Developer Updated Successfully");
		return new ResponseEntity<Map>(map, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDeveloper(@PathVariable(required = true) Long id) {

		if (id < 0) {
			throw new CustomException("id less than zero");
		}
		developerService.deleteDeveloper(id);
		map.put("message", "Developer deleted Successfully: " + id);
		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}

	@ExceptionHandler
	public String handleCustomException(CustomException exception) {
		return exception.getMessage();
	}

}
