package pl.pecet.javacodemetrics.core.controller;

import org.springframework.web.bind.annotation.RestController;

import pl.pecet.javacodemetrics.core.service.ProjectsService;

@RestController
public class ProjectsController {

	private final ProjectsService projectsService;

	public ProjectsController(final ProjectsService projectsService) {
		this.projectsService = projectsService;
	}
}
