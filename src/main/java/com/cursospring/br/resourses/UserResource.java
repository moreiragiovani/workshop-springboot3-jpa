package com.cursospring.br.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.br.entities.UsuarioEntities;

@RestController
@RequestMapping(value = "/usuario")
public class UserResource {

	public ResponseEntity<UsuarioEntities> findAll(){
		return null;
	}
}
