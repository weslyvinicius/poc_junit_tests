package com.academy.tests.pocunittest.argumet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
class CalculadoraArgMockTest {

	@Test
	void somar1() {

		// Arrange
		CalculadoraArgMock calculadora = mock(CalculadoraArgMock.class);

		// O argument capture também pode ser utlizados na vase expectativas
		ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
		when(calculadora.somar(argumentCaptor.capture(), anyInt())).thenReturn(10);

		// Act
		int resultado = calculadora.somar(2, 3);

		// Assert
		assertEquals(10, resultado);
		assertEquals( 2, argumentCaptor.getValue()) ;
	}

	@Test
	void somar2() {

		// Arrange
		CalculadoraArgMock calculadora = mock(CalculadoraArgMock.class);

		// O argument capture também pode ser utlizados na vase expectativas
		ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
		when(calculadora.somar(argumentCaptor.capture(), argumentCaptor.capture())).thenReturn(10);


		// Act
		int resultado = calculadora.somar(2, 3);

		// Assert
		assertEquals(10, resultado);

		// Para capturar todos os valores passados deve ser utilizado o método getAllValues
		assertEquals( 2, argumentCaptor.getAllValues().get( 0 )) ;
		assertEquals( 3, argumentCaptor.getAllValues().get( 1 )) ;
	}
}