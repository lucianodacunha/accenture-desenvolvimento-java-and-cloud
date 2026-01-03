# Dominando Interfaces e Lambda em Java

### Interfaces

Uma **interface** define **o que uma classe deve fazer**, não **como** ela faz.

Ela é um **contrato**.

Exemplo simples:

```java
public interface Pagamento {
    void pagar(double valor);
}
```

Quem implementa essa interface **assume a obrigação** de fornecer esse comportamento.

```java
public class PagamentoCartao implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento no cartão: " + valor);
    }
}
```

Uso:

```java
Pagamento pagamento = new PagamentoCartao();
pagamento.pagar(100.0);
```

Aqui aparecem ideias importantes:

* a variável é do tipo **interface**
* a implementação pode variar
* o código que usa não precisa saber *qual* classe concreta está por trás

Isso reduz acoplamento e aumenta flexibilidade.

---

### Interface ≠ Classe Abstrata (regra mental)

* **Interface**

  * define capacidades
  * múltiplas interfaces podem ser implementadas
  * foco em contrato

* **Classe abstrata**

  * define identidade
  * herança única
  * pode ter estado

Quando você quer dizer *“isso pode fazer X”*, interface.
Quando quer dizer *“isso é uma variação de Y”*, herança.

---

### Métodos default em interfaces

Java moderno permite comportamento **opcional** em interfaces:

```java
public interface Pagamento {

    void pagar(double valor);

    default void imprimirRecibo() {
        System.out.println("Recibo impresso");
    }
}
```

Isso:

* mantém compatibilidade
* evita quebrar implementações existentes
* deve ser usado com parcimônia

Interface não é lugar para lógica complexa.

---

## Interfaces Funcionais

Aqui acontece a mágica ✨.

Uma **interface funcional** é uma interface que possui **apenas um método abstrato**.

Exemplo clássico:

```java
@FunctionalInterface
public interface Operacao {
    int executar(int a, int b);
}
```

A anotação `@FunctionalInterface`:

* não é obrigatória
* mas protege você de erros
* deixa a intenção explícita

Interfaces funcionais são a base das **lambdas**.

---

### Usando lambda

Forma tradicional (classe anônima):

```java
Operacao soma = new Operacao() {
    @Override
    public int executar(int a, int b) {
        return a + b;
    }
};
```

Forma moderna (lambda):

```java
Operacao soma = (a, b) -> a + b;
```

Mesma lógica.
Menos ruído.
Mais intenção.

---

### Lambda não é mágica 🧠

Uma lambda:

* **implementa uma interface funcional**
* não cria uma nova linguagem
* não elimina orientação a objetos

Ela apenas deixa o código mais direto.

---

### Interfaces funcionais comuns no Java

O Java traz várias prontas, muito usadas em streams e APIs modernas:

* `Runnable` → executa algo sem retorno
* `Consumer<T>` → consome um valor
* `Supplier<T>` → fornece um valor
* `Function<T, R>` → transforma um valor
* `Predicate<T>` → retorna true/false

Exemplo:

```java
Predicate<Integer> ehPar = n -> n % 2 == 0;
System.out.println(ehPar.test(4)); // true
```

Isso muda completamente a forma de escrever lógica condicional e coleções.

---

## Entendendo algumas keywords usadas

Agora vamos às palavras que aparecem o tempo todo nesse contexto.

### `interface`

Define um contrato.

```java
interface Servico { }
```

---

### `implements`

Indica que uma classe **cumpre um contrato**.

```java
class EmailService implements Servico { }
```

---

### `default`

Permite método com implementação em interface.

```java
default void log() { }
```

---

### `static` (em interface)

Método utilitário, não depende de instância.

```java
static void validar() { }
```

---

### `@FunctionalInterface`

Garante que a interface tenha apenas um método abstrato.

```java
@FunctionalInterface
interface Acao {
    void executar();
}
```

---

### `->` (lambda operator)

Lê-se como:

> “recebe … e produz …”

```java
x -> x * 2
```

É uma forma compacta de dizer:

> “quando alguém chamar isso, faça assim”

---

### Regra de ouro 🧠

> Interface define **o que**
> Classe define **como**
> Lambda define **agora, aqui, sem cerimônia**

---

## Conclusão ☕🚀

Você acabou de dominar:

* contratos com interfaces
* desacoplamento real
* interfaces funcionais
* lambdas
* palavras-chave centrais do Java moderno

Isso é o que permite:

* streams
* APIs fluentes
* código expressivo
* menos boilerplate
* mais intenção
