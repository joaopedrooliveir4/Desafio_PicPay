# Pipcpay Desafio

Projeto backend feito com Spring Boot que simula funcionalidades de transferência financeira, incluindo segurança com BCrypt e documentação via Swagger.

## Tecnologias usadas

- Java 24
- Spring Boot 3
- Spring Security
- Spring Data JPA (H2)
- Swagger (springdoc-openapi 2.8.8)

## Funcionalidades

- Cadastro e autenticação de usuários
- Transferência entre contas com validações
- Tratamento global de exceções personalizado
- Documentação da API com Swagger UI

## Como rodar

1. Clone o repositório
2. Rode com `./mvnw spring-boot:run` (Linux/Mac) ou `mvnw.cmd spring-boot:run` (Windows)
3. Acesse a API em `http://localhost:8080`
4. Acesse a documentação Swagger em `http://localhost:8080/swagger-ui/index.html`
