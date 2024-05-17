package com.academy.tests.pocunittest.argumet;

import java.time.LocalDate;

public class LocadoraService {

	private LocadoraDao locadoraDao;

	public void salvarLocacao(Locacao locacao) {

		var newLocacao = new Locacao();
		newLocacao.setFilme(locacao.getFilme());
		newLocacao.setDataLocacao( LocalDate.now() );
		locadoraDao.saveLocacao(newLocacao);
	}


}
