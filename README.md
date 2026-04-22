# 📋 Lista de Tarefas - Backend (To-Do CRUD)

Este projeto foi desenvolvido como parte da avaliação do 1º Bimestre da disciplina de **Laboratório de Desenvolvimento Multiplataforma** no curso de **Desenvolvimento de Software Multiplataforma (6º DSM)** na **Faculdade de Tecnologia de Franca - Dr. Thomaz Novelino**.

## 💻 Sobre o projeto
Aplicação robusta para o gerenciamento de tarefas do dia a dia, permitindo o controle completo do ciclo de vida de uma tarefa (CRUD).

## 🚀 Entidades e Atributos
A entidade principal **Tarefa** contém os seguintes campos:
- **Nome**: Identificação da tarefa.
- **Descrição**: Detalhamento da atividade.
- **Status**: Estado atual (PENDENTE, EM_ANDAMENTO, CONCLUIDA).
- **Observações**: Notas adicionais.
- **Data de Criação**: Gerada automaticamente no cadastro.
- **Data de Atualização**: Atualizada automaticamente a cada modificação.

## 🚧 Requisitos Implementados
- [x] Criar Tarefa (POST)
- [x] Listar Tarefas (GET)
- [x] Alterar Tarefa (PUT)
- [x] Deletar Tarefa (DELETE)

## 🎲 Regras de Negócio
- Sistema simplificado sem necessidade de login.
- Sem conceito de múltiplos usuários (foco na funcionalidade principal).

## 🛠 Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.2.5
- **Persistência**: Spring Data JPA / Hibernate
- **Banco de Dados**: PostgreSQL (Produção) / H2 (Testes/Dev)
- **Testes**: JUnit 5, Mockito e MockMvc
- **Outros**: Lombok para produtividade

## 📂 Estrutura do Projeto
- `controllers`: Endpoints da API REST.
- `services`: Lógica de negócio e implementação.
- `repositories`: Interface de comunicação com o banco de dados.
- `models`: Definição da entidade e mapeamento ORM.
- `enums`: Definição dos status das tarefas.

## 🧪 Testes da Aplicação
O projeto conta com uma suíte de testes automatizados cobrindo:
- **Testes Unitários**: Validação da lógica no `TarefaService`.
- **Testes de Integração**: Validação dos endpoints no `TarefaController` usando MockMvc.
- **Testes de Repositório**: Validação da persistência no banco de dados.

Para rodar os testes:
```bash
mvn test
```

## ⚙️ Como executar
1. Clone o repositório.
2. Certifique-se de ter o Maven e o Java 17 instalados.
3. Configure o banco de dados no arquivo `application.properties` (atualmente configurado para H2 facilitando a execução imediata).
4. Execute o comando:
   ```bash
   mvn spring-boot:run
   ```
5. A API estará disponível em `http://localhost:8080/api/tarefas`.

## 📜 Script do Banco de Dados
O script para criação manual das tabelas no PostgreSQL está disponível no arquivo:
`db-script.sql` na raiz do projeto.

---
**Desenvolvido para fins acadêmicos.**
**Faculdade de Tecnologia de Franca - 2026**
