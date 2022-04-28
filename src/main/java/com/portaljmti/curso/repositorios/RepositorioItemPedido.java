package com.portaljmti.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portaljmti.curso.entidades.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, Long> {

}
