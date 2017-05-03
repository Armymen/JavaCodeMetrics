package pl.pecet.javacodemetrics.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.JcmUser;
import pl.pecet.javacodemetrics.core.domain.Project;
import pl.pecet.javacodemetrics.core.repository.ProjectsRepository;
import pl.pecet.javacodemetrics.core.repository.UserRepository;

@Service
@AllArgsConstructor
public class ProjectsService {

	private final ProjectsRepository projectsRepository;

	private final UserRepository userRepository;

	public Project addNewProject(final String username, final String name) {
		final JcmUser user = userRepository.findOneByName(username);

		if (user.getProjects() == null) {
			user.setProjects(new ArrayList<>());
		}
		user.getProjects().add(name);
		userRepository.save(user);

		return projectsRepository.save(new Project(name, username));
	}

	public List<Project> getAllProjects() {
		return projectsRepository.findAll();
	}

	public Project getProject(final String name) {
		return projectsRepository.findOneByName(name);
	}
}
