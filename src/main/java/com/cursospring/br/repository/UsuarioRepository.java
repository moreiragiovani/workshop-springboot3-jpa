package com.cursospring.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.br.entities.UsuarioEntities;

@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioEntities, Long>{

}
