import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        var empregadoA = new Empregado();
        empregadoA.nome =  "Luciano";
        empregadoA.idade = 25;
        System.out.println(empregadoA);

        var pessoa1 = new Pessoa("Luciano", 20);
        System.out.println(pessoa1);
        var pessoa2 = new Pessoa("Luciano", 21);
        System.out.println(pessoa2);
        var pessoa3 = new Pessoa("Luciano", 20);
        System.out.println(pessoa3);

        // comparando objetos
        System.out.println("pessoa1 == pessoa2: " + pessoa1.equals(pessoa2));
        System.out.println("pessoa1 == pessoa3: " + pessoa1.equals(pessoa3));

        // trabalhando com records.
        var carro1 = new Carro("Honda", 2024);
        System.out.println(carro1);
        // var carro2 = new Carro("Honda", 1990);
        /**
         * Exception in thread "main" java.lang.IllegalArgumentException: Ano inválido
         * 	at Carro.<init>(Main.java:110)
         * 	at Main.main(Main.java:24)
         */
    }
}

/**
 * Exemplo de classe em Java, sem encapsulamento
 */
class Empregado {
    String nome;
    int idade;

    @Override
    public String toString(){
        return """
                Empregado:
                Nome: %s
                Idade: %s
                """.formatted(this.nome, this.idade);
    }
}

/**
 * Exemplo de classe utilizando encapsulamento
 */
class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        setIdade(idade);
    }

    public void setIdade(int idade){
        /** Exemplo de validação ao setar uma variável de instância. **/
        if (idade < 0) {
            System.out.println("Valor de idade inválido"); return;
        }
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public String getNome(){
        return this.nome;
    }

    public void fazAniversario(){
        this.idade++;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return """
                Pessoa:
                Nome: %s, Idade: %s""".formatted(this.nome, this.idade);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}


/**
 * Exemplo de record. Tipo utilizadao para dados imutáveis.
 * @param modelo
 * @param ano
 */
record Carro(String modelo, int ano){
    public Carro {
        if (ano < 2000){
            throw new IllegalArgumentException("Ano inválido");
        }
    }
}