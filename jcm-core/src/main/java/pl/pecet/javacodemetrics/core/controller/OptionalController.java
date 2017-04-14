package pl.pecet.javacodemetrics.core.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionalController {

	@GetMapping("/optionals")
	public String getOptionals() {
		Optional<String> o1 = Optional.of("Hello, ");
		Optional<String> o2 = Optional.of("World!");
		
		return o1.flatMap(first -> o2.flatMap(sec -> Optional.of(first + sec))).get();
	}
}
