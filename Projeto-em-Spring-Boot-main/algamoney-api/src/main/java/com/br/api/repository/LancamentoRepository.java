package com.br.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    
}

