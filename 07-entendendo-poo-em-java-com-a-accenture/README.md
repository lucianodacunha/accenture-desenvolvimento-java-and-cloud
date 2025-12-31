# Entendendo POO em Java com a Accenture

## Desafio

### Extração Segura Do Nome Do Projeto Em Códigos De Cadastro

Você foi contratado como consultor de gestão em tecnologia da informação para a empresa VisionTech. Seu primeiro desafio é ajudar a equipe a organizar o cadastro de projetos internos. Cada projeto é identificado por um código no formato "Departamento-Nome", onde "Departamento" é uma palavra sem espaços e "Nome" é o nome do projeto, também sem espaços. Para garantir a padronização, a diretoria pediu um sistema orientado a objetos que extraia apenas o nome do projeto a partir do código fornecido. Sua tarefa é implementar uma solução que leia o código completo e retorne apenas o nome do projeto, ignorando o departamento. O sistema deve ser robusto para lidar com códigos que não seguem o padrão, retornando "INVALIDO" nesses casos. Não utilize bibliotecas externas.

Implemente uma classe que represente o projeto e um método que extraia o nome do projeto do código informado. O método deve validar se o código contém exatamente um hífen separando as duas partes e se ambas as partes não estão vazias. Caso contrário, retorne "INVALIDO".

## Entrada

Uma única string representando o código do projeto no formato "Departamento-Nome".

## Saída

Imprima apenas o nome do projeto, exatamente como aparece após o hífen, ou "INVALIDO" caso o código não siga o padrão especificado.

## Exemplos

A tabela abaixo apresenta exemplos de entrada e saída:

|Entrada| 	Saída|
|--|--|
|TI-CloudSync| 	CloudSync
|Financeiro-ControleGastos| 	ControleGastos
|Marketing| 	INVALIDO
|-ProjetoX| 	INVALIDO
---

```java
import java.util.Scanner;

class Projeto {
    private final String codigo;

    public Projeto(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeProjeto() {
        // TODO: Retorne o nome do projeto se o código estiver no formato correto, senão retorne "INVALIDO"
        return null; // Substitua por sua implementação
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String codigo = sc.nextLine();

        Projeto projeto = new Projeto(codigo);

        System.out.println(projeto.getNomeProjeto());
    }
}
```

---

## Desafio

### Validação De Código De Projeto Para Gestão De TI

Você foi contratado como consultor de gestão em tecnologia da informação para a empresa VisionTech. Seu primeiro desafio é ajudar a equipe a organizar o cadastro de projetos internos. Cada projeto é identificado por um código no formato "departamento-numero", como "infra-101". O gerente deseja um sistema simples, orientado a objetos, que valide se o código do projeto está correto e, caso esteja, retorne o nome do departamento em letras maiúsculas. Se o código estiver incorreto, o sistema deve retornar "INVALIDO". O código é considerado válido apenas se o nome do departamento for composto por letras minúsculas (sem números ou símbolos), seguido de um hífen e um número inteiro positivo (sem zeros à esquerda). Sua tarefa é implementar essa validação para garantir a padronização dos registros.

Implemente uma solução orientada a objetos que leia um código de projeto e verifique se ele segue o padrão especificado. Se for válido, imprima o nome do departamento em letras maiúsculas. Caso contrário, imprima "INVALIDO". Não utilize bibliotecas externas.

## Entrada

Uma única string representando o código do projeto, no formato "departamento-numero".

## Saída

Imprima o nome do departamento em letras maiúsculas se o código for válido, ou "INVALIDO" caso contrário.

## Exemplos

A tabela abaixo apresenta exemplos de entrada e saída:

|Entrada| 	Saída|
|---|---|
|infra-101| 	INFRA
|devops-007| 	INVALIDO
|Finance-12| 	INVALIDO
|dados-5| 	DADOS
---

```java
import java.util.Scanner;

class Projeto {
    private final String codigo;

    public Projeto(String codigo) {
        this.codigo = codigo;
    }

    public String validar() {
        // TODO: Verifique se o código está no formato correto e retorne o departamento em maiúsculas ou "INVALIDO"
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();

        Projeto projeto = new Projeto(codigo);
        System.out.println(projeto.validar());
    }
}
```
