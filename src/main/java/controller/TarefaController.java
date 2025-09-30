package controller;

import model.Tarefa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TarefaService;

import java.util.List;

public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTarefas() {
        return ResponseEntity.ok(tarefaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.getById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Tarefa> CreateTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novatarefa = tarefaService.create(tarefa);
        return ResponseEntity.status(201).body(novatarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetails) {
        return ResponseEntity.ok(tarefaService.updateTarefa(id, tarefaDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}



