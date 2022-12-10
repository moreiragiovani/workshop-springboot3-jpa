package com.cursospring.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.br.entities.ProdutoEntitie;
import com.cursospring.br.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public List<ProdutoEntitie> findAll (){
		return repository.findAll();
	}
	
	public ProdutoEntitie findById (Long id) {
		Optional<ProdutoEntitie> userObj = repository.findById(id);
		return userObj.get();
	}
	

	
}
