package com.sample.restapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.restapi.domain.Employee;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${urlALL.path}")
	private String urlALL;

	@Value("${urlById.path}")
	private String urlById;

	@GetMapping("/all")
	public List<Employee> getCountries() {

		Employee objects = restTemplate.getForObject(urlALL, Employee.class);

		return Arrays.asList(objects);
	}

	@GetMapping("/{id}")
	public List<Employee> getCountriesByName(@PathVariable String id) {

		Employee objects = restTemplate.getForObject(urlById.concat(id), Employee.class);

		return Arrays.asList(objects);
	}

}