package com.assign.develop.service;

import java.util.List;

import com.assign.develop.model.Skills;

public interface SkillsService {

	public List<Skills> getAllSkills();

	public Skills getSkills(Long id);
}
