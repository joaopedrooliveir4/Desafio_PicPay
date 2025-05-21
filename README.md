# Pipcpay Desafio

[![Java](https://img.shields.io/badge/Java-24-007396?logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0.0-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring_Security-%2338A169.svg?logo=spring&logoColor=white)](https://spring.io/projects/spring-security)
[![JPA](https://img.shields.io/badge/Spring_Data_JPA-H2-blue?logo=hibernate&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![Swagger](https://img.shields.io/badge/Swagger-2.8.8-%23Clojure)](https://swagger.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

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

## Licença

Este projeto foi desenvolvido por João Pedro como parte de um desafio técnico e está licenciado sob a [MIT License](LICENSE).  
© 2025 João Pedro – Todos os direitos reservados.
