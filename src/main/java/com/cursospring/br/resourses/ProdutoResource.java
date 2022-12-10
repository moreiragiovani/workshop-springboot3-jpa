package com.cursospring.br.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.br.entities.ProdutoEntitie;
import com.cursospring.br.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoEntitie>> findAll(){
		List<ProdutoEntitie> listaUsuario = service.findAll();
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoEntitie> findById(@PathVariable Long id){
		ProdutoEntitie user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	
}
