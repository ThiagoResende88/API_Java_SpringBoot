package fatec.lista_tarefas.services;

import fatec.lista_tarefas.controllers.enums.StatusTarefa;
import fatec.lista_tarefas.models.Tarefa;
import fatec.lista_tarefas.repositories.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository repository;

    @InjectMocks
    private TarefaService service;

    private Tarefa tarefa;

    @BeforeEach
    void setUp() {
        tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setNome("Teste");
        tarefa.setDescricao("Descrição de teste");
        tarefa.setStatus(StatusTarefa.PENDENTE);
    }

    @Test
    void listarTodasDeveRetornarListaDeTarefas() {
        when(repository.findAll()).thenReturn(Arrays.asList(tarefa));

        List<Tarefa> resultado = service.listarTodas();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void salvarDeveRetornarTarefaSalva() {
        when(repository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa resultado = service.salvar(tarefa);

        assertNotNull(resultado);
        assertEquals("Teste", resultado.getNome());
        verify(repository, times(1)).save(tarefa);
    }

    @Test
    void buscarPorIdDeveRetornarTarefaQuandoExistir() {
        when(repository.findById(1L)).thenReturn(Optional.of(tarefa));

        Optional<Tarefa> resultado = service.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(tarefa, resultado.get());
    }

    @Test
    void atualizarDeveRetornarTarefaAtualizada() {
        Tarefa tarefaAtualizada = new Tarefa();
        tarefaAtualizada.setNome("Nome Atualizado");
        tarefaAtualizada.setStatus(StatusTarefa.CONCLUIDA);

        when(repository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(repository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa resultado = service.atualizar(1L, tarefaAtualizada);

        assertEquals("Nome Atualizado", resultado.getNome());
        assertEquals(StatusTarefa.CONCLUIDA, resultado.getStatus());
    }

    @Test
    void atualizarDeveLancarExcecaoQuandoNaoEncontrarId() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.atualizar(1L, tarefa));
    }

    @Test
    void deletarDeveChamarRepository() {
        doNothing().when(repository).deleteById(1L);

        service.deletar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
