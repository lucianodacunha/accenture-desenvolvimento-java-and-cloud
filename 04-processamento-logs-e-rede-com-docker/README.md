# Processamento, Logs e Rede com Docker

Aqui entramos no **lado sistêmico** do Docker: quando o container deixa de ser só “um programa rodando” e passa a ser **um cidadão com direitos e limites** dentro do sistema operacional.
Processamento, logs e rede são o trio que separa brincadeira de engenharia 🧠⚙️🌐.

---

## Processamento, logs e rede com Docker

### Limitando memória e CPU

Por padrão, um container pode ser guloso.
Se você não disser “até aqui”, ele entende “vá em frente”.

#### Limite de memória

```bash
docker run -d \
  --memory=512m \
  nginx
```

Aqui o container:

* pode usar **no máximo 512 MB**
* se ultrapassar → é morto pelo kernel (OOM Killer)

Isso é crucial em ambientes cloud, onde memória é dinheiro queimando 🔥💸.

#### Limite de CPU

```bash
docker run -d \
  --cpus="1.5" \
  nginx
```

Significa:

* pode usar até 1.5 núcleos de CPU
* não bloqueia outros containers
* trabalha com **cgroups**, não com “travas duras”

Docker não isola só arquivos. Ele conversa diretamente com o kernel Linux para **negociar recursos**.

**Limitando recursos de um container já existente**

```bash
docker update apache-web -m 512M --cpus 0.1
```

- Stressando o container, no container execute:

```bash
stress --cpu 1 --vm-bytes 50M --vm 1 --vm-bytes 250M
```

- No host, verifique

```bash
docker stats apache-web

CONTAINER ID   NAME         CPU %     MEM USAGE / LIMIT   MEM %     NET I/O          BLOCK I/O       PIDS 
84dc1c33e48a   ubuntu-lim   30.32%    44.03MiB / 256MiB   17.20%    38.1MB / 156kB   166MB / 276MB   7
```

---

### Informações, logs e processos

#### Informações do container

Quer saber o “estado clínico” de um container?

```bash
docker stats
```

Mostra em tempo real:

* uso de CPU
* uso de memória
* I/O de rede
* I/O de disco

É o monitor cardíaco do Docker ❤️📈.

Para detalhes completos:

```bash
docker inspect nome_container
```

Aqui está tudo:

* IP interno
* volumes
* variáveis de ambiente
* limites configurados

Verbose, mas poderoso.

**Outros comandos**

- docker info

---

#### Logs

Docker captura tudo que o processo escreve em:

* stdout
* stderr

```bash
docker logs nome_container
```

Seguir logs em tempo real:

```bash
docker logs -f nome_container
```

Isso muda a forma de pensar logs:

* não escreva em arquivos dentro do container
* escreva no console
* deixe a plataforma cuidar da coleta

Essa ideia escala absurdamente bem.

---

#### Processos dentro do container

Um container não é uma VM.
Ele geralmente roda **um processo principal**.

Ver processos ativos:

```bash
docker top nome_container
```

Entrar no container:

```bash
docker exec -it nome_container bash
```

Aqui ocorre a revelação filosófica:

> container é só um processo isolado com privilégios controlados

Nada místico. Só engenharia elegante.

---

### Redes no Docker

Rede é onde containers começam a **conversar entre si**.

#### Bridge (padrão)

Quando você roda:

```bash
docker run nginx
```

O container entra automaticamente em uma rede **bridge**.

Características:

* IP interno
* acesso externo via port mapping
* containers podem se falar pelo IP

Listar redes:

```bash
docker network ls
```

Inspecionar:

```bash
docker network inspect bridge
```

---

#### Criando sua própria rede

```bash
docker network create minha_rede
```

Usando:

```bash
docker run -d \
  --name app \
  --network minha_rede \
  nginx
```

Agora os containers:

* se resolvem pelo **nome**
* não precisam de IP fixo
* ficam isolados do resto

Isso é DNS interno automático.
Sem configurar nada. Simplesmente funciona.

---

#### Exemplo prático: app + banco

```bash
docker network create app_net
```

```bash
docker run -d \
  --name mysql-db \
  --network app_net \
  -e MYSQL_ROOT_PASSWORD=123 \
  mysql:8.0
```

```bash
docker run -d \
  --name app-java \
  --network app_net \
  minha-imagem-java
```

Na aplicação Java:

* host do banco: `mysql-db`
* porta: `3306`

Sem IP. Sem gambiarra. Sem dor.

---

### Conclusão mental 🧩

Docker te dá três superpoderes fundamentais:

* **Processamento** → limites claros, previsíveis
* **Logs** → observabilidade simples e centralizada
* **Rede** → comunicação limpa, isolada e nomeada

Quando você domina isso, começa a pensar diferente:

* menos “configurar servidor”
* mais “descrever comportamento”
