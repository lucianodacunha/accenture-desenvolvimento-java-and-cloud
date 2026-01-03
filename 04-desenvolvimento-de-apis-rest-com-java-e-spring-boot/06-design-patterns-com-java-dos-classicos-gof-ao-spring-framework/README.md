# Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework

### Apresentação inicial

Padrões de projeto servem para:

* resolver problemas recorrentes
* evitar soluções improvisadas
* melhorar comunicação entre devs
* reduzir acoplamento
* aumentar legibilidade e manutenção

Eles não são regras rígidas.
São **boas decisões que sobreviveram ao tempo**.

---

## Padrões de Projeto

Os clássicos vêm do livro *Design Patterns* (GoF – Gang of Four) e se dividem, conceitualmente, em:

* **Criacionais** → como objetos são criados
* **Estruturais** → como objetos se organizam
* **Comportamentais** → como objetos interagem

Importante:

> Spring não “substitui” os padrões GoF.
> Ele **aplica muitos deles internamente**.

---

## Praticando com Java puro: Singleton

### Problema que ele resolve

Garantir que **exista apenas uma instância** de uma classe.

Exemplo típico:

* configuração
* cache
* logger
* acesso a recurso compartilhado

### Exemplo simples

```java
public class Configuracao {

    private static Configuracao instancia;

    private Configuracao() {}

    public static Configuracao getInstance() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }
}
```

Uso:

```java
Configuracao c1 = Configuracao.getInstance();
Configuracao c2 = Configuracao.getInstance();
```

`c1` e `c2` apontam para o mesmo objeto.

### Observação honesta

Singleton **resolve um problema**, mas pode:

* dificultar testes
* esconder dependências

Por isso, no mundo Spring, ele aparece de forma… mais elegante (spoiler: beans singleton).

---

## Praticando com Java puro: Strategy

### Problema que ele resolve

Evitar `if` / `switch` gigantes para escolher comportamentos.

### Ideia central

Encapsular algoritmos e torná-los intercambiáveis.

### Exemplo

```java
public interface Desconto {
    double calcular(double valor);
}
```

Implementações:

```java
public class DescontoNatal implements Desconto {
    public double calcular(double valor) {
        return valor * 0.9;
    }
}

public class DescontoBlackFriday implements Desconto {
    public double calcular(double valor) {
        return valor * 0.7;
    }
}
```

Uso:

```java
Desconto desconto = new DescontoNatal();
double valorFinal = desconto.calcular(100);
```

Aqui você troca comportamento **sem mudar o código que usa**.
Isso é design limpo.

---

## Praticando com Java puro: Facade

### Problema que ele resolve

Simplificar o uso de sistemas complexos.

### Ideia

Criar uma **fachada** que esconde complexidade interna.

### Exemplo conceitual

```java
public class PedidoFacade {

    public void realizarPedido() {
        validarEstoque();
        calcularFrete();
        processarPagamento();
    }

    private void validarEstoque() {}
    private void calcularFrete() {}
    private void processarPagamento() {}
}
```

Uso:

```java
new PedidoFacade().realizarPedido();
```

O cliente não precisa saber **como** tudo acontece.
Apenas que funciona.

---

## Praticando com Spring: introdução

Aqui acontece algo importante:
vários padrões GoF **somem do seu código**, porque o Spring já os aplica por você.

Exemplos claros:

* Singleton → escopo padrão de Bean
* Strategy → interfaces + injeção
* Facade → Controllers e Services
* Factory → container Spring
* Proxy → AOP, transações, segurança

Spring é praticamente um **catálogo vivo de Design Patterns**.

---

## Praticando com Spring: conhecendo o projeto base

Estrutura típica de uma API Spring:

* Controller → Facade da API
* Service → regras de negócio
* Repository → acesso a dados
* DTO → transporte de dados

Sem você perceber, já está usando:

* Facade
* Strategy
* Dependency Injection
* Template Method (em vários pontos)

Design patterns deixam de ser explícitos
e passam a ser **naturais**.

---

## Praticando com Spring: padrões de projeto em uma API REST

Exemplos claros em uma API:

* **Controller**
  → Facade para o mundo externo

* **Service com interface**
  → Strategy para regras de negócio

* **Repository**
  → Data Access Object (DAO)

* **Beans Singleton**
  → Singleton gerenciado pelo container

* **Exception Handler global**
  → Chain of Responsibility

Você não “implementa padrões”.
Você **projeta bem** e eles aparecem.

---

## Desafio de Projeto

Aqui entra o aprendizado real 💥.

Proposta típica:

* criar uma API REST
* separar camadas corretamente
* aplicar pelo menos:

  * Strategy
  * Facade
  * Injeção de dependência
* evitar lógica em controller
* evitar `if` desnecessário

Não é sobre quantidade de padrões.
É sobre **usar o padrão certo no lugar certo**.

---

## Entendendo o desafio

Perguntas que guiam o design:

* quem é responsável por essa decisão?
* esse comportamento pode variar?
* isso é detalhe interno ou contrato público?
* estou acoplando demais?
* isso facilita testes?

Se você responde isso bem,
o padrão aparece quase sozinho.

---

## Conclusão ☕🧠

Você agora entende que:

* design patterns não são moda
* GoF continua relevante
* Spring é uma aplicação prática desses padrões
* bons projetos têm menos `if` e mais objetos
* padrões melhoram comunicação e manutenção

Design Patterns não fazem seu código “bonito”.
Eles fazem seu código **sobreviver ao tempo**.

---

### Próximo passo natural 🚀

Depois disso, o caminho é:

* refatoração orientada a padrões
* leitura de código de frameworks
* identificação de padrões no Spring
* decisões arquiteturais conscientes

Quando você domina padrões,
você não escreve só código.
Você escreve **sistemas que fazem sentido**.

