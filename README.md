# 📋 Lista de Tarefas - Backend (To-Do CRUD)

Este projeto foi desenvolvido como parte da avaliação do 1º Bimestre da disciplina de **Laboratório de Desenvolvimento Multiplataforma** no curso de **Desenvolvimento de Software Multiplataforma (6º DSM)** na **Faculdade de Tecnologia de Franca - Dr. Thomaz Novelino**.

## 👥 Desenvolvedores (Dupla)
- **Danilo Benedetti Ribeiro**
- **Thiago Dias Resende**

## 💻 Sobre o projeto
Aplicação robusta para o gerenciamento de tarefas do dia a dia, permitindo o controle completo do ciclo de vida de uma tarefa (CRUD). A API segue os princípios REST e as melhores práticas de desenvolvimento com Spring Boot.

## 🚀 Entidades e Atributos
A entidade principal **Tarefa** contém os seguintes campos:
- **Nome**: Identificação da tarefa (obrigatório, 3-100 caracteres).
- **Descrição**: Detalhamento da atividade (máx. 255 caracteres).
- **Status**: Estado atual (Pendente, Em Andamento, Concluída).
- **Observações**: Notas adicionais.
- **Data de Criação**: Gerada automaticamente no cadastro.
- **Data de Atualização**: Atualizada automaticamente a cada modificação.

## 🚧 Requisitos e Diferenciais Implementados
- [x] **CRUD Completo**: Criar, Listar, Alterar e Deletar Tarefas.
- [x] **Bean Validation**: Validação rigorosa dos campos de entrada com Hibernate Validator.
- [x] **Global Exception Handler**: Tratamento centralizado de erros, retornando mensagens claras em JSON (400 Bad Request / 404 Not Found).
- [x] **Injeção por Construtor**: Seguindo as recomendações oficiais do Spring para melhor testabilidade e imutabilidade.
- [x] **Domínio Rico**: Enums com descrições amigáveis e localização semântica correta.

## 🎲 Regras de Negócio
- Sistema simplificado sem necessidade de login.
- Sem conceito de múltiplos usuários (foco na funcionalidade principal).
- Integridade de dados garantida na camada de serviço e banco de dados.

## 🛠 Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.2.5
- **Persistência**: Spring Data JPA / Hibernate
- **Banco de Dados**: PostgreSQL (Produção) / H2 (Desenvolvimento/Testes)
- **Validação**: Spring Boot Starter Validation
- **Testes**: JUnit 5, Mockito e MockMvc
- **Outros**: Lombok para produtividade

## 📂 Estrutura do Projeto
- `controllers`: Endpoints da API REST.
- `services`: Camada de serviço com lógica de negócio.
- `repositories`: Interface de comunicação com o banco de dados.
- `models`: Definição da entidade e mapeamento ORM.
- `models.enums`: Definição dos estados da tarefa com descrições.
- `exceptions`: Tratamento global de erros e respostas customizadas.

## 🧪 Testes da Aplicação
O projeto conta com uma suíte de 17 testes automatizados cobrindo:
- **Testes Unitários**: Validação da lógica no `TarefaService`.
- **Testes de Integração**: Validação dos endpoints no `TarefaController` usando MockMvc.
- **Testes de Repositório**: Validação da persistência no banco de dados (H2).

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
