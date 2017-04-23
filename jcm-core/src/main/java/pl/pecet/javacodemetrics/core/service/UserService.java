package pl.pecet.javacodemetrics.core.service;

import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.JcmUser;
import pl.pecet.javacodemetrics.core.repository.UserRepository;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public JcmUser create(final String username, final String password) {
		final JcmUser newUser = new JcmUser(username, new BCryptPasswordEncoder().encode(password),
				Arrays.asList("ROLE_USER"));

		return userRepository.save(newUser);
	}
}
