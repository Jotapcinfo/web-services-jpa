package com.portaljmti.curso.recursos.exceções;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrão implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;

	public ErroPadrão() {
	}

	public ErroPadrão(Instant timestamp, Integer status, String erro, String mensagem, String caminho) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
