package com.portaljmti.curso.serviços.exeções;

public class ExceçãoRecursoNãoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExceçãoRecursoNãoEncontrado(Object id) {
		super("Recurso não encontrado. Id " + id);
	}
}
