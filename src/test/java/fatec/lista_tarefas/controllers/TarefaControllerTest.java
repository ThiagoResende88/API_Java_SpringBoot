package fatec.lista_tarefas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fatec.lista_tarefas.models.enums.StatusTarefa;
import fatec.lista_tarefas.models.Tarefa;
import fatec.lista_tarefas.services.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TarefaController.class)
public class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TarefaService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Tarefa tarefa;

    @BeforeEach
    void setUp() {
        tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setNome("Tarefa Teste");
        tarefa.setDescricao("Descrição Teste");
        tarefa.setStatus(StatusTarefa.PENDENTE);
    }

    @Test
    void listarDeveRetornarListaDeTarefas() throws Exception {
        when(service.listarTodas()).thenReturn(Arrays.asList(tarefa));

        mockMvc.perform(get("/api/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Tarefa Teste"));
    }

    @Test
    void buscarPorIdDeveRetornarTarefaQuandoExistir() throws Exception {
        when(service.buscarPorId(1L)).thenReturn(Optional.of(tarefa));

        mockMvc.perform(get("/api/tarefas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Tarefa Teste"));
    }

    @Test
    void buscarPorIdDeveRetornarNotFoundQuandoNaoExistir() throws Exception {
        when(service.buscarPorId(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/tarefas/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void criarDeveRetornarTarefaCriada() throws Exception {
        when(service.salvar(any(Tarefa.class))).thenReturn(tarefa);

        mockMvc.perform(post("/api/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Tarefa Teste"));
    }

    @Test
    void atualizarDeveRetornarTarefaAtualizada() throws Exception {
        when(service.atualizar(eq(1L), any(Tarefa.class))).thenReturn(tarefa);

        mockMvc.perform(put("/api/tarefas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Tarefa Teste"));
    }

    @Test
    void deletarDeveRetornarNoContent() throws Exception {
        mockMvc.perform(delete("/api/tarefas/1"))
                .andExpect(status().isNoContent());
    }
}
