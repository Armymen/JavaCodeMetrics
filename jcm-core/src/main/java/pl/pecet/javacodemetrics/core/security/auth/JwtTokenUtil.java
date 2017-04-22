package pl.pecet.javacodemetrics.core.security.auth;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String generateToken(final UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername()).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String getUsernameFromToken(final String token) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (final Exception e) {
			username = null;
		}

		return username;
	}

	public Boolean validateToken(final String token, final UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Date generateExpirationDate() {
		return Date.from(Instant.now().plusSeconds(expiration));
	}

	private Claims getClaimsFromToken(final String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (final Exception e) {
			claims = null;
		}

		return claims;
	}

	private Boolean isTokenExpired(final String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(Date.from(Instant.now()));
	}

	private Date getExpirationDateFromToken(final String token) {
		Date expiration;
		try {
			expiration = getClaimsFromToken(token).getExpiration();
		} catch (final Exception e) {
			expiration = null;
		}
		return expiration;
	}
}
