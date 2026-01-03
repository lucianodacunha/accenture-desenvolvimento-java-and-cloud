## Primeiros passos com Docker

### Realizando o download de imagens

No Docker, **imagem** é o molde.
Você não “instala” software — você **baixa imagens** prontas.

```bash
docker pull nginx
```

Isso faz o Docker:

* ir até o Docker Hub
* baixar a imagem oficial do **nginx**
* armazenar localmente em camadas (layers)

Sem versão explícita, ele assume a **tag `latest`**. Falaremos dela já já — e sim, ela causa confusão em produção.

---

### Executando um contêiner

Imagem é estática.
**Contêiner é a imagem em execução.**

```bash
docker run nginx
```

Esse comando:

* cria um container
* inicia o processo principal
* prende seu terminal ao container

Se você não mapear portas nem rodar em background, ele fica ali, existindo em silêncio contemplativo.

Rodando em background:

```bash
docker run -d nginx
```

---

### Velha sintaxe vs Nova sintaxe

Aqui existe um detalhe histórico importante.

**Velha sintaxe (ainda funciona):**

```bash
docker run -p 8080:80 nginx
```

**Nova sintaxe (mais explícita):**

```bash
docker container run -p 8080:80 nginx
```

O Docker moderno organiza tudo por **objetos**:

* docker image
* docker container
* docker volume
* docker network

A nova sintaxe deixa claro *o que* você está manipulando.
Para estudar, ela é mais pedagógica. Para digitar rápido, a velha ainda reina.

---

### Executando aplicações no contêiner

Exemplo clássico com Nginx:

```bash
docker run -d -p 8080:80 nginx
```

Agora:

* porta 80 do container
* exposta na porta 8080 do host

Acesse no navegador:

```
http://localhost:8080
```

Isso é o Docker dizendo:
“Seu aplicativo não sabe que está em um container. E isso é maravilhoso.”

---

### Excluindo e nomeando contêineres

Sem nome, Docker cria algo como:

```
elastic_banach
```

Genial, mas pouco prático.

Nomeando:

```bash
docker run -d --name meu_nginx nginx
```

Listar containers:

```bash
docker ps
docker ps -a
```

Excluir container:

```bash
docker rm meu_nginx
```

Excluir forçando (se estiver rodando):

```bash
docker rm -f meu_nginx
```

---

### Copiando arquivos **para** o contêiner

Útil para configs, scripts ou testes rápidos:

```bash
docker cp arquivo.txt meu_nginx:/usr/share/nginx/html/
```

Agora o arquivo vive dentro do container.

---

### Copiando arquivos **do** contêiner

O caminho inverso:

```bash
docker cp meu_nginx:/usr/share/nginx/html/index.html .
```
**Exemplo:**

- Descompacte o `arquivo.tar`.

```bash
tar -xf arquivo.tar
```

- isso extrairá 3 novos arquivos.
- para enviar um por vez, utilize o comando `cp`.
- para enviar todos, utilizao o `arquivo.tar`.

Docker vira uma ponte entre mundos.

---

### TAGs

Tags são **versões de imagens**.

```bash
docker pull nginx:1.25
```

Boas práticas:

* `latest` → bom para estudo, ruim para produção
* versão explícita → previsibilidade
* versões mudam, containers não gostam de surpresas

Listar imagens:

```bash
docker images
```

---

### Criando um container do MySQL

Agora entramos no território sério: **estado e dados**.

```bash
docker run -d \
  --name mysql-db \
  -e MYSQL_ROOT_PASSWORD=senha123 \
  -e MYSQL_DATABASE=appdb \
  -p 3306:3306 \
  mysql:8.0
```

Isso cria:

* um MySQL funcional
* com banco inicial
* acessível externamente

Sim, em **uma linha**.
Antigamente isso exigia café, paciência e fé.

---

### Acessando um container externamente

Via terminal:

```bash
docker exec -it mysql-db mysql -u root -p # ou

```
```bash
docker exec -it mysql-db bash
mysql -u root -p --protocol=tcp
> show databases;
+--------------------+
| Database           |
+--------------------+
| appdb              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+

```

Ou via aplicação Java:

* host: `localhost`
* porta: `3306`
* usuário: `root`
* senha: definida no `-e`

Docker não esconde serviços. Ele **expõe de forma explícita**.

**Verificando outras interfaces de rede do host**

```bash
ip addr
...
4: docker0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default 
    link/ether 7a:ab:a6:76:72:ca brd ff:ff:ff:ff:ff:ff
    inet 172.17.0.1/16 brd 172.17.255.255 scope global docker0
       valid_lft forever preferred_lft forever
    inet6 fe80::78ab:a6ff:fe76:72ca/64 scope link 
       valid_lft forever preferred_lft forever
...
```

Considerando que na criação do container, a porta 3306 já foi liberada.
Agora, com o client do banco, é possível acessá-lo remotamente.

```bash
sudo apt install mysql-client
mysql -u root -p --protocol=tcp
nter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 9.5.0 MySQL Community Server - GPL

Copyright (c) 2000, 2025, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| appdb              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0,00 sec)
```

**Acessando o banco de dados com outros client**

```bash
sudo snap install dbeaver-ce --classic
```

- Crie uma nova conexão, uma tabela e insira informações.

```sql
create table customer (
        id integer auto_increment primary key,
        nome varchar(50) not null,
        email varchar(50) not null unique
);

select * from customer;

insert into customer (nome, email) values ('Client1', 'client1@email.com');
insert into customer (nome, email) values ('Client2', 'client2@email.com');
insert into customer (nome, email) values ('Client3', 'client3@email.com');

commit;
```

---

### Parando e reiniciando um container

```bash
docker stop mysql-db
docker start mysql-db
docker restart mysql-db
```

- Acessando o container e verificando as informações:

```bash
$ mysql -u root -p --protocol=tcp
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 9.5.0 MySQL Community Server - GPL

Copyright (c) 2000, 2025, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use appdb;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+-----------------+
| Tables_in_appdb |
+-----------------+
| customer        |
+-----------------+
1 row in set (0,00 sec)

mysql> select * from customer;
+----+---------+-------------------+
| id | nome    | email             |
+----+---------+-------------------+
|  1 | Client1 | client1@email.com |
|  2 | Client2 | client2@email.com |
|  3 | Client3 | client3@email.com |
+----+---------+-------------------+
3 rows in set (0,01 sec)
```

Container parado:

* não consome CPU
* não perde configuração
* só dorme

> **Para garantir que nenhuma informação será perdida, em caso de exclusão da imagem do container, é possível mapear os dados para outra máquina, fora do container.**

---

### Lista essencial de comandos

Esses você grava no músculo:

```bash
docker pull # baixar uma image
docker run # rodar um container
docker ps # lista container em execução
docker ps -a # lista containers já iniciados pelo menos uma vez
docker images # lista images
docker exec # executar comando em container em execução
docker logs
docker stop
docker start
docker restart
docker rm # excluir containers
docker rmi # excluir images
```

Se você entende **o que cada um faz conceitualmente**, o resto é autocomplete.

__

### Outros comandos 

```bash
docker run ubuntu sleep 10 # roda por 10 segundos
docker stop name-docker # finaliza o container
docker run -it ubuntu # loga no container
docker run -dti ubuntu # roda em detach, background
docker exec -it 240 /bin/bash # acessa o bash do container id inicial 240
docker run -dti --name server nginx # nomeando um container
docker pull tomcat:9.0.113 # baixar a imagem do tomcat, informando uma tag
```
