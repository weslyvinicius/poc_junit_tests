package com.academy.tests.pocunittest.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class CalculatorMocksTest {

	@Mock
	private CalculatorMocks calculator;

	@Spy
	private CalculatorMocks spyCalculator;

	@Test
	void diferencaMockeSpy() {

		// Mock
		// O mock quando não sabe o que fazer, ele não faz nada retornando o valor default
		// Act
		System.out.println("Mock ");
		int result = calculator.add(2, 3);
		// Assert
		System.out.println("Result: " + result);

		// Spy
		// já o spy, ele chama o método original, por isso não pode ser utlizado em interfaces.

		System.out.println("Spy ");
		int resultSpy = spyCalculator.add(2, 3);
		// Assert
		System.out.println("Result: " + resultSpy );

	}

	@Test
	void diferencaMockeSpy2() {

		// Mock
		// Quando adicionado uma expectativa o mock e o spy se comportam da mesma forma
		// retorna o valor esperado



		when(calculator.add(2, 3)).thenReturn(10);
		when(spyCalculator.add(2, 3)).thenReturn(10);   // Atenção ao spay neste momento do when, o java por predefinição executa o método original chamando o método original
		                                                         // para resolver esse probleam use do doReturn.

		// Act
		System.out.println("Mock ");
		int result = calculator.add(2, 3);
		// Assert
		System.out.println("Result: " + result);

		// Spy
		System.out.println("Spy ");
		int resultSpy = spyCalculator.add(2, 3);   // Como o metodo já foi chamado no when, o método não é chamado novamente
		// Assert
		System.out.println("Result: " + resultSpy );

	}

	@Test
	void diferencaMockeSpy3() {

		// Mock
		when(calculator.add(2, 3)).thenReturn(10);
		when(spyCalculator.add(2, 3)).thenReturn(10);

		// Act
		System.out.println("Mock ");
		int result = calculator.add(2, 5);        // em casos que o valor passado seja diferente do valor esperado, o mock não sabe o que fazer e retorna o valor default
		// Assert
		System.out.println("Result: " + result);

		// Spy

		System.out.println("Spy ");
		int resultSpy = spyCalculator.add(2, 5); // já o spy chama o método original e retorna o valor calculado.
		// Assert
		System.out.println("Result: " + resultSpy );

	}

	@Test
	void diferencaMockeSpy4() {

		// Mock
		when(calculator.add(2, 3)).thenCallRealMethod(); // Informa para fazer a chamada original do método
		when(spyCalculator.add(2, 3)).thenReturn(10);

		// Act
		System.out.println("Mock ");
		int result = calculator.add(2, 3); // Neste momento pelo comando CallRealMethod chama o método original fazendo que seja execudado o método original e retornando o valor calculado.
		// Assert
		System.out.println("Result: " + result);

		// Spy

		System.out.println("Spy ");
		int resultSpy = spyCalculator.add(2, 3); // Já o spy retorna o valor da espectativa
		// Assert
		System.out.println("Result: " + resultSpy );

	}



	@Test
	void execucaoMetodosVoidMockeSpy() {

        //Nos caso de metodos void o mock segue a mesma regra do método void, não faz nada
		// já o spy chama o método original

		// Act
		System.out.println("Mock ");
		calculator.log( " metodo void mock " );
		// Assert



		// Spy
		System.out.println("Spy ");
		spyCalculator.log( "metodo void spy");
		// Assert


	}

	@Test
	void usandoDoNothingSpy() {

		// doNothing é usado para métodos void, para indicar que a chamada do método não deve fazer nada.
		// Isto é útil, por exemplo, quando você quer evitar que um método realmente execute sua lógica em um teste.

		// Por padrão o mock não executa o método original, já o spy não executa o metodo original

		// Arrange
		doNothing().when( calculator ).log( " metodo void mock " );
		doNothing().when( spyCalculator ).log( "metodo void spy");


		// Act
		System.out.println("Mock ");
		calculator.log( " metodo void mock " );
		// Assert



		// Spy
		System.out.println("Spy ");
		spyCalculator.log( "metodo void spy");
		// Assert


	}

	@Test
	void usandoDoReturn() {

		// doReturndoReturn é uma alternativa a when e é particularmente útil quando você está lidando com métodos que têm chamadas encadeadas
		// ou quando está trabalhando com mocks espiões (spy).
		// A principal diferença é que doReturn não avalia imediatamente seus argumentos.



		when(calculator.add(2, 3)).thenReturn(10);
		doReturn(10).when(spyCalculator).add(2, 3);   // o doReturn não executa o método original.
		// imagine o mestre yoda falando: "doReturn 10 quando executar metodo add com 2 e 3"
		// diferente do when que fala .. "quando executar metodo add com 2 e 3, retorne 10"

		// Act
		System.out.println("Mock ");
		int result = calculator.add(2, 3);
		// Assert
		System.out.println("Result: " + result);

		// Spy
		System.out.println("Spy ");
		int resultSpy = spyCalculator.add(2, 3); // dessa forma o metodo original não é chamado e retornado apenas a espectativa
		                                                // essa forma é mais eficiente quanto utilizada em metodos que depende de libarys externas em que não temos controle.
		                                                // para mocks, sendo que se utilizado when seria gerados exceções.
		// Assert
		System.out.println("Result: " + resultSpy );

	}





}