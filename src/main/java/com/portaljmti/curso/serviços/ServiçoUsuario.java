package com.portaljmti.curso.serviços;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.portaljmti.curso.entidades.Usuario;
import com.portaljmti.curso.repositorios.RepositorioUsuario;
import com.portaljmti.curso.serviços.exeções.ExceçãoDatabase;
import com.portaljmti.curso.serviços.exeções.ExceçãoRecursoNãoEncontrado;

@Service
public class ServiçoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ExceçãoRecursoNãoEncontrado(id));
	}

	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ExceçãoRecursoNãoEncontrado(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExceçãoDatabase(e.getMessage());
		}
	}

	public Usuario Update(Long id, Usuario obj) {
		try {
		Usuario entidade = repositorio.getById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ExceçãoRecursoNãoEncontrado(id);
		}
	}

	private void updateData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setFone(obj.getFone());
	}
}
