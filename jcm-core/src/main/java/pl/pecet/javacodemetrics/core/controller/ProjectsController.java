package pl.pecet.javacodemetrics.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pl.pecet.javacodemetrics.core.service.ProjectsService;

@RestController
public class ProjectsController {

	private final ProjectsService projectsService;

	@Autowired
	public ProjectsController(final ProjectsService projectsService) {
		this.projectsService = projectsService;
	}
}
