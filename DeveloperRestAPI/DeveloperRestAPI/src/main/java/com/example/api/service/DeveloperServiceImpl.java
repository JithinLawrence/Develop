package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.api.entity.Developer;
import com.example.api.exception.CustomException;
import com.example.api.repository.DeveloperRepository;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	DeveloperRepository developerRepo;

	@Override
	public Developer createDeveloper(Developer developer) {
		Developer saveDeveloper = developerRepo.save(developer);
		return saveDeveloper;
	}

	@Override
	public List<Developer> getAllDeveloperDetails() {
		List<Developer> getAllDeveloper = developerRepo.findAll();
		return getAllDeveloper;
	}

	@Override
	public Developer updateDeveloper(Developer developer,Long id) {
		Developer updateDeveloperInfo;
		try {
			updateDeveloperInfo = developerRepo.findById(id).get();
			if (updateDeveloperInfo == null) {
				throw new CustomException("No Record Found");
			}
			developer.setId(id);
			return developerRepo.save(developer);
		} catch (Exception e) {
			throw new CustomException("Error While Updating Record");
		}
	}

	@Override
	public void deleteDeveloper(Long id) {
		Developer deleteDeveloperInfo;
		try {
			deleteDeveloperInfo = developerRepo.findById(id).get();
			if (deleteDeveloperInfo == null) {
				throw new CustomException("No Record Found");
			}
			developerRepo.delete(deleteDeveloperInfo);
		} catch (Exception e) {
			throw new CustomException("Unable to delete");
		}

	}

}
