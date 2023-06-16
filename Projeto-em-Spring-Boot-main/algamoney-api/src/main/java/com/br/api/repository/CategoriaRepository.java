package com.br.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
