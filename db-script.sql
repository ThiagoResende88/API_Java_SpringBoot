-- Script de criação da tabela de tarefas para PostgreSQL

CREATE TABLE tarefas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(50) CHECK (status IN ('PENDENTE', 'EM_ANDAMENTO', 'CONCLUIDA')),
    observacoes TEXT,
    data_criacao TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Exemplo de inserção inicial
INSERT INTO tarefas (nome, descricao, status, observacoes) 
VALUES ('Minha primeira tarefa', 'Descrição da tarefa', 'PENDENTE', 'Nenhuma observação');
