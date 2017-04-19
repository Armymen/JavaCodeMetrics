package pl.pecet.javacodemetrics.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.pecet.javacodemetrics.core.domain.JcmUser;

public interface UserRepository extends MongoRepository<JcmUser, String> {

	JcmUser findByName(final String name);
}
