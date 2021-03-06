package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	static final Logger logger = LoggerFactory.getLogger(EstudanteController.class);

	@Autowired
	EstudandeService service;

	@GetMapping("criar")
	public String iniciarCastrado(Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping("listar")
	public String listarEstudantes(Model model) {
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "listar-estudantes";
	}

	@PostMapping("add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "cadastrar-estudante";
		}
		service.cadastrarEstudante(estudante);
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "listar-estudantes";
	}

	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(@PathVariable("id")  long id, Model model) {
		Estudante estudante = service.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}

	@PostMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") long id, @Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// estudante.setId(id);
			return "atualizar-estudante";
		}
		service.atualizarEstudante(estudante);
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "listar-estudantes";
	}

	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") long id, Model model) {
		service.excluirEstudante(id);
		List<Estudante> estudantes = service.buscarEstudantes();
		model.addAttribute("estudantes", (estudantes != null && estudantes.size() == 0) ? null : estudantes);
		return "listar-estudantes";
	}
}
