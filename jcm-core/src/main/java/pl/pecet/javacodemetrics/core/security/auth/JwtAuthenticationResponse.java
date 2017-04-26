package pl.pecet.javacodemetrics.core.security.auth;

import java.util.List;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
	
	private final String username;

	private final String token;
	
	private final List<String> projects;
}
