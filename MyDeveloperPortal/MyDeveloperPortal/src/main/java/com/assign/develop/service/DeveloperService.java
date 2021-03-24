package com.assign.develop.service;

import java.util.List;

import com.assign.develop.model.Developer;

public interface DeveloperService {

	public boolean createDeveloper(Developer developer);

	public List<Developer> getAllDeveloperDetails();

	public Developer getDeveloper(Long id);

	public boolean updateDeveloper(Developer developer, Long id);

}
