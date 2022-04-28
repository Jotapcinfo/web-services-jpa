package com.portaljmti.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portaljmti.curso.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
