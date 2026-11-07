# Sistema de Gestão Escolar 📚

API de gestão escolar desenvolvida com Java 17 e Spring Boot 3.4.5.

## Tecnologias

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- Maven

## Funcionalidades

Gerenciamento de alunos, professores, turmas, disciplinas, notas e frequência.

## Executar localmente

1. Configure PostgreSQL e crie um banco chamado `gestao_escolar`.
2. Configure as variáveis de ambiente descritas em `.env.example`.
3. Execute:

```bash
cd backend
./mvnw spring-boot:run
```

No Windows, use `mvnw.cmd spring-boot:run`.

## Deploy no Render

Crie um Web Service conectado a este repositório com:

- Runtime: Docker
- Branch: `main` (após integrar a branch de deploy)
- Root Directory: `backend`
- Dockerfile Path: `./Dockerfile`
- Docker Build Context Directory: `backend`

Configure no Render as variáveis `DATABASE_URL`, `DATABASE_USERNAME` e `DATABASE_PASSWORD` com as credenciais de um banco PostgreSQL no Neon. A URL deve usar o formato JDBC (`jdbc:postgresql://...`) e SSL.

Variáveis opcionais:
- `DDL_AUTO=update`
- `JPA_SHOW_SQL=false`

Não coloque credenciais reais no Git. O Hibernate está configurado para atualizar o esquema automaticamente; para produção com dados importantes, prefira migrações versionadas (Flyway/Liquibase) e backups.

## Contato

Desenvolvido por Gabriel Stefanoni.
