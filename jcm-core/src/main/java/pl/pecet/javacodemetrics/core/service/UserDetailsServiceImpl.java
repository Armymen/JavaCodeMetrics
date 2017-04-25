package pl.pecet.javacodemetrics.core.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.domain.JcmUser;
import pl.pecet.javacodemetrics.core.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final JcmUser user = userRepository.findOneByName(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s not found.", username));
		}

		return new User(user.getName(), user.getPassword(), getAuthorities(user));
	}

	private Collection<SimpleGrantedAuthority> getAuthorities(final JcmUser user) {
		return user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
}
