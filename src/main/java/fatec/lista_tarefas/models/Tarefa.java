package fatec.lista_tarefas.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import fatec.lista_tarefas.models.enums.StatusTarefa;

@Entity
@Table(name = "tarefas")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    private String observacoes;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    // Este método corre automaticamente antes de salvar a tarefa
    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
        dataAtualizacao = LocalDateTime.now();
    }

    // Este método corre automaticamente antes de atualizar a tarefa
    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }
}
