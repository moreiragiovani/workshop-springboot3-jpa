package com.cursospring.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.br.entities.ProdutoEntitie;

public interface ProdutoRepository extends JpaRepository<ProdutoEntitie, Long>{

}
