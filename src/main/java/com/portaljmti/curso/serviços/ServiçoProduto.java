package com.portaljmti.curso.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portaljmti.curso.entidades.Produto;
import com.portaljmti.curso.repositorios.RepositorioProduto;

@Service
public class ServiçoProduto {

	@Autowired
	private RepositorioProduto repositorio;

	public List<Produto> findAll() {
		return repositorio.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
