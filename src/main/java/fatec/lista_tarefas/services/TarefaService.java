package fatec.lista_tarefas.services;

import fatec.lista_tarefas.models.Tarefa;
import fatec.lista_tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    // Método para Listar todas as tarefas
    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    // Método para Criar uma tarefa
    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    // Método para Alterar uma tarefa
    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setNome(tarefaAtualizada.getNome());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setStatus(tarefaAtualizada.getStatus());
            tarefa.setObservacoes(tarefaAtualizada.getObservacoes());
            return repository.save(tarefa);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id: " + id));
    }

    // Método para Deletar uma tarefa
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // Método para buscar apenas uma tarefa por ID
    public Optional<Tarefa> buscarPorId(Long id) {
        return repository.findById(id);
    }
}