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


## Executando o projeto

## Pré Requisitos

- Gradle 7.3
- Java 11
- Docker

### 1 - Download do projeto no github:
  ```
  $ git clone https://github.com/paulobof/drone-information.git
  ```

### No Diretório do projeto:

### 1 - Subindo o RabbitMQ via docker-compose:
#### no diretório do projeto execute o comando:

 ~~~shell
docker-compose up -d
 ~~~

### 2 - Subindo o producer:
#### no diretório do projeto api-productor:

~~~shell
gradle build
~~~

~~~shell
gradle bootRun
~~~

### 3 - Subindo o consumer:
#### no diretório do projeto api-consumer, abra um novo terminal, adicione as variáveis de ambiente para o alerta de e-mail:
#### Na variável RECEIVER informe seu e-mail

~~~shell
export RECEIVER=****@****
~~~
~~~shell
export SENDER=transaction.fiap@gmail.com
~~~
~~~shell
export PASSWORD=Tr@n54ct1n
~~~

#### Após setar as variáveis de ambiente, execute os comandos:

~~~shell
gradle build
~~~

~~~shell
gradle bootRun
~~~


### 4 - Subindo o Job(Drones):
#### no diretório do projeto job-drone, abra um novo terminal, via variável de ambiente, informe o id do drone:
#### **Ex** Informando id 5:

~~~shell
export ID_DRONE=5
~~~

#### Após informar o ID drone, é só buildar e subir a instância de drone com os comandos abaixo:

~~~shell
gradle build
~~~

~~~shell
gradle bootRun
~~~


#### **Obs:** Para cada instância de drone, repita o passo 4 sem executar o **_gradle build_** novamente com ids diferentes em um novo terminal.

### Documentação
- Acesse a documentação no seu browser no endereço:
  http://localhost:8081/swagger-ui.html

### Postman Collection:
- Importe a collection localizada na raiz do projeto: 
- **DRONE-INFORMATION.postman_collection.json**

### Developers

| Github                              | Linkedin                                      |
|-------------------------------------|-----------------------------------------------|
| https://github.com/paulobof         | https://www.linkedin.com/in/paulobof          |
| https://github.com/wees-guimaraes   | https://www.linkedin.com/in/wesley-guimaraes  |
