package pl.pecet.javacodemetrics.core.controller;

import lombok.Data;

@Data
final class UserCredentials {
	private String login;

	private String password;
}
