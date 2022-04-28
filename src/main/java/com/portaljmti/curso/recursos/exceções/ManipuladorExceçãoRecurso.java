package com.portaljmti.curso.recursos.exceções;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portaljmti.curso.serviços.exeções.ExceçãoDatabase;
import com.portaljmti.curso.serviços.exeções.ExceçãoRecursoNãoEncontrado;

@ControllerAdvice
public class ManipuladorExceçãoRecurso {

	@ExceptionHandler(ExceçãoRecursoNãoEncontrado.class)
	public ResponseEntity<ErroPadrão> RecursoNãoEncontrado(ExceçãoRecursoNãoEncontrado e,
			HttpServletRequest solicitação) {
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrão err = new ErroPadrão(Instant.now(), status.value(), erro, e.getMessage(),
				solicitação.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ExceçãoDatabase.class)
	public ResponseEntity<ErroPadrão> database(ExceçãoDatabase e,
			HttpServletRequest solicitação) {
		String erro = "Erro de banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrão err = new ErroPadrão(Instant.now(), status.value(), erro, e.getMessage(),
				solicitação.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
