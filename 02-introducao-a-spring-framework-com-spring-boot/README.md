# Introdução a Spring Framework com Spring Boot

### Abertura

Spring não surgiu para “facilitar Java”.
Ele surgiu para **organizar complexidade**.

O objetivo do Spring é simples e ambicioso ao mesmo tempo:

* reduzir acoplamento
* centralizar configurações
* facilitar testes
* tornar aplicações grandes… sustentáveis

Spring Boot entra depois como o **acelerador**.

---

### Visão geral do curso

Ao longo desse tema, você passa a:

* entender o ecossistema Spring
* criar APIs REST rapidamente
* trabalhar com injeção de dependência
* integrar banco de dados com JPA
* preparar aplicações para cloud e containers

O foco não é decorar anotações.
É **entender o modelo mental**.

---

### Spring Framework

O **Spring Framework** é a base de tudo.

Ele fornece:

* Inversão de Controle (IoC)
* Injeção de Dependência (DI)
* gerenciamento de ciclo de vida
* módulos (Web, Data, Security, etc.)

A grande ideia:

> você não cria dependências, o Spring **injeta**.

Isso muda completamente o design do código.

---

### Slides (nota importante)

Slides ajudam a visualizar conceitos, mas:

* não substituem código
* não substituem erros reais
* não substituem debug

Spring se aprende **rodando**, quebrando e consertando.

---

### Conhecendo o Spring Boot

**Spring Boot** é uma camada sobre o Spring Framework.

Ele resolve dores clássicas:

* configuração excessiva
* XML demais
* setup demorado

O que o Spring Boot traz:

* auto-configuração
* servidor embutido (Tomcat)
* starters (dependências prontas)
* convenção sobre configuração

Spring Boot não esconde o Spring.
Ele **organiza a entrada**.

---

### Primeiros passos

Criar um projeto Spring Boot normalmente envolve:

* escolher dependências
* definir Java version
* rodar a aplicação

Estrutura mental típica:

* classe principal com `@SpringBootApplication`
* pacotes organizados por responsabilidade
* aplicação que sobe com `main`

Se sobe e escuta uma porta, você já tem um serviço.

---

### Beans versus Components

Aqui está um ponto central.

* **Bean**

  * é um objeto gerenciado pelo Spring
  * vive dentro do *Application Context*

* **Component**

  * é uma forma de declarar um Bean automaticamente

Exemplo mental:

* todo `@Component` é um Bean
* nem todo Bean precisa ser um `@Component`

Anotações comuns:

* `@Component`
* `@Service`
* `@Repository`
* `@Controller`

Todas criam Beans.
A diferença é **semântica**, não técnica.

---

### Scopes — Singleton ou Prototype

Scope define **quantas instâncias** de um Bean existem.

* **Singleton** (padrão)

  * uma instância por aplicação
  * mais comum
  * mais eficiente

* **Prototype**

  * nova instância a cada injeção
  * menos comum
  * usado em casos específicos

Regra prática:

> use Singleton até ter um bom motivo para não usar.

---

### Properties Value

Spring permite configurar comportamento via propriedades.

Exemplo conceitual:

* portas
* URLs
* credenciais
* flags de ambiente

Você injeta valores externos no código, evitando *hardcode*.

Isso é essencial para:

* ambientes (dev, test, prod)
* cloud
* containers

---

### Configuration Properties

Quando as propriedades crescem, entra o mapeamento estruturado.

Com **Configuration Properties**, você:

* agrupa configs relacionadas
* valida valores
* tipa propriedades

Resultado:

* código mais limpo
* menos erro de digitação
* configuração como classe

Isso é Spring pensando em **manutenibilidade**.

---

### Conceito de ORM e JPA

Antes do Spring Data, precisamos alinhar conceitos.

**ORM (Object-Relational Mapping)**:

* mapeia objetos Java para tabelas
* elimina SQL repetitivo
* reduz código de infraestrutura

**JPA (Java Persistence API)**:

* é a especificação
* define regras e anotações
* não é implementação

A implementação mais comum é o Hibernate.

---

### Spring Data JPA

Spring Data JPA elimina a maior parte do código repetitivo de persistência.

Você passa a:

* definir interfaces
* deixar o Spring gerar implementações
* focar no domínio, não no SQL básico

CRUD vira detalhe.
Regras de negócio voltam ao centro.

---

### Conexão com Postgres

Aqui entra o banco relacional clássico.

**PostgreSQL** é muito usado porque:

* é robusto
* open source
* excelente para produção
* comum em cloud

Spring Boot facilita:

* configuração de datasource
* conexão via properties
* integração com JPA

Você descreve o banco.
O Spring conecta.

---

### JPA Repository

O coração do Spring Data JPA.

Um **Repository**:

* representa acesso a dados
* já traz CRUD pronto
* permite consultas por convenção

Você escreve **interfaces**, não classes.

Menos código.
Menos erro.
Mais foco.

---

### Conclusão

Você acabou de ver que:

* Spring organiza dependências
* Spring Boot acelera o início
* Beans são gerenciados pelo container
* configuração externa é regra, não exceção
* JPA abstrai persistência
* Spring Data elimina boilerplate
* banco vira parte natural da aplicação

Spring Boot não é “framework mágico”.
É **engenharia aplicada para ganhar tempo sem perder controle**.
