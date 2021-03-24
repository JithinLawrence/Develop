package com.assign.develop.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import com.assign.develop.model.Developer;
import com.assign.develop.model.Skills;
import com.assign.develop.service.DeveloperService;
import com.assign.develop.service.SkillsService;

import java.util.List;

@Scope(value = "session")
@Component(value = "createDeveloper")
@ELBeanName(value = "createDeveloper")
@Join(path = "/add_developer", to = "/view/add_developer.jsf")
public class AddDeveloperController {

	@Autowired
	private DeveloperService developerService;
	@Autowired
	private SkillsService skillService;

	private Developer developer = new Developer();
	private List<Skills> skills;

	public String submitForm() {
		boolean devDetail = developerService.createDeveloper(developer);
		if (devDetail == true) {
			return "/view/list_developers.xhtml?faces-redirect=true";
		}
		return null;
	}

	public Developer getDeveloperItems() {
		return developer;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getGeneralSkillsList() {
		skills = skillService.getAllSkills();
	}

	public List<Skills> getListOfSkills() {
		return skills;
	}

}
