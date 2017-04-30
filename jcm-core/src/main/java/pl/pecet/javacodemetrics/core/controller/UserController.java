package pl.pecet.javacodemetrics.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.pecet.javacodemetrics.core.domain.JcmUser;
import pl.pecet.javacodemetrics.core.security.auth.JwtAuthenticationRequest;
import pl.pecet.javacodemetrics.core.security.auth.JwtTokenUtil;
import pl.pecet.javacodemetrics.core.service.UserService;

@RestController
public class UserController {

	@Value("${jwt.header}")
	private String tokenHeader;

	private final UserService userService;

	private final UserDetailsService userDetailsService;

	private final JwtTokenUtil jwtTokenUtil;

	public UserController(final UserService userService, final UserDetailsService userDetailsService,
			final JwtTokenUtil jwtTokenUtil) {
		this.userService = userService;
		this.userDetailsService = userDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@GetMapping("user")
	public UserDetails getCurrentUser(final HttpServletRequest request) {
		final String token = request.getHeader(tokenHeader);
		final String username = jwtTokenUtil.getUsernameFromToken(token);
		return userDetailsService.loadUserByUsername(username);
	}

	@PostMapping("createUser")
	public JcmUser create(@RequestBody final JwtAuthenticationRequest userCredentials) {
		return userService.create(userCredentials.getUsername(), userCredentials.getPassword());
	}
}
