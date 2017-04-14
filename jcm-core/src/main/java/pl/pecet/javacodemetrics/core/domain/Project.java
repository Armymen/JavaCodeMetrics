package pl.pecet.javacodemetrics.core.domain;

import org.springframework.data.annotation.Id;

public class Project {

	@Id
	private Long id;

	private String name;

}
