package com.academy.tests.pocunittest.argumet;

public class UserService {
	private EmailService emailService;

	public UserService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void registerUser(User user) {
		// Lógica para registrar o usuário
		emailService.sendWelcomeEmail(user);
	}
}
