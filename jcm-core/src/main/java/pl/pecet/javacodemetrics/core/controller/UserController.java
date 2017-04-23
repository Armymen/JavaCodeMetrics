package pl.pecet.javacodemetrics.core.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.JcmUser;
import pl.pecet.javacodemetrics.core.security.auth.JwtAuthenticationRequest;
import pl.pecet.javacodemetrics.core.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("createUser")
	public JcmUser create(@RequestBody final JwtAuthenticationRequest userCredentials) {
		return userService.create(userCredentials.getUsername(), userCredentials.getPassword());
	}
}
