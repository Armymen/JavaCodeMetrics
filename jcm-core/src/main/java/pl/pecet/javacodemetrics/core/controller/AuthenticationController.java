package pl.pecet.javacodemetrics.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.pecet.javacodemetrics.core.security.auth.JwtAuthenticationRequest;
import pl.pecet.javacodemetrics.core.security.auth.JwtAuthenticationResponse;
import pl.pecet.javacodemetrics.core.security.auth.JwtTokenUtil;

@RestController
public class AuthenticationController {

	@Value("${jwt.header}")
	private String tokenHeader;

	private final AuthenticationManager authenticationManager;

	private final JwtTokenUtil jwtTokenUtil;

	private final UserDetailsService userDetailsService;

	public AuthenticationController(final AuthenticationManager authenticationManager, final JwtTokenUtil jwtTokenUtil,
			final UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("${jwt.route.authentication.path}")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody final JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}

	@GetMapping("user")
	public UserDetails getAuthenticatedUser(final HttpServletRequest request) {
		final String token = request.getHeader(tokenHeader);
		final String username = jwtTokenUtil.getUsernameFromToken(token);
		return userDetailsService.loadUserByUsername(username);
	}
}
