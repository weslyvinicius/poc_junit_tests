package com.academy.tests.pocunittest.argumet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith( MockitoExtension.class )
class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private EmailService emailService;


	@Test
	void registerUser() {

		// Arrange
		User user = new User("test@example.com", "Test User");

		// Act
		userService.registerUser(user);

		// Assert
		//Criamos um ArgumentCaptor para a classe User.
		ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

		//Usamos verify para garantir que o método sendWelcomeEmail foi chamado. capture() do ArgumentCaptor captura o argumento passado para sendWelcomeEmail.
		verify(emailService).sendWelcomeEmail(userCaptor.capture());
		User capturedUser = userCaptor.getValue(); //Recuperamos o argumento capturado com getValue() do ArgumentCaptor.

		assertEquals("test@example.com", capturedUser.getEmail());
		assertEquals("Test User", capturedUser.getName());
		//Verificamos se o usuário capturado tem o email e nome esperados com assertEquals.
	}
}