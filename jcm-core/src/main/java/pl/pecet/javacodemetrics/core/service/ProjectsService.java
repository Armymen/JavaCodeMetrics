package pl.pecet.javacodemetrics.core.service;

import org.springframework.stereotype.Service;

import pl.pecet.javacodemetrics.core.domain.Project;
import pl.pecet.javacodemetrics.core.repository.ProjectsRepository;

@Service
public class ProjectsService {

	private final ProjectsRepository projectsRepository;

	public ProjectsService(final ProjectsRepository projectsRepository) {
		this.projectsRepository = projectsRepository;
	}

	public Project addNewProject(final String name) {
		return projectsRepository.insert(new Project());
	}
}
