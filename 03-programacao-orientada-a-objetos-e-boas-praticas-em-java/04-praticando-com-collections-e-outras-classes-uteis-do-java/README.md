# Praticando com Collections e Outras Classes Úteis do Java

### Trabalhando com Listas e Arrays

**Array** é simples, rápido e… rígido.

```java
int[] numeros = {1, 2, 3};
System.out.println(numeros[0]);
```

Limitações:

* tamanho fixo
* pouca flexibilidade

**List** resolve isso.

```java
List<String> nomes = new ArrayList<>();
nomes.add("Ana");
nomes.add("Bruno");
```

Use:

* `ArrayList` → acesso rápido por índice
* `LinkedList` → muitas inserções/remoções

Regra prática:

> Código moderno prefere **List** a **array**, salvo exceções de performance.

---

### Trabalhando com Set

**Set** não aceita duplicatas.

```java
Set<String> emails = new HashSet<>();
emails.add("a@email.com");
emails.add("a@email.com"); // ignorado
```

Tipos comuns:

* `HashSet` → rápido, sem ordem
* `LinkedHashSet` → mantém ordem de inserção
* `TreeSet` → ordenado

Use Set quando **unicidade** importa.

---

### Trabalhando com Map

**Map** trabalha com pares chave → valor.

```java
Map<String, Integer> idades = new HashMap<>();
idades.put("Ana", 30);
idades.put("Bruno", 25);
```

Acesso:

```java
int idade = idades.get("Ana");
```

Map é essencial para:

* dicionários
* cache
* lookup rápido

---

### Tipos primitivos e Wrappers

Primitivos:

```java
int, double, boolean
```

Wrappers:

```java
Integer, Double, Boolean
```

Por quê?

* Collections só aceitam objetos
* Wrappers permitem métodos úteis

```java
Integer x = 10; // autoboxing
int y = x;      // unboxing
```

Java faz a ponte automaticamente, mas entender isso evita bugs sutis.

---

### Classe String

`String` é **imutável**.

```java
String s = "Java";
s = s + " Cloud";
```

Cada modificação cria **um novo objeto**.

Vantagem:

* segurança
* thread-safe

Custo:

* performance se mal utilizada em loops

---

### StringBuilder e StringBuffer

Para concatenação intensiva:

```java
StringBuilder sb = new StringBuilder();
sb.append("Java");
sb.append(" Cloud");
```

Diferença:

* `StringBuilder` → rápido, não thread-safe
* `StringBuffer` → thread-safe, mais lento

Regra prática:

> Use **StringBuilder** quase sempre.

---

### Classe BigDecimal

Nunca use `double` para dinheiro 💸.

```java
BigDecimal a = new BigDecimal("10.50");
BigDecimal b = new BigDecimal("2.30");

BigDecimal total = a.add(b);
```

BigDecimal:

* precisão exata
* ideal para valores financeiros
* exige mais código, mas evita desastre

---

### Enums

Enum representa **conjunto fixo de valores**.

```java
public enum Status {
    ATIVO, INATIVO, BLOQUEADO
}
```

Uso:

```java
Status s = Status.ATIVO;
```

Enums:

* são tipos seguros
* evitam strings mágicas
* podem ter métodos e atributos

---

### Classe Optional

Optional evita `NullPointerException`.

```java
Optional<String> nome = Optional.of("Ana");
```

Ou vazio:

```java
Optional<String> vazio = Optional.empty();
```

Uso correto:

```java
nome.ifPresent(System.out::println);
```

Regra de ouro:

> Optional é para **retorno de método**, não para atributos.

---

## Introdução à API de Streams

Streams permitem processar coleções de forma **declarativa**.

```java
List<Integer> nums = List.of(1, 2, 3, 4);

nums.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);
```

Você diz **o que quer**, não **como iterar**.

---

### Explorando a API de Streams

Exemplo mais completo:

```java
List<String> nomes = List.of("Ana", "Bruno", "Carlos");

List<String> resultado =
    nomes.stream()
         .filter(n -> n.length() > 4)
         .map(String::toUpperCase)
         .toList();
```

Streams são:

* poderosos
* expressivos
* fáceis de ler quando bem usados

Evite streams excessivamente complexos. Clareza vem primeiro.

---

### Generics

Generics garantem **segurança de tipos**.

```java
List<String> lista = new ArrayList<>();
```

Sem generics:

```java
List lista = new ArrayList(); // perigoso
```

Com generics:

* erros aparecem em compile-time
* menos casts
* código mais confiável

---

## Datas e Tempo (parte sensível do Java 😄)

### Classe Date e Calendar

São **legadas** e problemáticas.

```java
Date d = new Date();
Calendar c = Calendar.getInstance();
```

Use apenas em código legado.

---

### API moderna de datas (java.time)

Essas são as corretas hoje:

* `LocalDate` → data
* `LocalTime` → hora
* `LocalDateTime` → data + hora
* `OffsetDateTime` → data + hora + offset
* `OffsetTime` → hora + offset

Exemplo:

```java
LocalDate hoje = LocalDate.now();
LocalDateTime agora = LocalDateTime.now();
```

Essas classes são:

* imutáveis
* thread-safe
* muito mais claras

---

## Classe Thread e Interface Runnable

Concorrência básica em Java.

Forma antiga:

```java
Thread t = new Thread(() -> {
    System.out.println("Executando em outra thread");
});
t.start();
```

Ou com Runnable:

```java
Runnable tarefa = () -> System.out.println("Executando");
new Thread(tarefa).start();
```

Pontos importantes:

* `start()` cria nova thread
* `run()` executa na thread atual (armadilha clássica)

Hoje, Java moderno usa:

* executors
* pools de threads
* virtual threads (Java 21+)

Mas entender o básico é essencial.

---

## Conclusão ☕🧠

Você passou por:

* Collections (List, Set, Map)
* Strings e números seguros
* enums e Optional
* Streams e Generics
* datas modernas
* fundamentos de concorrência

Esse conjunto é o **arsenal real** do desenvolvedor Java.
