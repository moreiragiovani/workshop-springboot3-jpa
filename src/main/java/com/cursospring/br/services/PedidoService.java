package com.cursospring.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.br.entities.PedidoEntitie;
import com.cursospring.br.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	public List<PedidoEntitie> findAll (){
		return repository.findAll();
	}
	
	public PedidoEntitie findById (Long id) {
		Optional<PedidoEntitie> userObj = repository.findById(id);
		return userObj.get();
	}
	
	
}
