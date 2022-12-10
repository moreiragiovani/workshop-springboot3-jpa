package com.cursospring.br.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursospring.br.entities.PedidoEntitie;
import com.cursospring.br.entities.UsuarioEntities;
import com.cursospring.br.repository.PedidoRepository;
import com.cursospring.br.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		UsuarioEntities u1 = new UsuarioEntities(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		UsuarioEntities u2 = new UsuarioEntities(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		PedidoEntitie o1 = new PedidoEntitie(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 
		PedidoEntitie o2 = new PedidoEntitie(null, Instant.parse("2019-07-21T03:42:10Z"), u2); 
		PedidoEntitie o3 = new PedidoEntitie(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		repository.saveAll(Arrays.asList(u1, u2));	
		
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
	
	
}
