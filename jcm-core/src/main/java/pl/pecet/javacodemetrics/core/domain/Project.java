package pl.pecet.javacodemetrics.core.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Project {

	@Id
	private String id;

	private final String name;

}
