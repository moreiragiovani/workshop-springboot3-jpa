package com.cursospring.br.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.br.entities.UsuarioEntities;
import com.cursospring.br.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioEntities>> findAll(){
		List<UsuarioEntities> listaUsuario = service.findAll();
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioEntities> findById(@PathVariable Long id){
		UsuarioEntities user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioEntities> insertUsuario(@RequestBody UsuarioEntities user){
		user = service.insertUsuario(user);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
		service.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioEntities> updateUsuario(@PathVariable Long id, @RequestBody UsuarioEntities user){
		user = service.updateUsuario(id, user);
		return ResponseEntity.ok().body(user);
	}
	
}
