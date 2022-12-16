package com.cursospring.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cursospring.br.entities.UsuarioEntities;
import com.cursospring.br.repository.UsuarioRepository;
import com.cursospring.br.services.exceptions.DatabaseException;
import com.cursospring.br.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioEntities> findAll (){
		return repository.findAll();
	}
	
	public UsuarioEntities findById (Long id) {
		Optional<UsuarioEntities> userObj = repository.findById(id);
		return userObj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public UsuarioEntities insertUsuario(UsuarioEntities user) {
		return repository.save(user);
	}
	
	public void deleteUsuario(Long id) {
		try {
			repository.deleteById(id);			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public UsuarioEntities updateUsuario(Long id, UsuarioEntities user) {
		UsuarioEntities usuario = repository.getReferenceById(id);
		updateUser(usuario, user);
		return repository.save(usuario);
	}

	private void updateUser(UsuarioEntities usuario, UsuarioEntities user) {
		usuario.setNome(user.getNome());
		usuario.setEmail(user.getEmail());
		usuario.setTelefone(user.getTelefone());
		
	}
	
}
