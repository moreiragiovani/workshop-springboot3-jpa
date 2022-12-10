package com.cursospring.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.br.entities.UsuarioEntities;

public interface UsuarioRepository extends JpaRepository<UsuarioEntities, Long>{

}
