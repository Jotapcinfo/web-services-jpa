package com.portaljmti.curso.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portaljmti.curso.entidades.Categoria;
import com.portaljmti.curso.repositorios.RepositorioCategoria;

@Service
public class ServiçoCategoria {

	@Autowired
	private RepositorioCategoria repositorio;

	public List<Categoria> findAll() {
		return repositorio.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
