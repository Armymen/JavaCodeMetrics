package pl.pecet.javacodemetrics.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.JcmUser;
import pl.pecet.javacodemetrics.core.security.auth.JwtAuthenticationRequest;
import pl.pecet.javacodemetrics.core.security.auth.JwtTokenUtil;
import pl.pecet.javacodemetrics.core.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@NonNull
	private final UserService userService;

	@NonNull
	private final UserDetailsService userDetailsService;

	@NonNull
	private final JwtTokenUtil jwtTokenUtil;

	@GetMapping("user")
	public UserDetails getCurrentUser(final HttpServletRequest request) {
		final String token = request.getHeader(tokenHeader);
		final String username = jwtTokenUtil.getUsernameFromToken(token);
		return userDetailsService.loadUserByUsername(username);
	}

	@PostMapping("users/create")
	public JcmUser create(@RequestBody final JwtAuthenticationRequest userCredentials) {
		return userService.create(userCredentials.getUsername(), userCredentials.getPassword());
	}

	@PostMapping("users/changePassword")
	public JcmUser changePassword(@RequestBody final JwtAuthenticationRequest userCredentials) {
		return userService.updatePassword(userCredentials.getUsername(), userCredentials.getPassword());
	}
}
