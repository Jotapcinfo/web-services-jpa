package com.portaljmti.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portaljmti.curso.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
