package com.uninter.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping // Listar todas
    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    @PostMapping // Criar nova
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @GetMapping("/{id}") // Buscar por ID
    public Optional<Tarefa> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}") // Atualizar
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        return repository.save(tarefa);
    }

    @DeleteMapping("/{id}") // Deletar
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}