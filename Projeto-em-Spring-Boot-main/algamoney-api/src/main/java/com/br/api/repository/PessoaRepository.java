package com.br.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
