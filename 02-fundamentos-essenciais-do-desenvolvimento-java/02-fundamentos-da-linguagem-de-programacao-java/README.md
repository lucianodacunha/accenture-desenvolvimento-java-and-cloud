## Fundamentos da Linguagem de Programação Java

### Padrões de desenvolvimento e conceitos

Java foi desenhado com algumas ideias muito claras desde o início:

* **Tipagem forte e estática**
  O tipo de uma variável importa e é conhecido em tempo de compilação.
  Isso reduz erros e aumenta previsibilidade.

* **Orientação a Objetos**
  Tudo gira em torno de classes, objetos, estado e comportamento.

* **Legibilidade acima de esperteza**
  Código Java tende a ser explícito. Menos truques, mais clareza.

* **Portabilidade via JVM**
  O código vira bytecode, não binário específico de sistema.

Esses padrões moldam o “jeito Java” de pensar:
clareza, segurança e manutenção a longo prazo.

---

### Keywords e tipos primitivos

#### Keywords (palavras reservadas)

Java possui palavras com significado especial, que **não podem ser usadas como identificadores**.

Exemplos importantes:

* controle de fluxo: `if`, `else`, `switch`, `for`, `while`
* definição: `class`, `interface`, `enum`
* modificadores: `public`, `private`, `protected`, `static`, `final`
* outros essenciais: `new`, `return`, `this`, `super`

Elas definem a gramática da linguagem.
Tentar lutar contra isso só gera frustração.

---

#### Tipos primitivos

Java possui 8 tipos primitivos:

```java
byte    // 8 bits
short   // 16 bits
int     // 32 bits (o mais usado)
long    // 64 bits

float   // 32 bits
double  // 64 bits (padrão para decimais)

char    // caractere Unicode
boolean // true ou false
```

Boas práticas:

* use `int` como padrão para inteiros
* use `double` para cálculos decimais
* evite `float` salvo quando memória for crítica
* `boolean` não é 0 ou 1 (isso não é C 😄)

---

### Trabalhando com Operadores de Atribuição e Lógicos

#### Operadores de atribuição

```java
int x = 10;
x += 5;   // x = x + 5
x -= 2;   // x = x - 2
x *= 3;   // x = x * 3
x /= 2;   // x = x / 2
```

Eles existem para:

* reduzir verbosidade
* tornar intenção clara

---

#### Operadores lógicos

```java
boolean a = true;
boolean b = false;

a && b   // AND lógico
a || b   // OR lógico
!a       // NOT
```

Curiosidade importante:

* `&&` e `||` usam **short-circuit**
* o segundo operando pode nem ser avaliado

Isso afeta lógica, performance e até bugs sutis.

---

### Trabalhando com Operadores Aritméticos

Os operadores aritméticos são diretos:

```java
int a = 10;
int b = 3;

a + b   // soma
a - b   // subtração
a * b   // multiplicação
a / b   // divisão inteira
a % b   // resto (módulo)
```

Atenção clássica:

```java
10 / 3   // resultado: 3
10.0 / 3 // resultado: 3.333...
```

Java não “adivinha” sua intenção.
Tipo manda no comportamento.

---

### Trabalhando com Operadores Bitwise (Bit-a-Bit)

Aqui entramos em território mais baixo nível — raramente usado no dia a dia, mas importante para **entender a máquina**.

Principais operadores:

```java
&   // AND bit a bit
|   // OR bit a bit
^   // XOR
~   // NOT
<<  // deslocamento à esquerda
>>  // deslocamento à direita
>>> // deslocamento sem sinal
```

Exemplo simples:

```java
int a = 5;   // 0101
int b = 3;   // 0011

a & b  // 0001 -> 1
a | b  // 0111 -> 7
a ^ b  // 0110 -> 6
```

Onde isso aparece?

* manipulação de flags
* criptografia
* compressão
* sistemas embarcados
* otimizações específicas

Não é comum em CRUDs, mas aparece em bibliotecas e frameworks.

---

## Exercícios

### 1️⃣ Tipos e atribuição

Crie variáveis para:

* idade (int)
* altura (double)
* ativo (boolean)

Imprima todas.

---

### 2️⃣ Operadores aritméticos

Dado dois números inteiros:

* imprima soma, subtração, multiplicação, divisão e resto

Teste com números que não dividem exatamente.

---

### 3️⃣ Operadores lógicos

Crie um programa que:

* verifica se uma pessoa pode dirigir
* idade ≥ 18 **e** possui habilitação

---

### 4️⃣ Short-circuit

Crie um exemplo onde:

* o segundo operando **não** é avaliado
* explique o porquê no comentário

---

### 5️⃣ Bitwise

Dado dois números:

* imprima o resultado de `&`, `|` e `^`
* exiba os valores decimais

---

### 6️⃣ Desafio mental 🧠

Explique a diferença entre:

```java
x = x + 1;
x += 1;
x++;
```

Quando cada um é mais adequado?

---

### Conclusão

Esses fundamentos:

* parecem simples
* sustentam todo o resto
* evitam bugs silenciosos
* tornam o código previsível

Java recompensa quem domina o básico.
Não com magia, mas com **robustez e longevidade** ☕🏗️.
