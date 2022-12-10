package com.cursospring.br.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.br.entities.PedidoEntitie;
import com.cursospring.br.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<PedidoEntitie>> findAll(){
		List<PedidoEntitie> listaUsuario = service.findAll();
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoEntitie> findById(@PathVariable Long id){
		PedidoEntitie user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<PedidoEntitie> createUsuario(@RequestBody PedidoEntitie user){
		service.createUsuario(user);
		return new ResponseEntity<PedidoEntitie>(HttpStatus.CREATED);
				
	}
	
}
