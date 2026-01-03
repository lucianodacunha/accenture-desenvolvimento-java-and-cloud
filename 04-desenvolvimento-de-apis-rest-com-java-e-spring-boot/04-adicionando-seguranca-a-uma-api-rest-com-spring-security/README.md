# Adicionando Segurança a uma API REST com Spring Security

### Apresentação e visão geral do curso

Neste tema, você aprende a:

* proteger endpoints REST
* controlar quem acessa o quê
* autenticar usuários
* trabalhar com tokens
* separar identidade de estado
* preparar a API para cloud e microsserviços

O objetivo não é “decorar anotações”.
É **entender o modelo mental de segurança em APIs**.

---

## Habilitando segurança com Spring

O ponto de partida é o **Spring Security**.

Ele é:

* poderoso
* flexível
* inicialmente intimidador 😄

Spring Security funciona como um **filtro** na frente da aplicação:

* intercepta requisições
* valida identidade
* decide se a requisição passa ou não

Quando você adiciona Spring Security:

* tudo passa a ser protegido por padrão
* nada entra sem permissão explícita

Isso é segurança *by default*.

---

## Autenticação simples

Primeiro degrau: **autenticação básica**.

Conceito:

* usuário + senha
* validação simples
* geralmente em memória
* ideal para aprendizado e testes

Aqui você aprende:

* como o Spring valida credenciais
* como proteger rotas
* como liberar endpoints públicos

É simples, mas revela a arquitetura interna:

* filtros
* contexto de segurança
* principal autenticado

Sem entender essa base, JWT vira mágica confusa.

---

## Configure Adapter

Historicamente, o Spring Security usava um **adapter de configuração** para:

* definir regras de acesso
* configurar autenticação
* controlar filtros

Mesmo com mudanças recentes na API, o conceito permanece:

* você descreve **como** a segurança funciona
* não escreve lógica de autenticação na mão

Mentalidade correta:

> segurança é **configuração declarativa**, não código espalhado

Aqui você começa a pensar em:

* rotas públicas
* rotas protegidas
* papéis (roles)
* responsabilidades

---

## Autenticação com banco de dados

Agora entramos no mundo real.

Usuários não vivem em memória.
Eles vivem em banco.

Essa etapa envolve:

* entidade de usuário
* senha criptografada
* repositório
* serviço de autenticação

Pontos cruciais:

* **senha nunca é armazenada em texto puro**
* uso de hash
* comparação segura
* isolamento da lógica de autenticação

Aqui segurança começa a conversar com:

* JPA
* banco de dados
* domínio da aplicação

---

## JWT – JSON Web Token (Parte 1)

JWT muda o jogo.

Ideia central:

> autenticação **sem estado** (stateless)

Em vez de:

* sessão no servidor

Você usa:

* token assinado
* enviado a cada requisição
* validado sem consultar banco toda hora

JWT contém:

* informações do usuário
* data de expiração
* assinatura

Ele não é criptografado por padrão —
ele é **assinado**, o que garante integridade.

---

## JWT – Parte 2 (Fluxo de autenticação)

Fluxo clássico:

1. usuário envia login e senha
2. API valida credenciais
3. API gera JWT
4. cliente armazena o token
5. cliente envia o token em cada requisição
6. API valida o token
7. acesso concedido ou negado

O servidor:

* não guarda sessão
* não guarda estado
* apenas valida assinatura e validade

Perfeito para cloud.

---

## JWT – Parte 3 (Integração com Spring Security)

Aqui o JWT entra no filtro de segurança.

O que acontece:

* requisição chega
* filtro extrai o token
* token é validado
* usuário é colocado no contexto de segurança
* controller nem sabe que isso aconteceu

Resultado:

* controllers limpos
* segurança centralizada
* código mais testável

Se o token for inválido:

* requisição nem chega ao controller

Elegante. Silencioso. Eficiente.

---

## JWT – Parte 4 (Autorização)

Autenticar ≠ autorizar.

* **Autenticação** → quem você é
* **Autorização** → o que você pode fazer

JWT pode carregar:

* roles
* permissões
* perfis

Spring Security usa isso para:

* liberar ou bloquear endpoints
* proteger métodos
* aplicar regras finas de acesso

Aqui você constrói APIs que:

* respeitam papéis
* isolam funcionalidades
* evitam acessos indevidos

---

## Conclusão

Você agora entende que:

* segurança começa na arquitetura
* Spring Security atua como guardião
* autenticação simples ensina a base
* banco de dados traz realidade
* JWT elimina estado
* filtros mantêm o código limpo
* autorização protege o domínio

Uma API segura:

* não confia no cliente
* não expõe detalhes internos
* falha de forma previsível
* escala com tranquilidade

---

## Para saber mais 🔭

Próximos passos naturais:

* refresh token
* logout em ambientes stateless
* OAuth2
* OpenID Connect
* integração com provedores externos
* rate limit
* auditoria e logs de segurança

Quando você domina segurança em APIs,
seu backend deixa de ser “funcional”
e passa a ser **confiável** 🔐☕.

Esse é o tipo de diferença que o mercado **nota**.
