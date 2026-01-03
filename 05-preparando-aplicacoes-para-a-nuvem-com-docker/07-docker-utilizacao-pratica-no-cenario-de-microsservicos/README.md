# Docker: Utilização Prática no Cenário de Microsserviços

## Docker: do container ao cluster

### Apresentação

Docker é a ponte entre:

* código e infraestrutura
* desenvolvimento local e produção
* aplicação isolada e sistema distribuído

Com ele, você descreve **como** algo roda, e não **onde** alguém instalou manualmente. É por isso que Docker aparece naturalmente quando o assunto vira cloud, microsserviços e clusters.

---

### Migrar para uma nuvem pública

Migrar para cloud não é “subir uma VM e instalar tudo de novo”.
É mudar o **modelo mental**.

Com Docker:

* sua aplicação vira imagem
* o ambiente fica padronizado
* o provedor (AWS, Azure, GCP) vira detalhe de execução

Benefícios claros:

* menos dependência do sistema operacional
* deploy previsível
* escala sob demanda
* rollback simples

Docker funciona como uma **camada de abstração** entre você e a nuvem. Uma camada muito bem pensada, diga-se.

---

### Microsserviços

Microsserviços são aplicações divididas em **serviços pequenos, independentes e especializados**.

Docker encaixa perfeitamente porque:

* cada serviço → um container
* cada container → um processo
* comunicação via rede bem definida

Resultado:

* menos acoplamento
* deploy independente
* escala seletiva
* falha isolada (quando bem feito)

Docker não cria microsserviços sozinho, mas **remove quase todo o atrito** para adotá-los.

---

### O que é um Cluster e Docker Swarm?

Um **cluster** é um conjunto de máquinas que trabalham como se fossem uma só.

O **Docker Swarm** é o orquestrador nativo do Docker:

* transforma várias máquinas em um cluster
* gerencia containers distribuídos
* cuida de rede, escala e failover

Arquitetura básica:

* **Manager** → decide
* **Workers** → executam

Sem YAML quilométrico.
Sem dependência externa.
É o Docker dizendo: “eu resolvo isso pra você”.

---

### Entendendo as definições do primeiro container

Quando você cria um container simples, você define:

* imagem base
* comando principal
* portas
* volumes
* variáveis de ambiente

No Swarm, essas definições evoluem para **serviços**:

* não importa *qual* container
* importa *quantos* e *onde*

Você começa a pensar em **estado desejado**, não em comandos manuais.

---

### Criando um container MySQL

Exemplo clássico, ainda fora do cluster:

```bash
docker run -d \
  --name mysql-db \
  -e MYSQL_ROOT_PASSWORD=123 \
  -e MYSQL_DATABASE=appdb \
  -p 3306:3306 \
  mysql:8.0
```

Isso funciona bem localmente.
Mas em cluster… precisamos pensar diferente. Já chegamos lá.

---

### Estressando o container

Estressar é observar limites e comportamento sob carga.

Exemplo simples de carga de CPU:

```bash
docker run --rm -it alpine sh
```

Dentro do container:

```sh
yes > /dev/null
```

Agora observe:

```bash
docker stats
```

Você está vendo:

* consumo real
* impacto no host
* importância de limites de recursos

Sem estresse, não existe engenharia confiável 😄.

---

### Iniciando um cluster Swarm

Na máquina que será o manager:

```bash
docker swarm init
```

Isso cria:

* cluster Swarm
* nó manager
* token para workers

Adicionar workers (em outras máquinas):

```bash
docker swarm join --token TOKEN IP:2377
```

Agora você tem um **cluster Docker funcional**.

---

### Criando um serviço no cluster

No Swarm, você cria **serviços**, não containers individuais.

```bash
docker service create \
  --name web \
  -p 8080:80 \
  nginx
```

Ver serviços:

```bash
docker service ls
```

Ver detalhes:

```bash
docker service ps web
```

O Swarm decide:

* onde rodar
* quando reiniciar
* como balancear

Você descreve. Ele executa.

---

### Replicando um volume dentro do cluster

Aqui mora uma verdade importante:

Volumes **locais** não são automaticamente distribuídos no cluster.

Em Swarm:

* cada nó tem seu storage
* replicação exige soluções externas (NFS, GlusterFS, cloud storage)

Exemplo de volume simples (não distribuído):

```bash
docker volume create dados
```

Em produção real, você combina Swarm com:

* storage de rede
* serviços gerenciados de banco
* ou bancos externos ao cluster

Swarm resolve containers.
Dados exigem estratégia.

---

### Criando um proxy utilizando o NGINX

NGINX brilha como proxy reverso no cluster.

Exemplo conceitual:

* NGINX recebe tráfego
* encaminha para serviços internos
* faz balanceamento

Criando serviço proxy:

```bash
docker service create \
  --name proxy \
  -p 80:80 \
  nginx
```

Com configuração adequada, ele distribui requisições entre réplicas automaticamente.

É o porteiro educado do seu cluster 🧑‍✈️.

---

### Estressando o cluster

Agora o experimento fica interessante.

Crie um serviço replicado:

```bash
docker service create \
  --name web \
  --replicas 5 \
  -p 8080:80 \
  nginx
```

Estresse com múltiplas requisições (ex: `ab`, `hey`, `wrk`).

Observe:

* distribuição de carga
* reinício automático se um nó cair
* resiliência sem intervenção manual

Isso é **orquestração de verdade**, não script improvisado.

---

### Conclusão de arquiteto 🧠

Com Docker + Swarm você aprendeu a:

* sair do container único
* pensar em sistemas distribuídos
* aceitar falhas como algo normal
* escalar sem pânico

Você não está só rodando aplicações.
Está **descrevendo comportamentos desejados**.
