# Trabalhando com Docker Compose

Agora chegamos ao ponto em que o Docker para de ser “um monte de comandos” e vira **orquestração de bom senso** 🎼🐳.
Se o Docker roda containers, o **Docker Compose** ensina vários containers a conviverem em harmonia — sem brigas por porta, rede ou sanidade mental.

---

## Docker Compose

### Introdução e instalação do Docker Compose

**Docker Compose** é uma ferramenta para definir e executar **aplicações multi-contêiner** usando um único arquivo YAML (`docker-compose.yml`).

Ideia central:

* descreva serviços
* descreva redes
* descreva volumes
* suba tudo com **um comando**

Hoje, o Compose já vem integrado ao Docker moderno como:

```bash
docker compose
```

Verificando a instalação:

```bash
docker compose version
```

Se aparecer a versão, você está pronto.
Nada de instalar binários extras ou scripts mágicos.

Modelo mental importante:

> Dockerfile define **uma imagem**
> Docker Compose define **um sistema**

---

### Docker Compose: exemplo prático (mínimo e honesto)

Antes de tudo, instalar o docker composto:

```bash
sudo apt-get install docker-compose
```


Arquivo `docker-compose.yml`:

```yaml
version: "3.9"

services:
  web:
    image: nginx
    ports:
      - "8080:80"
```

Subindo a aplicação:

```bash
docker compose up
```

Em background:

```bash
docker compose up -d
```

Parando tudo:

```bash
docker compose down
```

Você acabou de:

* criar rede automaticamente
* criar container
* expor porta
* organizar tudo em um arquivo legível

Sem precisar decorar comandos longos.

---

### docker compose down (o botão “desligar tudo”)

Esse comando é subestimado, mas poderoso:

```bash
docker compose down
```

Ele:

* para todos os containers
* remove containers
* remove rede criada
* mantém volumes (por padrão)

Se quiser remover volumes também:

```bash
docker compose down -v
```

Use com cuidado. Dados têm sentimentos 💾😅.

---

### Exemplo: PHP + Apache + MySQL

Aqui o Compose mostra seu verdadeiro valor.

```yaml
version: "3.9"

services:
  web:
    image: php:8.2-apache
    container_name: php_apache
    ports:
      - "8080:80"
    volumes:
      - ./src:/var/www/html
    depends_on:
      - db

  db:
    image: mysql:8.0
    container_name: mysql_db
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: appdb
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

Estrutura do projeto:

```
.
├── docker-compose.yml
└── src/
    └── index.php
```

`index.php`:

```php
<?php
phpinfo();
```

Subindo tudo:

```bash
docker compose up -d
```

O que aconteceu:

* PHP + Apache rodando
* MySQL persistente
* rede interna automática
* containers se comunicam por nome (`db`)

Isso é **ambiente completo em minutos**, não horas.

---

### Utilizando exemplos do GitHub do Docker

O Docker mantém um repositório oficial com exemplos reais, didáticos e atualizados.

Lá você encontra:

* stacks com banco, cache, backend e frontend
* exemplos de produção
* boas práticas de Compose
* casos reais (WordPress, Redis, PostgreSQL, etc.)

Fluxo recomendado de estudo:

1. clonar um exemplo
2. ler o `docker-compose.yml`
3. subir com `docker compose up`
4. modificar algo pequeno
5. observar o impacto

Aprender Compose lendo YAML é como aprender arquitetura lendo plantas 🏗️.

---

### Conclusão mental 🧠

Docker Compose resolve três grandes dores:

* repetição de comandos
* configuração espalhada
* ambientes inconsistentes

Com ele, você:

* descreve sistemas inteiros
* versiona infraestrutura
* replica ambientes com facilidade
