# Definição e Criação de um Docker File

Aqui acontece a virada de chave 🗝️
Até agora você **usava** imagens.
Com Dockerfile, você passa a **descrevê-las**. Isso é infraestrutura como código, sem drama e sem misticismo.

---

## Definição e Criação de Dockerfile

### O que é um Dockerfile (em uma frase honesta)

Um **Dockerfile** é um roteiro declarativo que explica ao Docker **como montar uma imagem**, camada por camada.

Cada instrução:

* cria uma camada
* é cacheável
* influencia desempenho, tamanho e segurança

Pensar em Dockerfile é pensar em **processo reprodutível**, não em instalação manual.

---

### Primeiro Dockerfile

Crie um arquivo chamado `Dockerfile` (sem extensão):

```dockerfile
FROM alpine
CMD ["echo", "Olá, Docker!"]
```

Construindo a imagem:

```bash
docker build -t meu-primeiro .
```

Executando:

```bash
docker run meu-primeiro
```

Aqui você viu:

* `FROM` → imagem base
* `CMD` → comando padrão do container

Simples, direto, quase zen.

**Outro exemplo**

```bash
FROM ubuntu

RUN apt update && apt install -y python3 && apt clean

COPY app.py /home/ubuntu/app.py

CMD ["python3", "/home/ubuntu/app.py"]
```

- no terminal execute:

```bash
docker build . -t my_ubuntu_python
docker images

IMAGE                     ID             DISK USAGE   CONTENT SIZE   EXTRA
my_ubuntu_python:latest   5f4556bee366        176MB             0B        
```

- subindo a imagem criada:

```bash
$ docker run -ti --name test my_ubuntu_python
Entre com uma mensagem: Hello World
Mensagem: Hello World
```

---

### Criando uma imagem personalizada do Apache

Agora algo útil de verdade.

Estrutura:

```
site/
 ├── index.html
 └── Dockerfile
```

Dockerfile:

```dockerfile
FROM httpd:2.4
COPY index.html /usr/local/apache2/htdocs/
```

Build:

```bash
docker image build -t apache-custom .
```

Run:

```bash
docker run -d -p 8080:80 apache-custom 
# ou 
docker run -dti -p 80:80 --name my_debian_apache debian_apache:1.0
```

Você criou:

* uma imagem reutilizável
* com conteúdo versionado
* sem depender do host

Infra previsível é infra feliz 😌.

---

### Criando imagens personalizadas a partir de linguagens de programação

Exemplo clássico: **Java**

```dockerfile
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY app.jar .
CMD ["java", "-jar", "app.jar"]
```

Aqui:

* imagem base já tem JVM
* você só adiciona sua aplicação
* o container executa exatamente um processo

Funciona igual em dev, teste e produção.
Isso é o verdadeiro valor do Docker.

O mesmo padrão vale para:

* Python
* Node.js
* Go
* PHP

A linguagem muda, o modelo mental não.

**Outro exemplo**

```bash
cd app_c_alpine
docker image build -t my_app_c:1.0 .
docker run -ti --name app_c my_app_c:1.0
```

---

### Gerando uma imagem MULTISTAGE

Multistage é engenharia elegante aplicada.

Problema:

* imagem com compilador → pesada
* runtime não precisa dele

Solução:

```dockerfile
# stage 1 - build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# stage 2 - runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/target/app.jar .
CMD ["java", "-jar", "app.jar"]
```

Resultado:

* imagem final muito menor
* sem ferramentas desnecessárias
* mais segura
* mais rápida de distribuir

Multistage é um divisor de águas.

---

### Realizando o upload de imagens para o Docker Hub

Primeiro, login:

```bash
docker login
```

Tag da imagem:

```bash
docker tag apache-custom seu_usuario/apache-custom:1.0
```

Push:

```bash
docker push seu_usuario/apache-custom:1.0
```

Agora sua imagem:

* está versionada
* acessível globalmente
* pronta para cloud e CI/CD

Isso muda completamente a dinâmica de deploy.

---

### Registry: criando um servidor de imagens

Você não é obrigado a usar o Docker Hub.

Criar um registry local:

```bash
docker run -d \
  -p 5000:5000 \
  --name registry \
  registry:2
```

- Verifica as imagens existentes no registry

```bash
curl ip:port/v2/_catalog
```

Tag para registry local:

```bash
docker tag apache-custom localhost:5000/apache-custom
```

Push:

```bash
docker push localhost:5000/apache-custom
```

Isso é essencial para:

* ambientes corporativos
* redes isoladas
* pipelines internos
* controle de segurança

Docker vira **infraestrutura de distribuição**.

---

### Conclusão mental 🧠

Dockerfile é onde:

* arquitetura encontra código
* automação encontra previsibilidade
* ambiente vira versão

Quem domina Dockerfile:

* escreve menos documentação
* comete menos erros
* escala com menos atrito

---

### Visão adiante 🔭

O próximo salto natural:

* Docker Compose
* stacks completas (Java + DB + cache)
* variáveis de ambiente
* redes e volumes declarativos

Nesse ponto, você não “sobe serviços”.
Você **descreve sistemas**.

