package com.example.api.service;

import java.util.List;

import com.example.api.entity.Developer;


public interface DeveloperService {

	public Developer createDeveloper(Developer developer);

	public List<Developer> getAllDeveloperDetails();

	public Developer updateDeveloper(Developer developer, Long id);

	public void deleteDeveloper(Long id);
}
