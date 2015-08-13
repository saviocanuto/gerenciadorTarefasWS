package br.com.saviocanuto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.saviocanuto.model.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Long>{
}
