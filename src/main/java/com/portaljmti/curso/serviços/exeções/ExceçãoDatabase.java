package com.portaljmti.curso.serviços.exeções;

public class ExceçãoDatabase extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceçãoDatabase(String msg) {
		super(msg);
	}
}
