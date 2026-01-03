# Armazenamento de Dados com Docker

Aqui entramos num ponto **crítico e libertador** do Docker:
containers são efêmeros… **dados não podem ser**.
Se você não dominar armazenamento, seu sistema vira um castelo de areia na primeira reinicialização 🌊🏰.

---

## Armazenamento de dados com Docker

### Montando (mount) um local de armazenamento

Por padrão, tudo que acontece **dentro do container** morre com ele.
Para evitar isso, usamos **mounts** — pontos onde o container acessa dados **fora** do seu sistema de arquivos interno.

- Para saber onde o mysql armazena seus dados no container:

```bash
docker inspect mysql-db | grep "Destination"
"Destination": "/var/lib/mysql",
```

A ideia mental é simples:

* container → temporário
* volume/mount → persistente

Docker conecta esses mundos usando mounts.

Sintaxe geral:

```bash
docker run -v origem:destino imagem
```

Ou na forma moderna:

```bash
docker run --mount type=...,source=...,target=...
```

---

### Tipos de mount

Docker trabalha essencialmente com três formas de armazenamento.

#### 1. Bind Mount

Você liga **diretamente** uma pasta do host ao container.

```bash
-v /home/luciano/site:/usr/share/nginx/html
```

Características:

* caminho explícito no host
* ótimo para desenvolvimento
* reflete mudanças em tempo real
* acopla container ao SO

É o tipo mais “cru”, mas extremamente poderoso.

---

#### 2. Named Volume

Docker gerencia o armazenamento para você.

```bash
-v dados_mysql:/var/lib/mysql
```

Características:

* independente do caminho do host
* mais seguro e portátil
* ideal para produção
* recomendado para bancos de dados

Aqui o Docker vira o zelador dos dados 🧹📦.

---

#### 3. Volume no Dockerfile

Você pode declarar que um container **espera** dados persistentes.

```dockerfile
VOLUME /var/lib/mysql
```

Isso:

* não cria o volume automaticamente
* documenta a intenção
* delega a decisão ao runtime

É um aviso elegante para quem vier depois.

---

### Exemplos de mounts na prática

#### Bind mount (desenvolvimento)

```bash
docker run -d \
  -p 8080:80 \
  -v $(pwd):/usr/share/nginx/html \
  nginx
```

Alterou um arquivo local → refletiu no navegador.
Sem rebuild, sem stress.

---

#### Named volume (produção / dados)

```bash
docker volume create dados_mysql
```

```bash
docker run -d \
  --name mysql-db \
  -e MYSQL_ROOT_PASSWORD=123 \
  -v dados_mysql:/var/lib/mysql \
  mysql:8.0
```

Pode apagar o container inteiro.
O banco continua lá, firme e resiliente 💾.

---

### Mount: conclusão

Regra de ouro:

* **Código** → bind mount (dev)
* **Dados** → named volume
* **Configuração** → depende do contexto

Mounts transformam containers de descartáveis em **peças confiáveis de arquitetura**.

---

## Exemplo: Apache em container

Apache clássico, simples e didático.

```bash
docker run -d \
  --name apache-web \
  -p 8080:80 \
  -v $(pwd)/site:/usr/local/apache2/htdocs \
  httpd
```

Estrutura:

* HTML fica no host
* Apache serve do container
* edição instantânea

Você acabou de criar um servidor web sem instalar Apache no sistema.

---

## Exemplo: PHP + Apache

Aqui o Docker brilha de verdade.

```bash
docker run -d \
  --name php-apache \
  -p 8080:80 \
  -v $(pwd):/var/www/html \
  php:8.2-apache
```

Crie um arquivo `index.php`:

```php
<?php
phpinfo();
```

Abra no navegador.
PHP rodando. Apache servindo. Nenhuma instalação local.
Magia? Não. **Isolamento bem feito**.

---

### Outros exemplos de uso

- Criando um named data entre o host/container 

```bash
$ docker run -d \
> --name ubuntu-srv \
> -dti \
> --mount type=bind,src=$(pwd)/ubuntu_local_data,dst=/data ubuntu
```

- restringindo escrita

```bash
docker run -d --name ubuntu-srv -dti --mount type=bind,src=$(pwd)/
ubuntu_local_data,dst=/data,ro ubuntu
```

- acessando o container

```bash
touch arquivo4
touch: cannot touch 'arquivo4': Read-only file system
```

- listando volume criado indiretamente
```bash
$ docker volume ls
DRIVER    VOLUME NAME
local     7dc3d0f1d924f1a90c8651b5a2257bc49e272ff128eb467e7b457158ec038b0e
local     8ec1fb69018bf1f63ded4e20c5c186f02a7cfad7bd04f1a400a1d5a1db7dc6f2
local     53c1ce339deb4c02e91314307df8707c99d71540d473aee02d3ca4de1fc9650c
local     3241bacb65b2d1b38f2fcf94a1e9f1670de3f4235a7dc562b4e1ba6d2372b15c
local     51106c9156ac8afe86a10fa9c7ef80a74966359f669e18869ca315734f163f04
local     706112b5b48b61ed664cf18ecd859333518d09b8d4888f8b9d2162036daaec62
local     d9f145ed03af23559b8762361295ceab3873ba2803a9e62b446136473d57d8f9
local     dfb07c52af7874165ef1f275b2ef118174b5c37d9acf1db22d1e76318fd43676
```

- criando um novo volume

```bash
$ docker volume ls
DRIVER    VOLUME NAME
local     7dc3d0f1d924f1a90c8651b5a2257bc49e272ff128eb467e7b457158ec038b0e
local     8ec1fb69018bf1f63ded4e20c5c186f02a7cfad7bd04f1a400a1d5a1db7dc6f2
local     53c1ce339deb4c02e91314307df8707c99d71540d473aee02d3ca4de1fc9650c
local     3241bacb65b2d1b38f2fcf94a1e9f1670de3f4235a7dc562b4e1ba6d2372b15c
local     51106c9156ac8afe86a10fa9c7ef80a74966359f669e18869ca315734f163f04
local     706112b5b48b61ed664cf18ecd859333518d09b8d4888f8b9d2162036daaec62
local     d9f145ed03af23559b8762361295ceab3873ba2803a9e62b446136473d57d8f9
local     data-ubuntu
local     dfb07c52af7874165ef1f275b2ef118174b5c37d9acf1db22d1e76318fd43676
```
- criando um novo container

```bash
docker run -d \
> --name ubuntu-vol 
> -dti \
> --mount type=volume,src=data-ubuntu,dst=/data ubuntu
```

- acessando o container

```bash
docker exec -ti ubuntu-vol bash
ls data/
```

- excluindo volumes e containers

```bash
docker volume rm data-ubuntu
docker volume prune # excluir todos os volumes criados, não utilizados.
docker container prune # excluir todos os containers, não utilizados.
```

