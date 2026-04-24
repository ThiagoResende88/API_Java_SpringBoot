package fatec.lista_tarefas;

import fatec.lista_tarefas.models.Tarefa;
import fatec.lista_tarefas.services.TarefaService;
import fatec.lista_tarefas.models.enums.StatusTarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TarefaServiceTest {

    @Autowired
    private TarefaService service;

    @Test
    void deveSalvarTarefaComSucesso() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Teste de Integração");
        tarefa.setStatus(StatusTarefa.PENDENTE);

        Tarefa salva = service.salvar(tarefa);

        assertNotNull(salva.getId());
        assertEquals("Teste de Integração", salva.getNome());
    }
}