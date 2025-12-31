# Introdução ao Java e seu Ambiente de Desenvolvimento

Perfeito. Agora começamos a **coluna vertebral** do bootcamp: Java.
Não como “linguagem antiga que ainda existe”, mas como **plataforma viva**, madura e absurdamente relevante — especialmente quando combinada com Cloud e containers ☕☁️.

---

## Introdução ao Desenvolvimento Java e Ambiente

### Apresentação

Java não é só uma linguagem.
Java é:

* uma **plataforma**
* um **ecossistema**
* uma **filosofia de portabilidade**

Você escreve código Java pensando menos no sistema operacional e mais no **problema de negócio**. O resto, a plataforma resolve. Nem sempre perfeitamente, mas com consistência impressionante ao longo de décadas.

---

### História e evolução do Java

Java nasce nos anos 90, criado pela Sun Microsystems, com uma ideia ousada para a época:

> *Write Once, Run Anywhere*
> (Escreva uma vez, rode em qualquer lugar)

Isso foi possível graças à **JVM (Java Virtual Machine)**, que executa bytecode em vez de código nativo.

Marcos importantes da evolução:

* Java 1.x → foco em portabilidade
* Java 5 → generics, annotations
* Java 8 → lambdas, streams (mudança de paradigma real)
* Java 11 → LTS moderno
* Java 17 → base sólida atual para backend e cloud
* Java 21+ → avanços em performance, virtual threads e linguagem

Hoje, Java é:

* dominante em backends corporativos
* forte em microsserviços
* extremamente comum em cloud
* base de frameworks como Spring

Java envelheceu bem. Como vinho… com garbage collector 🍷♻️.

---

### Entendendo a configuração do ambiente Java

Antes de escrever código, precisamos entender as peças.

* **JDK (Java Development Kit)**
  Ferramentas para desenvolver (javac, java, javadoc)

* **JRE (Java Runtime Environment)**
  Apenas execução (hoje embutido no JDK)

* **JVM (Java Virtual Machine)**
  Onde o código realmente roda

Regra prática moderna:

> Se você desenvolve, **instale o JDK**. Sempre.

Agora vamos às opções de instalação — cada uma com seu contexto ideal.

---

## Opção 1: Instalando o JDK Oracle pelo instalador no Windows

Oracle é a mantenedora histórica do Java.

Essa opção é comum quando:

* você usa Windows
* prefere instaladores gráficos
* precisa seguir padrões corporativos

Fluxo geral:

* baixar o instalador do JDK
* executar o `.exe`
* configurar a variável `JAVA_HOME`
* adicionar o Java ao `PATH`

Pontos de atenção:

* versões LTS são as mais usadas
* licença é gratuita para uso pessoal e desenvolvimento
* ambientes corporativos precisam atenção à política de uso

É a opção mais “clássica”. Funciona bem, mas não é a mais flexível.

---

## Opção 2: Instalando o JDK Amazon Corretto pelo terminal no Linux

Amazon Corretto é uma distribuição OpenJDK mantida pela AWS.

Excelente escolha quando:

* você usa Linux
* pensa em cloud
* quer estabilidade e suporte de longo prazo

Características:

* 100% compatível com Java padrão
* gratuito
* foco em produção
* muito usado em ambientes AWS (mas não exclusivo)

Instalação típica via gerenciador de pacotes:

* simples
* integrada ao sistema
* fácil de atualizar

É uma escolha **muito sensata** para backend moderno.

---

## Opção 3: Instalando o JDK com SDKMAN! no Linux

SDKMAN! é onde o desenvolvedor Java sorri.

SDKMAN! é um **gerenciador de versões** para:

* Java
* Maven
* Gradle
* Kotlin
* Spring CLI
* e mais

Você pode:

* instalar várias versões de Java
* alternar por projeto
* testar releases rapidamente

Exemplo conceitual:

* projeto legado → Java 11
* projeto novo → Java 17
* experimento → Java 21

Tudo no mesmo sistema, sem conflito.

Essa é a opção preferida para quem:

* estuda seriamente Java
* trabalha com múltiplos projetos
* gosta de controle fino do ambiente

SDKMAN! é para Java o que o Git é para código: depois que aprende, não volta atrás 😄.

---

### Conclusão estratégica 🧠

Java continua relevante porque:

* evoluiu sem quebrar o passado
* abraçou cloud e containers
* manteve foco em estabilidade
* construiu um ecossistema gigantesco

E o ambiente de desenvolvimento não é detalhe — é **fundação**.
Escolher bem agora evita dor de cabeça depois.

Excelente, agora estamos montando **a oficina completa** 🛠️☕.
Java sem um bom ambiente é como motor potente sem transmissão: força existe, mas não chega na roda.

---

## Introdução ao Ambiente de Desenvolvimento Java (parte 2)

### Entendendo o que são Gerenciadores de Build

Em Java, **gerenciadores de build** são ferramentas que automatizam tarefas repetitivas e críticas:

* compilar código
* baixar dependências
* rodar testes
* empacotar aplicações (JAR, WAR)
* preparar deploy

Sem isso, você:

* compila “na mão”
* gerencia JARs manualmente
* sofre em silêncio

Os dois protagonistas do ecossistema são **Apache Maven** e **Gradle**.

Modelo mental importante:

> build tool não é detalhe, é **parte da arquitetura do projeto**

---

### Instalando o Maven

Maven segue o lema: **convenção sobre configuração**.

Ele impõe:

* estrutura padrão de projeto
* ciclo de vida bem definido
* dependências declarativas (pom.xml)

No Linux com SDKMAN! (a forma mais elegante):

```bash
sdk install maven
```

Verificação:

```bash
mvn -v
```

Você verá:

* versão do Maven
* versão do Java
* sistema operacional

Maven é previsível, estável e muito comum em projetos corporativos.

---

### Instalando o Gradle

Gradle é mais moderno e flexível.

Diferenciais:

* build mais rápido (cache agressivo)
* DSL em Groovy ou Kotlin
* menos verboso que Maven

Instalação via SDKMAN!:

```bash
sdk install gradle
```

Verificação:

```bash
gradle -v
```

Gradle costuma ser favorito em:

* projetos modernos
* microsserviços
* Android
* times que gostam de controle fino

Resumo honesto:

* Maven → padrão e previsibilidade
* Gradle → performance e flexibilidade

---

## IDEs Java: o campo de batalha 🧠⚔️

IDE não é só editor.
Ela entende Java **semanticamente**.

---

### Instalando Eclipse

**Eclipse IDE** é um clássico.

Características:

* gratuito
* muito usado em universidades e empresas antigas
* altamente extensível
* consumo de memória… variável 😅

Indicado se:

* você já está acostumado
* trabalha em ambientes que padronizam Eclipse

Funciona. Mas não encanta todo mundo.

---

### Instalando VS Code

**Visual Studio Code** é um editor leve que vira IDE via extensões.

Para Java, você precisa do **Java Extension Pack**:

* suporte a Java
* Maven / Gradle
* debug
* IntelliSense

Vantagens:

* rápido
* excelente para projetos poliglotas
* ótima integração com containers

Desvantagem:

* Java funciona bem, mas não é o “idioma nativo” do VS Code

Ótima escolha se você alterna entre várias linguagens.

---

### Instalando IntelliJ IDEA

**IntelliJ IDEA** é, sem exagero, o **padrão ouro** para Java.

Pontos fortes:

* entendimento profundo da linguagem
* refatorações inteligentes
* integração absurda com Maven, Gradle, Docker e Spring
* menos configuração, mais produtividade

Existe:

* versão Community (gratuita, suficiente para Java puro)
* versão Ultimate (mais recursos enterprise)

Para quem leva Java a sério, IntelliJ vira extensão do cérebro 🧠⚡.

---

## Executando o primeiro programa no IntelliJ

Fluxo típico:

* criar novo projeto Java
* escolher JDK
* criar classe `Main`
* método `main`

Código clássico:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
```

Clique em **Run** ▶️.

Nesse momento, três coisas acontecem:

* código é compilado
* JVM é iniciada
* bytecode é executado

Você acabou de atravessar 30 anos de evolução da linguagem em um clique.

---

## Executando o primeiro programa no VS Code

Fluxo parecido, mas mais explícito:

* criar pasta do projeto
* criar arquivo `Main.java`
* garantir JDK configurado
* usar opção **Run Java**

Mesmo código:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
```

VS Code delega muito às extensões.
Funciona bem, desde que o ambiente esteja correto.

---

### Conclusão estratégica ☕🧠

Agora você entende:

* por que build tools são essenciais
* como Maven e Gradle organizam projetos
* diferenças reais entre IDEs
* como executar Java de forma moderna

Esse conjunto forma **a base profissional** do desenvolvimento Java.
