# Gerenciador de Tarefas

Este é um projeto CRUD simples para gerenciamento de tarefas. Permite criar, visualizar, editar e excluir tarefas, utilizando Java Spring Boot, JDBC e Thymeleaf para a renderização de um frontend básico.

## 🛠️ Funcionalidades do projeto
- Criar uma nova tarefa, possuindo título, descrição, data de vencimento da tarefa e status
- Listar todas as tarefas criadas até então
- Editar tarefa existente (titulo, descrição e data de vencimento)
- Excluir uma única tarefa
- Excluir todas as tarefas de uma vez

## 🖥️Tecnologias utilizadas
- Java 21
- Spring Boot
- JDBC
- banco MySQL
- Thymeleaf
- Lombok

## 📌 Endpoints

| Método | Rota                      | Descrição                           |
| ------ | ------------------------- | ----------------------------------- |
| GET    | `/`                       | Página inicial, com lista de tarefas |
| GET    | `/formulario`             | Formulário para criar nova tarefa   |
| POST   | `/formulario`             | Salvar uma nova tarefa              |
| GET    | `/formulario/edit/{id}`   | Formulário para editar uma tarefa   |
| PUT    | `/formulario/edit/{id}`   | Atualizar tarefa                |
| GET    | `/formulario/delete/{id}` | Excluir tarefa                      |
| GET    | `/formulario/deleteall`   | Excluir todas as tarefas            |
