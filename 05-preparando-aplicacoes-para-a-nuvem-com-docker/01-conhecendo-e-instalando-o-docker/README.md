# Conhecendo e Instalando o Docker

## Conhecendo e Instalando Docker

### Introdução ao Docker e containers

**Docker** resolve um problema antigo da computação moderna:

> “Na minha máquina funciona.”

Ele faz isso usando **containers**, que são ambientes isolados, leves e reproduzíveis.

Um container:

* empacota **aplicação + dependências + configurações**
* roda de forma consistente em qualquer lugar
* compartilha o kernel do sistema operacional (por isso é rápido)

Aqui está o ponto nerd-importante:
container **não é máquina virtual**.

* Máquina virtual → virtualiza hardware inteiro + sistema operacional
* Container → virtualiza o **processo**, usando o SO do host

Resultado prático:

* containers sobem em segundos
* usam menos memória
* são perfeitos para microsserviços, APIs, workers, pipelines e cloud

Docker virou o **padrão de fato** para empacotamento e entrega de software moderno — especialmente em ambientes cloud e DevOps.

---

### Pré-requisitos e considerações sobre o laboratório de estudos

Para estudar Docker com tranquilidade, seu “laboratório” precisa ser minimamente previsível.

Requisitos básicos:

* Sistema operacional: Linux (Ubuntu é o queridinho), macOS ou Windows
* Arquitetura 64 bits
* Pelo menos 8 GB de RAM (4 GB funciona, mas com respiração ofegante)
* Acesso a terminal e permissão de administrador

Considerações importantes:

* Em **Linux**, Docker roda nativamente (melhor experiência)
* Em **Windows/macOS**, Docker roda dentro de uma VM (via Docker Desktop)
* Docker exige virtualização habilitada na BIOS (Intel VT-x ou AMD-V)

Como você já transita bem entre backend e infraestrutura, vale tratar seu ambiente como **parte do aprendizado**, não só como um detalhe operacional.

---

### Instalando o Docker

Vou focar no caminho mais sólido conceitualmente: **Docker Engine no Linux (Ubuntu)**.
É o que você mais vai encontrar em servidores cloud.

Passo mental antes do técnico:
Docker tem três peças principais:

* **Docker Engine** → o coração que roda containers
* **Docker CLI** → o comando `docker`
* **Docker Daemon** → o serviço que gerencia tudo

Instalação típica no Ubuntu:

```bash
sudo apt update
sudo apt install ca-certificates curl gnupg
```

Adicionar a chave oficial:

```bash
sudo install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
```

Adicionar o repositório:

```bash
echo \
"deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] \
https://download.docker.com/linux/ubuntu \
$(lsb_release -cs) stable" | \
sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

Instalar o Docker:

```bash
sudo apt update
sudo apt install docker-ce docker-ce-cli containerd.io
```

Verificação clássica (ritual iniciático):

```bash
sudo docker run hello-world
```

Se aparecer uma mensagem simpática dizendo que tudo deu certo, parabéns:
seu primeiro container nasceu saudável 🐳

Próximo ajuste essencial (qualidade de vida):

```bash
sudo usermod -aG docker $USER
```

Depois disso, logout/login para rodar Docker **sem sudo**.

---

### Materiais de apoio

Aqui estão fontes que valem o tempo investido:

* Documentação oficial do Docker (didática e atualizada)
* Docker Playground (ambiente online para testar sem instalar nada)
* “Docker Deep Dive” – Nigel Poulton (livro excelente)
* Canal Bret Fisher (YouTube) — DevOps sem misticismo
* Playlists sobre Docker + Java + Spring Boot (vamos cruzar esses mundos já já)

Sugestão de mentalidade:
não tente memorizar comandos.
Entenda **o modelo mental**: imagem → container → rede → volume.
