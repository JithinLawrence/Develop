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

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(value = "session")
@Component(value = "viewDeveloper")
@ELBeanName(value = "viewDeveloper")
@Join(path = "/view_developer/{id}", to = "/view/view-developers.jsf")
public class ViewDeveloperController {

	@Autowired
	DeveloperService developerService;
	@Autowired
	SkillsService skillService;

	private Developer developerModel = new Developer();
	private List<Skills> skillsModel;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getOneDeveloper() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String id = request.getParameter("id");
		developerModel = developerService.getDeveloper(Long.parseLong(id));
	}

	public Developer getDeveloper() {
		return developerModel;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getGeneralSkillsList() {
		skillsModel = skillService.getAllSkills();
	}

	public List<Skills> getSkillsList() {
		return skillsModel;
	}

	public String updateDeveloperSkills() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String id = request.getParameter("id");
		Developer currentDeveloperData = developerService.getDeveloper(Long.parseLong(id));
		String skillUpdate = currentDeveloperData.getSkills() + " , " + developerModel.getSkills();
		developerModel.setSkills(skillUpdate);
		boolean developerUpdated = developerService.updateDeveloper(developerModel, Long.parseLong(id));
		if (developerUpdated == true) {
			return "/view/view-developer/{id}";
		}
		return null;
	}

}
