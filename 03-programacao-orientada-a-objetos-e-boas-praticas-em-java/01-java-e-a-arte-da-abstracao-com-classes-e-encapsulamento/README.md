## Java e a arte da Abstração com Classes e Encapsulamento

### O que é abstração (em Java, sem misticismo)

Abstrair é **escolher o que importa e esconder o resto**.

Um programa não precisa saber *como* algo funciona internamente —
precisa saber **o que pode ser feito** e **com quais dados**.

Classes e encapsulamento são as ferramentas principais para isso.

---

## Criando a primeira Classe

### Pensando em termos de classe

Uma **classe** representa um conceito do domínio do problema.

Exemplo mental:

* Pessoa
* ContaBancaria
* Produto
* Pedido

Uma classe normalmente possui:

* **atributos** → estado
* **métodos** → comportamento

---

### Primeira classe simples

```java
public class Pessoa {

    String nome;
    int idade;

    void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}
```

E o uso dela:

```java
public class Main {
    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        p.nome = "Luciano";
        p.idade = 30;

        p.apresentar();
    }
}
```

Aqui você já aplicou:

* criação de objeto (`new`)
* acesso a atributos
* chamada de método

Funciona.
Mas ainda não está **bem encapsulado**.

---

## Encapsulamento: protegendo o estado

Encapsulamento significa:

> o objeto controla o acesso aos seus próprios dados

Em Java, isso é feito com **modificadores de acesso** e métodos públicos.

---

### Classe com encapsulamento correto

```java
public class Pessoa {

    private String nome;
    private int idade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}
```

Agora:

* ninguém altera o estado diretamente
* regras ficam dentro da classe
* o objeto é responsável por se manter válido

Essa é uma **decisão arquitetural**, não só sintaxe.

---

### Regra de ouro 🧠

> Se um dado não precisa ser público, **não seja**.

Encapsulamento reduz bugs, facilita manutenção e torna o código mais previsível.

---

## Trabalhando com Records

Agora entramos em Java moderno ✨.

### O que é um Record?

Um **record** é uma forma concisa de declarar classes **imutáveis**, focadas em **dados**, não em comportamento complexo.

Eles são ideais para:

* DTOs
* respostas de API
* objetos de transporte
* modelos simples

---

### Exemplo de Record

```java
public record Pessoa(String nome, int idade) {}
```

Sim. Só isso.

O Java gera automaticamente:

* construtor
* getters (`nome()`, `idade()`)
* `equals`
* `hashCode`
* `toString`

Uso:

```java
public class Main {
    public static void main(String[] args) {

        Pessoa p = new Pessoa("Luciano", 30);

        System.out.println(p.nome());
        System.out.println(p.idade());
    }
}
```

Aqui acontece algo importante:

* não existe `set`
* o objeto é **imutável**
* o estado não muda depois de criado

Isso reduz uma classe inteira de bugs.

---

### Record com validação

Você ainda pode validar dados:

```java
public record Pessoa(String nome, int idade) {

    public Pessoa {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }
    }
}
```

O construtor compacto permite garantir invariantes —
imutabilidade **não significa ausência de regras**.

---

## Classe tradicional vs Record

Comparação honesta:

* **Classe**

  * mutável
  * rica em comportamento
  * ideal para entidades de domínio

* **Record**

  * imutável
  * focado em dados
  * ideal para transporte e leitura

Usar record para tudo é erro.
Nunca usar record também é.

Java te dá opções — e espera discernimento.

---

## Conclusão ☕🧠

Você acabou de aprender a:

* criar classes que representam conceitos
* proteger dados com encapsulamento
* modelar objetos de forma consciente
* usar recursos modernos da linguagem (records)

Abstração não é esconder código.
É **revelar intenção**.
