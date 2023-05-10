package br.com.tarefa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefa.domain.Atividade;
import br.com.tarefa.domain.Estado;
import br.com.tarefa.repository.AtividadeRepository;

@RestController
public class AtividadeController {
	@Autowired
	private AtividadeRepository at;
	
	@GetMapping("/tarefa/listar")
	public List<Atividade> listar(){
		return at.findAll();
	}
	
	@GetMapping("/tarefa/listar/{titulo}")
	public List<Atividade> listar_Titulo(@PathVariable String titulo){
		return at.findByTitulo(titulo);
	}
	
	@GetMapping("/tarefa/listar/aberta")
	public List<Atividade> listar_Aberta(Estado estado) {
	    return at.findByEstado(estado.Aberta);
	}
	
	@GetMapping("/tarefa/listar/finalizada")
	public List<Atividade> listar_Finalizada(Estado estado) {
	    return at.findByEstado(estado.Finalizada);
	}
	
	
	@PostMapping("/tarefa/cadastrar")
	public String cadastrar(@RequestBody Atividade atividade) {
		at.save(atividade);
		return "Cadastro com sucesso.";
	}
	
	@PostMapping("/tarefa/atualizar/{id}")
	public String atualizar (@PathVariable Integer id, @RequestBody Atividade atividade) {
		String msg = "";
		Optional<Atividade> a = at.findById(id);
		
		if(a.isPresent()) {
			atividade.setIdtarefa(id);
			at.save(atividade);
			msg = "Tarefa atualizada";
		}
		else {
			msg = "Tarefa não encontrado";
		}
		return msg;
	}
}
