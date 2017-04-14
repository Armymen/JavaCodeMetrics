package pl.pecet.javacodemetrics.core.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.pecet.javacodemetrics.core.repository.ProjectsRepository;

public class ProjectsService {

	@Autowired
	private ProjectsRepository projectsRepository;
}
