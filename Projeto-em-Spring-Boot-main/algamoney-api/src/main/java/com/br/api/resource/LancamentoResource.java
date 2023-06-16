package com.br.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.br.api.model.Lancamento;
import com.br.api.model.Pessoa;
import com.br.api.repository.LancamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	// lista todos os registros
		  @GetMapping
		    public List<Lancamento> listarLancamento() {
		        return lancamentoRepository.findAll();
		        }
		  
    // busca pelo id um regristro especifico
		   @GetMapping("/{codigo}")
			public ResponseEntity<Lancamento> buscarLancamentoPeloCodigo(@PathVariable Long codigo) {
				Optional<Lancamento> pessoa = lancamentoRepository.findById(codigo);
				
				return pessoa.isPresent() ? ResponseEntity.ok(pessoa.get()) : ResponseEntity.notFound().build();
				}
		   
	// cria um novo registro na tabela pessoa
		   @PostMapping
			public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
			   Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
			   
					return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
					}
		   }
