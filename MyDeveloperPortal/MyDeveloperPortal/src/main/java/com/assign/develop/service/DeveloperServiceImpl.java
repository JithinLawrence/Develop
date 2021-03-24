package com.assign.develop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.develop.exception.CustomException;
import com.assign.develop.model.Developer;
import com.assign.develop.repository.DeveloperRepo;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	DeveloperRepo developerepo;

	@Override
	public boolean createDeveloper(Developer developer) {

		Developer developerCreate = developerepo.save(developer);
		if (null != developerCreate.toString())
			return true;

		return false;
	}

	@Override
	public List<Developer> getAllDeveloperDetails() {
		List<Developer> allDeveloper = developerepo.findAll();
		return allDeveloper;
	}

	@Override
	public Developer getDeveloper(Long id) {
		Optional<Developer> developerById = developerepo.findById(id);
		if (!developerById.isPresent()) {
			throw new CustomException("No Record Found");
		}
		return developerById.get();
	}

	public boolean updateDeveloper(Developer developersModel, Long id) {

		Developer developerEntity = developerepo.save(developersModel);
		if (null != developerEntity.toString())
			return true;
		return false;
	}

}
