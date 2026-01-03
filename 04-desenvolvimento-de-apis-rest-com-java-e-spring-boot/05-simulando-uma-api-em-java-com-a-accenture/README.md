# Simulando uma API em Java com a Accenture

## Desafio

###  Simulador De API: Processamento De Comandos Em Java

Você é um consultor de gestão em tecnologia da informação contratado por uma empresa que deseja simular o funcionamento de uma API interna para treinar sua equipe. O objetivo é criar um sistema simples que receba comandos de consulta e retorne respostas padronizadas, como se estivesse interagindo com um serviço real. Cada comando recebido representa uma requisição à API, e sua tarefa é processar o comando e retornar a resposta apropriada, conforme as regras de negócio estabelecidas pela empresa. O sistema deve ser robusto para lidar tanto com comandos válidos quanto inválidos, fornecendo mensagens claras para cada situação. Sua solução será utilizada como base para treinar desenvolvedores iniciantes sobre o funcionamento básico de APIs e tratamento de respostas.

Implemente um programa que leia uma string representando um comando de consulta. Se o comando for "GET_STATUS", retorne "API OK". Se o comando for "GET_VERSION", retorne "v1.0.0". Se o comando for "RESTART", retorne "RESTARTING". Para qualquer outro comando, retorne "INVALID COMMAND". Não utilize bibliotecas externas. O programa deve processar apenas um comando por execução.

## Entrada

Uma única linha contendo uma string representando o comando de consulta enviado à API.

## Saída

Uma única linha contendo a resposta da API simulada, de acordo com as regras especificadas.

## Exemplos

A tabela abaixo apresenta exemplos de entrada e saída:

|Entrada| 	Saída|
|---|---|
|GET_STATUS| 	API OK|
|GET_VERSION| 	v1.0.0|
|RESTART| 	RESTARTING|
|SHUTDOWN| 	INVALID COMMAND|
---
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.nextLine();

        // TODO: Imprima a resposta correta de acordo com o comando recebido
        // Dica: Use estrutura condicional para comparar o comando e imprimir a resposta esperada
    }
}
```
## Desafio

### Simulação De API Para Consulta De Status De Projetos

Você foi contratado como consultor de tecnologia da informação para a empresa fictícia TechVision, que está modernizando seus processos internos. O time de gestão deseja simular o funcionamento de uma API simples para consulta de status de projetos, mas sem utilizar servidores reais. Sua missão é criar um programa que simule o endpoint de consulta: ao receber o nome de um projeto, o sistema deve retornar o status correspondente. Os dados de status estão pré-definidos e não mudam durante a execução. Caso o projeto consultado não exista, o sistema deve retornar a mensagem "Projeto nao encontrado". Essa simulação ajudará a equipe a entender o fluxo de requisições e respostas de uma API real, além de servir como base para futuras integrações.

Implemente um programa que leia uma string representando o nome do projeto e retorne o status associado. Os projetos e seus status são: "Apollo" - "Em andamento", "Orion" - "Concluido", "Zeus" - "Pendente", "Hermes" - "Cancelado". Para qualquer outro nome, retorne "Projeto nao encontrado". Não utilize bibliotecas externas ou estruturas avançadas; apenas condicionais simples e leitura de entrada padrão.

## Entrada

Uma única string representando o nome do projeto a ser consultado.

## Saída

Uma única string indicando o status do projeto ou a mensagem de erro, conforme especificado.

## Exemplos

A tabela abaixo apresenta exemplos de entrada e saída:

|Entrada| 	Saída|
|---|---|
|Apollo| 	Em andamento|
|Orion| 	Concluido|
|Hermes| 	Cancelado|
|Atlas| 	Projeto nao encontrado|
---
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projeto = scanner.nextLine();

        // TODO: Imprima o status correto do projeto consultado, conforme a tabela do enunciado.
        // Dica: Use condicionais para comparar o nome do projeto e definir a resposta.
    }
}
```