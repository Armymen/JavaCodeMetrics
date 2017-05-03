package pl.pecet.javacodemetrics.core.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "projects")
@CompoundIndexes({ @CompoundIndex(name = "name_username", def = "{'name' : 1, 'username': 1}", unique = true) })
public class Project {

	@Id
	private String id;

	private final String name;

	private final String username;

	private List<CodeMetrics> codeMetrics;
}
