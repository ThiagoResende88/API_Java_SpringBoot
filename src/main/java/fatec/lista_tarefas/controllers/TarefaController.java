package fatec.lista_tarefas.controllers;

import fatec.lista_tarefas.models.Tarefa;
import fatec.lista_tarefas.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    // Listar todas as tarefas (GET)
    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTodas();
    }

    // Buscar uma tarefa por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar uma nova tarefa (POST)
    @PostMapping
    public Tarefa criar(@Valid @RequestBody Tarefa tarefa) {
        return service.salvar(tarefa);
    }

    // Alterar uma tarefa existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(service.atualizar(id, tarefa));
    }

    // Deletar uma tarefa (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}