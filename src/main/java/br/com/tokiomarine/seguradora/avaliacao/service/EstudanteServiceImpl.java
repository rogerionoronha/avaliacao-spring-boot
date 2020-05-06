package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import lombok.extern.java.Log;

// TODO Efetue a implementação dos métodos da classe service

@Log
@Service
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	EstudanteRepository repository;
	
	static final Logger logger = LoggerFactory.getLogger(EstudanteServiceImpl.class);

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(long id) {
		Optional<Estudante> estudante = repository.findById(id);
		if(estudante == null) {
			throw new IllegalArgumentException("Identificador inválido:" + id);
		}
	
		return estudante.get();
	}

	@Override
	public void excluirEstudante(long id) {
		repository.deleteById(id);		
	}

}
