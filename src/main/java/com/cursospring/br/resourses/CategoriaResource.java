package com.cursospring.br.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.br.entities.CategoriaEntitie;
import com.cursospring.br.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriaEntitie>> findAll(){
		List<CategoriaEntitie> listaUsuario = service.findAll();
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaEntitie> findById(@PathVariable Long id){
		CategoriaEntitie user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	
}
