package pl.pecet.javacodemetrics.core.security.auth;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

	private final String token;
}
