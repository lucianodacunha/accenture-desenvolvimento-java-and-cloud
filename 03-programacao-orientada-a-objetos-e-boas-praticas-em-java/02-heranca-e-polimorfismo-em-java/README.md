# Herança e Polimorfismo em Java

### Introdução à Herança e ao Polimorfismo

**Herança** responde à pergunta:

> *“O que isso **é** em relação a outra coisa?”*

**Polimorfismo** responde à pergunta:

> *“Como objetos diferentes **reagem** à mesma mensagem?”*

Em Java, essas duas ideias caminham juntas.

Exemplo mental simples:

* Um **Carro** é um **Veículo**
* Uma **Moto** é um **Veículo**
* Ambos podem **acelerar**
* Cada um acelera do seu jeito

Você não quer perguntar *“que tipo é esse?”* toda hora.
Você quer dizer *“acelere”* — e deixar o objeto decidir como.

Isso é polimorfismo.

---

## Explorando Herança

### Criando uma classe base

```java
public class Veiculo {

    public void acelerar() {
        System.out.println("Veículo acelerando");
    }
}
```

Essa é a **superclasse**.

---

### Criando subclasses

```java
public class Carro extends Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando com quatro rodas");
    }
}
```

```java
public class Moto extends Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Moto acelerando com duas rodas");
    }
}
```

Aqui entram dois pontos cruciais:

* `extends` → estabelece herança
* `@Override` → garante que você está sobrescrevendo corretamente

---

### Polimorfismo em ação

```java
public class Main {
    public static void main(String[] args) {

        Veiculo v1 = new Carro();
        Veiculo v2 = new Moto();

        v1.acelerar();
        v2.acelerar();
    }
}
```

Mesmo tipo de referência (`Veiculo`),
comportamentos diferentes em tempo de execução.

Isso é **polimorfismo**.

O Java decide **em runtime** qual método chamar, com base no objeto real.

---

### Regra de ouro 🧠

> Programe para a **superclasse**, não para a implementação concreta.

Isso reduz acoplamento e aumenta flexibilidade.

---

## Herança não é reutilização gratuita

Aqui vai uma verdade incômoda, mas necessária:

> Herança **não é** apenas reaproveitar código.

Ela expressa uma relação **“é um”** (*is-a*).

Exemplo ruim:

* `Funcionario` estende `PessoaFisicaComCPFFormatadoEspecial`

Exemplo bom:

* `Funcionario` estende `Pessoa`

Se a relação não faz sentido no mundo real, ela não fará no código.

---

## Reforçando `instanceof`

O `instanceof` verifica o tipo real do objeto em runtime.

```java
if (v1 instanceof Carro) {
    System.out.println("É um carro");
}
```

Com Java moderno:

```java
if (v1 instanceof Carro carro) {
    carro.acelerar();
}
```

Mas atenção ⚠️:

Uso excessivo de `instanceof` costuma indicar:

* design fraco
* ausência de polimorfismo
* lógica espalhada

Se você precisa perguntar *“quem é você?”* o tempo todo,
talvez o objeto não esteja fazendo seu trabalho.

---

## Sobrecarga de método (Overloading)

Sobrecarga **não é** sobrescrita.

Ela acontece quando:

* métodos têm o **mesmo nome**
* mas **parâmetros diferentes**
* na **mesma classe**

Exemplo:

```java
public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }
}
```

Aqui:

* o compilador escolhe o método correto
* a decisão ocorre **em tempo de compilação**
* não é polimorfismo dinâmico

---

### Diferença essencial 🧩

* **Sobrescrita (Override)**

  * herança
  * decisão em runtime
  * base do polimorfismo

* **Sobrecarga (Overload)**

  * mesma classe
  * decisão em compile time
  * conveniência de API

Confundir os dois é comum. Dominar a diferença é profissional.

---

## Conclusão ☕🧠

Você aprendeu que:

* herança expressa relações reais
* polimorfismo elimina condicionais desnecessários
* `instanceof` é ferramenta, não muleta
* sobrecarga melhora a usabilidade da classe

Java orientado a objetos bem feito:

* tem menos `if`
* tem mais mensagens
* tem objetos responsáveis
