package com.cursospring.br.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursospring.br.entities.CategoriaEntitie;
import com.cursospring.br.entities.PedidoEntitie;
import com.cursospring.br.entities.ProdutoEntitie;
import com.cursospring.br.entities.UsuarioEntities;
import com.cursospring.br.enums.PedidoStatus;
import com.cursospring.br.repository.CategoriaRepository;
import com.cursospring.br.repository.PedidoRepository;
import com.cursospring.br.repository.ProdutoRepository;
import com.cursospring.br.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		CategoriaEntitie cat1 = new CategoriaEntitie(null, "Electronics"); 
		CategoriaEntitie cat2 = new CategoriaEntitie(null, "Books"); 
		CategoriaEntitie cat3 = new CategoriaEntitie(null, "Computers"); 

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		UsuarioEntities u1 = new UsuarioEntities(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		UsuarioEntities u2 = new UsuarioEntities(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
	
		ProdutoEntitie p1 = new ProdutoEntitie(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		ProdutoEntitie p2 = new ProdutoEntitie(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		ProdutoEntitie p3 = new ProdutoEntitie(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		ProdutoEntitie p4 = new ProdutoEntitie(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		ProdutoEntitie p5 = new ProdutoEntitie(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		PedidoEntitie o1 = new PedidoEntitie(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
		PedidoEntitie o2 = new PedidoEntitie(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.PAGAMENTO_EM_ESPERA, u2); 
		PedidoEntitie o3 = new PedidoEntitie(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.PAGAMENTO_EM_ESPERA, u1); 
		
		
		
		repository.saveAll(Arrays.asList(u1, u2));	
		
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
	
	
}
