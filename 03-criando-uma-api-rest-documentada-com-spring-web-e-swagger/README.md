# Criando uma API REST Documentada com Spring Web e Swagger

### Apresentação e visão geral do curso

Neste tema você aprende a:

* criar uma API REST com Spring Web
* expor endpoints claros e semânticos
* documentar automaticamente a API
* tratar exceções de forma centralizada
* entregar algo **consumível, testável e compreensível**

O foco não é só “responder JSON”,
é **criar um contrato confiável**.

---

## Criando uma REST API

Uma API REST em Spring segue uma estrutura mental simples:

* Controller → recebe requisição
* Service → regra de negócio
* Repository → acesso a dados
* DTO → troca de dados com o mundo externo

Você separa responsabilidades para:

* testar melhor
* evoluir sem quebrar tudo
* manter sanidade mental a longo prazo 😄

---

## RestController

O coração da API REST no Spring.

Um controller REST:

* recebe requisições HTTP
* mapeia URLs
* retorna dados (geralmente JSON)

Em vez de:

```java
@Controller
@ResponseBody
```

Você usa:

```java
@RestController
```

Isso diz ao Spring:

> “tudo aqui é resposta de API, não página HTML”.

Endpoints passam a ser definidos de forma semântica:

* GET → buscar
* POST → criar
* PUT / PATCH → atualizar
* DELETE → remover

Aqui, verbo HTTP **importa**.
URL bem nomeada **importa**.
Consistência **importa muito**.

---

## Documentando nossa API com Swagger

Aqui a API ganha voz 🎤.

Swagger (hoje baseado em OpenAPI) permite:

* documentação automática
* visualização dos endpoints
* teste direto pelo navegador
* entendimento rápido do contrato

No ecossistema Spring, isso é feito com **Springdoc OpenAPI** (a evolução natural do Swagger clássico).

Com ele, sua API passa a ter:

* descrição de endpoints
* parâmetros documentados
* exemplos de request/response
* códigos de status claros

Resultado prático:

* menos dúvidas
* menos mensagens “como uso isso?”
* mais autonomia para quem consome

Uma API sem documentação é um boato.
Uma API documentada é um acordo 🤝.

---

## Habilitando o tratamento de exceções de negócio com handlers

Aqui você sai do modo iniciante.

Problema comum:

* exceção estoura
* stack trace aparece
* cliente recebe erro confuso

Solução profissional:

* tratamento centralizado
* mensagens claras
* códigos HTTP corretos

Com handlers globais, você:

* captura exceções de negócio
* transforma em respostas padronizadas
* mantém controllers limpos

Exemplos conceituais:

* recurso não encontrado → 404
* regra de negócio violada → 400
* erro inesperado → 500

O cliente **não precisa saber**:

* nome da exceção
* stack trace
* pacote Java

Ele precisa saber:

* o que deu errado
* se foi culpa dele
* o que pode fazer agora

Isso é design de API.

---

## Conclusão

Você passou por um ciclo completo:

* criou uma API REST
* expôs endpoints claros
* documentou com Swagger
* permitiu testes interativos
* tratou exceções corretamente
* elevou o nível profissional da aplicação

Nesse ponto, sua API:

* pode ser consumida por frontend
* pode ser integrada com outros sistemas
* pode ir para cloud
* pode crescer sem virar caos
