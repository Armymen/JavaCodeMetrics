package pl.pecet.javacodemetrics.core.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class JcmUser {
	
	@Id
	private String id;

	@Indexed(unique = true)
	private final String name;

	private String password;

	private final List<String> roles;

	private List<String> projects;
}
