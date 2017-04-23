package pl.pecet.javacodemetrics.core.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.Project;
import pl.pecet.javacodemetrics.core.repository.ProjectsRepository;

@Service
@Transactional
@AllArgsConstructor
public class ProjectsService {

	private final ProjectsRepository projectsRepository;

	public Project addNewProject(final String name) {
		return projectsRepository.save(new Project(name));
	}

	public List<Project> getAllProjects() {
		return projectsRepository.findAll();
	}

	public Project getProject(final String name) {
		return projectsRepository.findByName(name);
	}
}
