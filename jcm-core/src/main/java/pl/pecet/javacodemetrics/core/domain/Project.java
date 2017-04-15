package pl.pecet.javacodemetrics.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "projects")
public class Project {

	@Id
	private String id;

	private final String name;
}
