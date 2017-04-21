package pl.pecet.javacodemetrics.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.Project;
import pl.pecet.javacodemetrics.core.service.ProjectsService;

@RestController
@AllArgsConstructor
public class ProjectsController {

	private final ProjectsService projectsService;

	@GetMapping("projects")
	public List<Project> getAllProjects() {
		return projectsService.getAllProjects();
	}

	@GetMapping("project/{name}")
	public Project getProject(@PathVariable final String name) {
		return projectsService.getProject(name);
	}

	@PostMapping("addNewProject/{name}")
	public Project addNewProject(@PathVariable final String name) {
		return projectsService.addNewProject(name);
	}
}
