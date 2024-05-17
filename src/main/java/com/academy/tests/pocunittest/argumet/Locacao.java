package com.academy.tests.pocunittest.argumet;

import java.time.LocalDate;

public class Locacao {

	private String filme;
	private LocalDate dataLocacao;


	// Construtor, getters e setters

	public String getFilme() {
		return filme;
	}

	public void setFilme( String filme ) {
		this.filme = filme;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao( LocalDate dataLocacao ) {
		this.dataLocacao = dataLocacao;
	}

}
