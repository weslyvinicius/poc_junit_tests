package com.academy.tests.pocunittest.argumet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@ExtendWith( MockitoExtension.class )
class LocadoraServiceTest {

	@InjectMocks
	private LocadoraService locadoraService;

	@Mock
	private LocadoraDao locadoraDao;

	@Test
	void salvarLocacao() {

		// Arrange
		Locacao locacao = new Locacao();
		locacao.setFilme("Filme 1");

		// Act
		locadoraService.salvarLocacao(locacao);

		// Assert

		// Dessa forma de veriry o teste será falho, pois o objeto locacao não é o mesmo que foi passado para o método salvarLocacao.
		//verify(locadoraDao).saveLocacao(locacao);

		// Para corrigir o teste, podemos usar o ArgumentCaptor para capturar o argumento passado para o método saveLocacao.
		// Criamos um ArgumentCaptor para a classe Locacao.
		ArgumentCaptor<Locacao> locacaoCaptor = ArgumentCaptor.forClass(Locacao.class);
		verify(locadoraDao).saveLocacao(locacaoCaptor.capture());

		// Recuperamos o argumento capturado com getValue() do ArgumentCaptor.
		Locacao capturedLocacao = locacaoCaptor.getValue();

		Assertions.assertThat(capturedLocacao.getFilme()).isEqualTo("Filme 1");
		Assertions.assertThat(capturedLocacao.getDataLocacao()).isEqualTo( LocalDate.now());


	}


}