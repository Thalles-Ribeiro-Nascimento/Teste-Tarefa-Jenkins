package br.com.tarefa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarefa.domain.Atividade;
import br.com.tarefa.domain.Estado;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{
	
	List<Atividade> findAll();
	List<Atividade> findByTitulo(String titulo);
	
	List<Atividade> findByEstado(Estado estado);
}
