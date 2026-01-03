# Introdução ao desenvolvimento de API

### O que vou aprender

Ao estudar APIs, você aprende a:

* expor funcionalidades de forma organizada
* permitir comunicação entre sistemas diferentes
* separar frontend de backend
* criar serviços reutilizáveis
* preparar aplicações para cloud e microsserviços

Traduzindo:
você para de escrever programas isolados e passa a criar **serviços de verdade**.

---

### Pré-requisitos

Nada absurdo, mas alguns fundamentos ajudam muito:

* Java básico (classes, métodos, exceções)
* orientação a objetos
* noção de HTTP (requisição e resposta)
* lógica de programação

Frameworks vêm depois.
Antes, o **conceito precisa ficar sólido**.

---

### Qual problema isso resolve e por que eu deveria aprender isso?

Problema clássico do passado:

* aplicação fechada
* interface acoplada ao backend
* difícil integrar
* difícil escalar

APIs resolvem isso ao permitir:

* frontend web, mobile, desktop usando o mesmo backend
* integração com outros sistemas
* automação
* escalabilidade real
* evolução sem quebrar tudo

Se você quer trabalhar com:

* cloud
* microsserviços
* sistemas modernos
* integrações

👉 **API não é opcional. É fundamento.**

---

## Introdução a API

API significa **Application Programming Interface**.

Mas não pense nela como “interface gráfica”.
Pense como:

> um **contrato de comunicação** entre sistemas

Uma API define:

* o que pode ser solicitado
* como solicitar
* o que será retornado
* em qual formato
* em quais condições

Sem suposições.
Sem improviso.

---

### O sentido semântico de API

API é **linguagem combinada**.

Quando você cria uma API, está dizendo:

* “se você pedir isso…”
* “nesse formato…”
* “eu respondo assim…”

É semântica porque:

* nomes importam
* verbos importam
* estrutura importa
* comportamento importa

Uma boa API é previsível.
Uma API ruim funciona… até não funcionar mais 😄.

---

### Características de uma API

Boas APIs costumam ser:

* **claras** → fácil de entender
* **coesas** → cada endpoint tem propósito
* **previsíveis** → respostas consistentes
* **independentes** → cliente não conhece a implementação
* **versionáveis** → podem evoluir sem quebrar clientes

API é produto.
Produto mal desenhado gera suporte infinito.

---

## REST

REST não é tecnologia.
É **estilo arquitetural**.

Ele define princípios para construir APIs usando HTTP de forma semântica.

REST parte de ideias simples:

* tudo é um recurso
* recursos têm identificadores (URLs)
* ações são representadas por métodos HTTP

Exemplo mental:

* `/clientes`
* `/clientes/10`
* `/pedidos/2024`

---

### RESTful Characteristics (princípios REST)

Uma API RESTful segue alguns princípios-chave:

* **Client–Server**
  frontend e backend independentes

* **Stateless**
  cada requisição é completa em si mesma

* **Cacheable**
  respostas podem ser cacheadas

* **Uniform Interface**
  padrão consistente de URLs e métodos

* **Layered System**
  camadas intermediárias são permitidas

Você não “ativa REST”.
Você **projeta** seguindo esses princípios.

---

### REST x RESTful

Aqui mora uma confusão comum.

* **REST**

  * é o conceito
  * é o conjunto de princípios

* **RESTful**

  * é a API que **segue** esses princípios

Ou seja:

> REST é a teoria
> RESTful é a prática bem feita

Muita API diz que é REST.
Nem todas merecem o título 😄.

---

## O que é uma API (na prática)

Imagine uma API como um restaurante 🍽️:

* você (cliente) pede pelo cardápio
* não entra na cozinha
* não escolhe ingredientes
* recebe o prato pronto

A API:

* recebe requisições
* processa regras
* acessa dados
* devolve respostas

Quem consome não precisa saber:

* linguagem
* banco
* infraestrutura

Apenas **o contrato**.

---

## Análise de códigos (conceitual)

Sem framework por enquanto. Só ideia.

Uma API típica:

* recebe dados (JSON)
* valida
* executa regra de negócio
* retorna resposta padronizada

Ela não:

* imprime na tela
* pede input no console
* depende de interface gráfica

API fala com **máquinas**, não com humanos diretamente.

---

## Resumão do Felipão 🧠⚽

Se fosse para resumir em tom de vestiário:

* API é como sistemas conversam
* REST é o jeito elegante de fazer isso
* RESTful é quando você faz direito
* aprender API te tira do mundo local
* e te coloca no jogo real da cloud

Sem API:

* você escreve código

Com API:

* você constrói **plataformas**
