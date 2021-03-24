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
import com.assign.develop.service.DeveloperService;

import java.util.List;

@Scope(value = "session")
@Join(path = "/", to = "/view/list_developers.jsf")
@Component(value = "listDevelopers")
@ELBeanName(value = "listDevelopers")
public class ListDevelopersController {

	@Autowired
	private DeveloperService developerService;

	private List<Developer> developerModels;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getDefaultDevelopersList() {
		developerModels = developerService.getAllDeveloperDetails();
	}

	public List<Developer> getAllDevelopersList() {
		return developerModels;
	}

}
