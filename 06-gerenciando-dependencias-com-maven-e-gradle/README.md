# Gerenciando Dependências com Maven e Gradle

### Instalando Maven

**Apache Maven** é o veterano confiável do ecossistema Java.

Instalação clássica:

* baixar o binário
* configurar `JAVA_HOME`
* adicionar o Maven ao `PATH`

Verificação:

```bash
mvn -v
```

Se aparecer versão do Maven e do Java, está tudo certo.

Essa abordagem funciona, mas é **pouco flexível** quando você precisa de várias versões.

---

### Instalando Maven com SDKMAN! e criando projetos

Aqui entra o modo desenvolvedor profissional 😄.

Com **SDKMAN!**:

```bash
sdk install maven
```

Criando um projeto Maven padrão:

```bash
mvn archetype:generate \
  -DgroupId=com.exemplo \
  -DartifactId=meu-projeto \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

Isso cria:

* estrutura padrão
* `pom.xml`
* código inicial

O Maven impõe organização desde o primeiro minuto.
Isso é uma vantagem, não uma limitação.

---

### Concluindo o projeto (ciclo de vida Maven)

Maven funciona por **fases bem definidas**:

```bash
mvn clean
mvn compile
mvn test
mvn package
mvn install
```

Comando mais comum:

```bash
mvn clean package
```

Ele:

* limpa builds anteriores
* compila
* testa
* gera o JAR/WAR

Você não precisa decorar tudo.
Precisa entender que existe um **ciclo previsível**.

---

### Instalando Gradle

**Gradle** é mais novo, mais rápido e mais flexível.

Instalação com SDKMAN!:

```bash
sdk install gradle
```

Verificação:

```bash
gradle -v
```

Gradle gosta de performance, cache e builds inteligentes.

---

### Criando um projeto Gradle

Criar projeto interativo:

```bash
gradle init
```

Você escolhe:

* tipo de projeto (application, library)
* linguagem (Java)
* DSL (Groovy ou Kotlin)

Estrutura típica:

* `build.gradle` ou `build.gradle.kts`
* `settings.gradle`
* `src/main/java`

Gradle não força tantas convenções quanto Maven —
ele confia mais em você (e cobra por isso).

---

### Mas afinal, por que usar Maven ou Gradle?

Aqui vai a resposta honesta, sem torcida organizada.

**Sem build tool:**

* dependências manuais
* builds inconsistentes
* dor e sofrimento

**Com Maven:**

* padrão consolidado
* curva de aprendizado menor
* ideal para projetos corporativos
* excelente previsibilidade

**Com Gradle:**

* builds mais rápidos
* scripts mais flexíveis
* muito usado em projetos modernos
* padrão no Android

Resumo prático:

* **Maven** → simplicidade e padrão
* **Gradle** → flexibilidade e performance

Ambos resolvem o problema central:
**gerenciar dependências e automatizar builds**.

---

### Migrando projeto Maven para Gradle

Motivos comuns:

* performance
* padronização com outros projetos
* Android ou stacks modernas

Caminho recomendado:

1. manter `pom.xml`
2. gerar arquivos Gradle automaticamente
3. ajustar dependências
4. validar build

Gradle possui ferramenta auxiliar:

```bash
gradle init
```

Ela consegue:

* ler `pom.xml`
* gerar `build.gradle`
* manter dependências

Depois disso, revise manualmente.
Migração nunca é 100% automática.

---

### Migrando projeto Gradle para Maven

Menos comum, mas acontece.

Motivos:

* padronização corporativa
* times acostumados ao Maven
* pipelines existentes

Caminho:

1. mapear dependências do `build.gradle`
2. recriar no `pom.xml`
3. ajustar plugins
4. validar ciclo de build

Aqui o trabalho é mais manual.
Mas o modelo mental é o mesmo: dependências, plugins, ciclo de vida.

---

### Comparação mental rápida 🧠

* Maven → **XML declarativo**

* Gradle → **script (Groovy/Kotlin)**

* Maven → “faça do jeito padrão”

* Gradle → “faça do jeito que você quiser”

Nenhum é “melhor” universalmente.
O melhor é o que **se encaixa no contexto do time e do projeto**.

---

## Conclusão ☕🚀

Você agora entende:

* como instalar e usar Maven e Gradle
* como criar projetos do zero
* por que essas ferramentas existem
* quando faz sentido migrar
* que build tool é decisão arquitetural

Sem Maven ou Gradle, Java moderno **não escala**.
Com eles, o foco volta para onde importa: **o código e o domínio do problema**.
