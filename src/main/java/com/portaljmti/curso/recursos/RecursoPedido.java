package com.portaljmti.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portaljmti.curso.entidades.Pedido;
import com.portaljmti.curso.serviços.ServiçoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {

	@Autowired
	private ServiçoPedido serviço;

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = serviço.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = serviço.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
