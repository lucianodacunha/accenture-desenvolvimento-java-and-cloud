# Debugging e o Tratamento de Exceções em Java

### Entendendo Exceptions

Uma **exception** representa uma situação anormal que ocorre **durante a execução** do programa.

Em Java, exceções são **objetos** e fazem parte de uma hierarquia bem definida.

Visão mental simplificada:

```
Throwable
 ├── Error
 └── Exception
      ├── RuntimeException
      └── Checked Exceptions
```

#### Error

* problemas graves
* geralmente fora do controle da aplicação
  Ex: `OutOfMemoryError`

👉 **Não trate**. Corrija a causa.

---

#### Exceptions

Dividem-se em dois grandes grupos:

##### Checked Exceptions

* verificadas em tempo de compilação
* o compilador obriga tratamento

Exemplo:

```java
IOException
SQLException
```

Se não tratar, o código **nem compila**.

---

##### Unchecked Exceptions (RuntimeException)

* ocorrem em tempo de execução
* não são obrigatórias de tratar

Exemplos clássicos:

```java
NullPointerException
IllegalArgumentException
ArithmeticException
```

Essas são as que mais mordem distraídos 🐍.

---

### Exemplo simples de exceção

```java
int a = 10;
int b = 0;

int resultado = a / b; // ArithmeticException
```

O programa compila.
O programa roda.
O programa cai.

Java não finge que nada aconteceu — ele **grita** com stack trace.

---

## Debugging e Exceções em Java

### O que é Debugging?

Debugging é o processo de:

* entender **por que** algo deu errado
* observar o estado do programa
* acompanhar a execução passo a passo

Não é “caçar erro”.
É **investigação científica aplicada ao código** 🔬.

---

### Ferramentas básicas de Debug

#### 1️⃣ Stack Trace

Quando uma exceção ocorre, Java imprime algo assim:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Main.main(Main.java:5)
```

Leia de baixo para cima:

* arquivo
* linha
* método

O erro quase sempre está **na primeira linha do seu código**, não nas internas da JVM.

---

#### 2️⃣ Debugger da IDE

No IntelliJ / VS Code / Eclipse você pode:

* colocar breakpoints
* executar linha por linha
* inspecionar variáveis
* alterar valores em runtime

Isso muda completamente sua relação com bugs.

Regra prática:

> Print serve para aprender.
> Debugger serve para entender.

---

### Debugging + exceção juntos

```java
public static int dividir(int a, int b) {
    return a / b;
}
```

Coloque um breakpoint:

* observe `a`
* observe `b`
* veja o momento exato da falha

Você deixa de **supor** e passa a **ver**.

---

## Gerenciando Exceções em Java

Agora a parte que separa código amador de código profissional.

---

### Try / Catch

Forma básica:

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Erro: divisão por zero");
}
```

O programa:

* tenta executar
* captura a exceção
* continua rodando

Exceção não tratada mata o programa.
Exceção tratada vira fluxo controlado.

---

### Múltiplos catch

```java
try {
    // código
} catch (NumberFormatException e) {
    // erro de conversão
} catch (ArithmeticException e) {
    // erro matemático
}
```

Ordem importa:

* exceções mais específicas primeiro
* genéricas depois

---

### Catch genérico (com cuidado)

```java
catch (Exception e) {
    e.printStackTrace();
}
```

Útil para:

* camadas mais externas
* logging
* fallback

Perigoso se:

* esconder erros
* engolir exceções silenciosamente

---

### Finally

Executa **sempre**, com erro ou sem erro.

```java
try {
    // código
} catch (Exception e) {
    // tratamento
} finally {
    System.out.println("Sempre executa");
}
```

Muito usado para:

* fechar recursos
* liberar conexões
* limpeza de estado

---

### Try-with-resources (Java moderno)

Forma correta de lidar com recursos:

```java
try (Scanner sc = new Scanner(System.in)) {
    System.out.println(sc.nextLine());
}
```

O Java garante:

* fechamento automático
* menos código
* menos vazamento de recurso

Sempre prefira essa forma quando disponível.

---

### Criando exceções personalizadas

Quando o domínio do problema pede algo mais específico:

```java
public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
```

Uso:

```java
if (saldo < valor) {
    throw new SaldoInsuficienteException("Saldo insuficiente");
}
```

Isso torna o código:

* mais expressivo
* mais semântico
* mais fácil de manter

---

### `throw` vs `throws`

Diferença fundamental:

```java
throw new IllegalArgumentException("Erro");
```

👉 lança a exceção

```java
public void metodo() throws IOException {
    // código
}
```

👉 declara que **pode lançar**

Um lança.
O outro avisa.

---

### Boas práticas de exceções 🧠

* exceção **não é fluxo normal**
* não capture exceção para ignorar
* mensagens devem ajudar quem vai ler o log
* trate onde fizer sentido
* propague quando não souber resolver

---

## Conclusão ☕🧠

Você aprendeu que:

* exceções fazem parte do design
* debugging é observação, não chute
* stack trace é aliado, não inimigo
* tratar exceções é decidir responsabilidades
* código robusto assume falhas

Programas que nunca falham…
…normalmente não fazem nada importante.
