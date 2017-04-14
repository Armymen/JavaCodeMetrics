package pl.pecet.javacodemetrics.core.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.service.ProjectsService;

@RestController
@AllArgsConstructor
public class ProjectsController {

	private final ProjectsService projectsService;
}
