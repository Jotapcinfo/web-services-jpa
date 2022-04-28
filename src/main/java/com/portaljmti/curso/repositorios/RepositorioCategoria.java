package com.portaljmti.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portaljmti.curso.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
