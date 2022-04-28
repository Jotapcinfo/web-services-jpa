package com.portaljmti.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portaljmti.curso.entidades.Categoria;
import com.portaljmti.curso.serviços.ServiçoCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria {

	@Autowired
	private ServiçoCategoria serviço;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = serviço.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = serviço.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
