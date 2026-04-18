# Cadastro de Tarefas

API REST de gerenciamento de tarefas desenvolvida com Spring Boot para praticar os fundamentos de um CRUD sem adicionar complexidade desnecessaria.

## Objetivo

Criar uma API para cadastrar, listar, atualizar e deletar tarefas.

Cada tarefa deve possuir:

- `id`
- `titulo`
- `descricao`
- `status` (`PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`)
- `dataCriacao`

## Tecnologias

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok

## Endpoints

Base URL padrao: `http://localhost:8080`

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| `POST` | `/tarefas` | Criar tarefa |
| `GET` | `/tarefas` | Listar todas as tarefas |
| `GET` | `/tarefas/{id}` | Buscar tarefa por id |
| `PUT` | `/tarefas/{id}` | Atualizar tarefa |
| `DELETE` | `/tarefas/{id}` | Remover tarefa |

## Exemplo de JSON

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Implementar o CRUD de tarefas",
  "status": "PENDENTE"
}
```

## Estrutura basica do projeto

```text
src/main/java/.../
  controller
  service
  repository
  entity
  dto
```

## O que este projeto ajuda a aprender

- Criacao de API REST
- Uso de `@RestController`
- Mapeamento de entidade com JPA
- Persistencia de dados em banco
- Organizacao do projeto em camadas

## Extras para evoluir depois

- Filtro por status
- Paginacao
- Validacao com `@Valid`
- Trocar H2 por PostgreSQL

## Como executar

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Em outros ambientes:

```bash
./mvnw spring-boot:run
```

## Observacao

Este projeto e uma base direta para consolidar os conceitos mais importantes de Spring Boot em um caso de uso simples e util.
