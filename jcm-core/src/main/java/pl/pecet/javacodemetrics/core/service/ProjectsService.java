package pl.pecet.javacodemetrics.core.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.Project;
import pl.pecet.javacodemetrics.core.repository.ProjectsRepository;

@Service
@AllArgsConstructor
public class ProjectsService {

	private final ProjectsRepository projectsRepository;

	public Project addNewProject(final String name) {
		return projectsRepository.insert(new Project(1L, "p1"));
	}
}
