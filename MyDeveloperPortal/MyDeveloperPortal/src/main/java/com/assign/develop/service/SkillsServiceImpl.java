package com.assign.develop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.develop.exception.CustomException;
import com.assign.develop.model.Skills;
import com.assign.develop.repository.SkillsRepo;

@Service
public class SkillsServiceImpl implements SkillsService {

	@Autowired
	SkillsRepo skillsrepo;

	@Override
	public List<Skills> getAllSkills() {
		List<Skills> skillsList = skillsrepo.findAll();
		return skillsList;
	}

	@Override
	public Skills getSkills(Long id) {
		Optional<Skills> skillsById = skillsrepo.findById(id);
		if (!skillsById.isPresent()) {
			throw new CustomException("No Record Found");
		}
		return skillsById.get();
	}

}
