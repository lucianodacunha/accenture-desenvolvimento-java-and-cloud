## Estruturas de Controle em Java

### Estrutura Condicional `if`, `else if` e `else`

O `if` é o **porteiro lógico** do Java: só entra quem satisfaz a condição.

```java
int idade = 20;

if (idade >= 18) {
    System.out.println("Maior de idade");
} else {
    System.out.println("Menor de idade");
}
```

Com múltiplas condições:

```java
int nota = 7;

if (nota >= 9) {
    System.out.println("Excelente");
} else if (nota >= 7) {
    System.out.println("Aprovado");
} else {
    System.out.println("Reprovado");
}
```

Boas práticas:

* condições claras
* evite `if` aninhado demais
* prefira legibilidade à esperteza

Java gosta de decisões explícitas. O compilador também.

---

### Estrutura Condicional `switch case`

O `switch` é ideal quando você compara **um mesmo valor contra múltiplas opções**.

Exemplo clássico:

```java
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Domingo");
        break;
    case 2:
        System.out.println("Segunda");
        break;
    case 3:
        System.out.println("Terça");
        break;
    default:
        System.out.println("Dia inválido");
}
```

Pontos importantes:

* `break` evita o famoso *fall-through*
* `default` cobre casos não previstos

Java moderno permite `switch` mais elegante, mas dominar o clássico é essencial antes.

---

### Estrutura de Repetição `for`

O `for` é usado quando você **sabe quantas vezes** quer repetir algo.

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Valor de i: " + i);
}
```

Anatomia do `for`:

1. inicialização
2. condição
3. incremento/decremento

Ele é previsível, controlado e muito usado em loops indexados.

---

### Estruturas de Repetição `while` e `do while`

Aqui entramos no território do **repita enquanto**.

#### `while`

A condição é testada **antes** da execução:

```java
int contador = 0;

while (contador < 3) {
    System.out.println(contador);
    contador++;
}
```

Se a condição for falsa logo no início, o bloco **não executa nenhuma vez**.

---

#### `do while`

A condição é testada **depois** da execução:

```java
int numero = 10;

do {
    System.out.println(numero);
} while (numero < 5);
```

Mesmo com a condição falsa, o bloco roda **ao menos uma vez**.

Regra mental:

* `while` → talvez execute
* `do while` → executa pelo menos uma vez

---

## Exercícios

### 1️⃣ If / Else

Crie um programa que:

* receba uma idade
* informe se a pessoa é criança, adolescente ou adulta

---

### 2️⃣ Else if

Dada uma nota:

* ≥ 9 → excelente
* ≥ 7 → aprovado
* ≥ 5 → recuperação
* < 5 → reprovado

---

### 3️⃣ Switch

Crie um menu com opções:

1. Cadastrar
2. Listar
3. Sair

Use `switch` para tratar a escolha.

---

### 4️⃣ For

Imprima os números de 1 a 10 usando `for`.

Depois, imprima apenas os pares.

---

### 5️⃣ While

Use `while` para somar números de 1 a 100.

---

### 6️⃣ Do While

Crie um programa que:

* peça uma senha
* repita até a senha correta ser digitada

---

### 7️⃣ Desafio mental 🧠

Explique com suas palavras:

* quando usar `for`
* quando usar `while`
* quando usar `do while`

Sem código. Só conceito.

---

## Bônus: Configurando Git e GitHub

Aqui entra o **controle da sua evolução como desenvolvedor** 📚🚀.

### Configurando o Git localmente

```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu@email.com"
```

Verificar:

```bash
git config --list
```

---

### Fluxo básico com Git

Dentro do projeto Java:

```bash
git init
git add .
git commit -m "Primeiro commit - estrutura inicial"
```

Esse commit é seu **marco zero**.

---

### GitHub

GitHub é onde seu código ganha:

* histórico
* colaboração
* visibilidade
* backup real

Fluxo comum:

* criar repositório no GitHub
* conectar repositório local
* enviar commits (`git push`)

Cada projeto versionado é:

* aprendizado documentado
* portfólio
* rastreabilidade

---

### Conclusão ☕🧠

Estruturas de controle:

* dão poder de decisão ao código
* permitem repetição consciente
* formam a base da lógica de qualquer sistema

Git e GitHub:

* registram sua jornada
* evitam retrabalho
* transformam estudo em histórico real
