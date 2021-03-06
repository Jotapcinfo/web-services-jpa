package com.portaljmti.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portaljmti.curso.entidades.Produto;
import com.portaljmti.curso.serviços.ServiçoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {

	@Autowired
	private ServiçoProduto serviço;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = serviço.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = serviço.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
