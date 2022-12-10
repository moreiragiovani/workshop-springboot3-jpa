package com.cursospring.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.br.entities.CategoriaEntitie;
import com.cursospring.br.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public List<CategoriaEntitie> findAll (){
		return repository.findAll();
	}
	
	public CategoriaEntitie findById (Long id) {
		Optional<CategoriaEntitie> userObj = repository.findById(id);
		return userObj.get();
	}
	

	
}
