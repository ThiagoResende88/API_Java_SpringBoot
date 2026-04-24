package fatec.lista_tarefas.repositories;

import fatec.lista_tarefas.models.enums.StatusTarefa;
import fatec.lista_tarefas.models.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository repository;

    @Test
    void salvarDevePersistirTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Tarefa Persistida");
        tarefa.setStatus(StatusTarefa.PENDENTE);

        Tarefa salva = repository.save(tarefa);

        assertNotNull(salva.getId());
        assertEquals("Tarefa Persistida", salva.getNome());
    }

    @Test
    void buscarPorIdDeveRetornarTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Tarefa Busca");
        tarefa.setStatus(StatusTarefa.PENDENTE);
        Tarefa salva = repository.save(tarefa);

        Optional<Tarefa> buscada = repository.findById(salva.getId());

        assertTrue(buscada.isPresent());
        assertEquals(salva.getId(), buscada.get().getId());
    }

    @Test
    void deletarDeveRemoverTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Tarefa Deletar");
        tarefa.setStatus(StatusTarefa.PENDENTE);
        Tarefa salva = repository.save(tarefa);

        repository.deleteById(salva.getId());
        Optional<Tarefa> buscada = repository.findById(salva.getId());

        assertFalse(buscada.isPresent());
    }
}
