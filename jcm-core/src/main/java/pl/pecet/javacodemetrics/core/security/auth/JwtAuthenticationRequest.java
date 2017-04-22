package pl.pecet.javacodemetrics.core.security.auth;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {
	
	private final String username;
	
	private final String password;
}
