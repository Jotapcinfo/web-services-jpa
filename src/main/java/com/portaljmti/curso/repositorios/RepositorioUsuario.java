package com.portaljmti.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portaljmti.curso.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
