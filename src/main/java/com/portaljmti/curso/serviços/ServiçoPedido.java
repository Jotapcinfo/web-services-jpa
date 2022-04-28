package com.portaljmti.curso.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portaljmti.curso.entidades.Pedido;
import com.portaljmti.curso.repositorios.RepositorioPedido;

@Service
public class ServiçoPedido {

	@Autowired
	private RepositorioPedido repositorio;

	public List<Pedido> findAll() {
		return repositorio.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
