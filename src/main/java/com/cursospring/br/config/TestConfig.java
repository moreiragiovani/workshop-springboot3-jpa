package com.cursospring.br.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursospring.br.entities.UsuarioEntities;
import com.cursospring.br.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public void run(String... args) throws Exception {
		UsuarioEntities u1 = new UsuarioEntities(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		UsuarioEntities u2 = new UsuarioEntities(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		repository.saveAll(Arrays.asList(u1, u2));		
	}
	
	
	
	
}
