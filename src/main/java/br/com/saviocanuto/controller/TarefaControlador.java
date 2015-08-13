package br.com.saviocanuto.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.saviocanuto.model.Tarefa;
import br.com.saviocanuto.repository.TarefaRepository;

/**
 * Classe responsável por representar os serviços disponíveis para o Model de Tarefas.
 * 
 * @author Sávio Canuto
 * @since 12/08/2015.
 */
@RestController(value="tarefaController")
@Transactional
public class TarefaControlador {

    @Autowired
    private TarefaRepository repository;

    /**
     * Método responsável para retornar uma mensagem amigável ao acessar a URL raiz.
     * 
     * @return msg
     */
    @RequestMapping("/")
    public String bemVindo() {
    	return "Seja bem vindo!";
    }
    
    @ResponseBody
    @RequestMapping(value = "/saudacao/{nome}")
    public String saudacao(@PathVariable("nome") String nome) {
    	return "Seja bem vindo " + nome + "!";
    }
    
    @ResponseBody
    @RequestMapping(value = "/tarefas", method = RequestMethod.GET)
    public Iterable<Tarefa> listarTarefas() {
        return repository.findAll();
    }
    
    @ResponseBody
    @RequestMapping(value = "/tarefa/{id}")
    public Tarefa listarTarefasPorId(@PathVariable("id") String id) {
    	return repository.findOne(new Long(id));
    }

    @ResponseBody
    @RequestMapping(value = "/tarefa/salvar", method = RequestMethod.POST)
    public Tarefa salvar(@RequestBody final Tarefa tarefa) {
        return repository.save(tarefa);
    }
    
    @ResponseBody
    @RequestMapping(value = "/tarefa/alterar", method = RequestMethod.POST)
    public Tarefa alterar(@RequestBody final Tarefa tarefa) {
        return repository.save(tarefa);
    }
    
    @ResponseBody
    @RequestMapping(value = "/tarefa/excluir", method = RequestMethod.POST)
    public Iterable<Tarefa> excluir(@RequestBody final Tarefa tarefa) {
        repository.save(tarefa);
        return repository.findAll();
    }
}
