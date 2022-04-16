<div align="center">
<a href="https://www.fiap.com.br" target="_blank">
    <img src="https://www.fiap.com.br/wp-content/themes/fiap2016/images/mobile/mba/vitrine/mba-logo.png" height="100px" alt="FIAP" class="center"/>
</a>

[![Java11](https://img.shields.io/badge/devel-Java-brightgreen)](https://docs.oracle.com/en/java/javase/11)
[![SpringBoot](https://img.shields.io/badge/framework-SpringBoot-brightgreen)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle)
[![Docker](https://img.shields.io/badge/container-Docker-brightgreen)](https://www.docker.com)
[![RabbitMQ](https://img.shields.io/badge/messenger%20broker-RabbitMQ-brightgreen)](https://www.rabbitmq.com/)
</div>

# FIAP Avaliação - INTEGRATIONS & DEVELOPMENT TOOLS
Prof: Rafael Thomazeli Mazzucato


Projeto Java para comunicação de dados obtidos por Drones via mensageria.

## Executando o projeto (com Docker)

### 1 - Download do projeto no github:

  ```
  $ git clone https://github.com/paulobof/drone-information.git
  ```

### 2 - Executar o docker-compose do projeto:
#### no diretório do projeto execute o comando:

 ~~~shell
  docker-compose up 
 ~~~

### Documentação
- Acesse a documentação no seu browser no endereço:
  http://localhost:8081/swagger-ui.html


## Executando o projeto (Sem Docker)

> **Download do projeto no github:**
  ```
  $ git clone https://github.com/paulobof/drone-information.git
  ```

## Pré Requisitos

- Gradle 7.3
- Java 11
- RabbitMQ 3.0

## No Diretório do projeto:

### 1 - Criando o jar

    gradle build

### 2 - Set a URL de conexão com o mongodb nas variáveis de ambiente:

    export SPRING_DATASOURCE_URL=mongodb://localhost:27017/transactiondb


### 3 - Executando a aplicação:

    gradle bootRun


### Documentação
- Acesse a documentação no seu browser no endereço:
  http://localhost:8080/swagger-ui.html

### Postman Collection:
- Importe a collection localizada na raiz do projeto: 
- **DRONE-INFORMATION.postman_collection.json**