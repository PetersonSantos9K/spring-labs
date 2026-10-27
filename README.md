# Spring Labs

Repositório dedicado a estudos e experimentos com Spring Boot, reunindo projetos independentes desenvolvidos durante a prática de conceitos do ecossistema Java.

## Pré-requisitos

- JDK 25
- Maven Wrapper (`mvnw`)

## Projetos

### 1. ecommerce-api

API de loja virtual com usuários, produtos, categorias e pedidos, incluindo itens com quantidades e preços associados aos clientes.

**Referência:** Curso de Java do Nélio Alves.

### 2. blog-mongodb-api

API de usuários e publicações com MongoDB, relacionando autores, posts e comentários, com pesquisas por título e período.

**Referência:** Curso de Java do Nélio Alves.

### 3. product-auth-jwt-api

API com cadastro e login de usuários, autenticação JWT e operações básicas de produtos.

**Referência:** [Tutorial de autenticação JWT com Spring Security](https://youtu.be/SqU9v_V32RA).

### 4. user-management-unit-tests

Aplicação de gerenciamento de usuários com funcionalidades de cadastro, login e busca, voltada à prática de testes unitários.

**Referência:** [Tutorial de testes unitários](https://youtu.be/T6ChO8LQxRE).

## Como executar

Execute os comandos a partir do diretório do projeto desejado.

### Executar a aplicação

```bash
./mvnw spring-boot:run
```

### Executar os testes

```bash
./mvnw test
```

## Objetivo do repositório

Consolidar conhecimentos de Java e Spring Boot por meio de exercícios, projetos inspirados em cursos e experimentos independentes, mantendo os estudos organizados em um único repositório e separados dos projetos autorais de portfólio.