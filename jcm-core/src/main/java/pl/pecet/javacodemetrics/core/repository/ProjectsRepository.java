package pl.pecet.javacodemetrics.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.pecet.javacodemetrics.core.domain.Project;

public interface ProjectsRepository extends MongoRepository<Project, String> {

	Project findOneByUsernameAndName(String username, String name);
}
