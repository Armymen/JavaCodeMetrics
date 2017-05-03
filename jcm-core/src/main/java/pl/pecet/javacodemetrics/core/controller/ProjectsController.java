package pl.pecet.javacodemetrics.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.pecet.javacodemetrics.core.domain.Project;
import pl.pecet.javacodemetrics.core.security.auth.JwtTokenUtil;
import pl.pecet.javacodemetrics.core.service.ProjectsService;

@RestController
public class ProjectsController {

	@Value("${jwt.header}")
	private String tokenHeader;

	private final ProjectsService projectsService;

	private final JwtTokenUtil jwtTokenUtil;

	public ProjectsController(final ProjectsService projectsService, final JwtTokenUtil jwtTokenUtil) {
		this.projectsService = projectsService;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@GetMapping("projects")
	public List<Project> getAllProjects() {
		return projectsService.getAllProjects();
	}

	@GetMapping("projects/{name}")
	public Project getProject(final HttpServletRequest request, @PathVariable final String name) {
		return projectsService.getProject(getUsername(request), name);
	}

	@PostMapping("projects/add/{name}")
	public Project addNewProject(final HttpServletRequest request, @PathVariable final String name) {
		return projectsService.addNewProject(getUsername(request), name);
	}

	private String getUsername(final HttpServletRequest request) {
		final String token = request.getHeader(tokenHeader);
		return jwtTokenUtil.getUsernameFromToken(token);
	}
}
