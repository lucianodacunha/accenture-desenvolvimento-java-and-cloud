package exercicios.petshop;

import java.util.Scanner;

/**
 * Escreva um código onde temos o controle de banho de um petshop, a maquina de
 * banhos dos pets deve ter as seguintes operações:
 * Dar banho no pet;
 * Abastecer com água;
 * Abastecer com shampoo;
 * verificar nivel de água;
 * verificar nivel de shampoo;
 * verificar se tem pet no banho;
 * colocar pet na maquina;
 * retirar pet da máquina;
 * limpar maquina.
 *
 * Siga as seguintes regras para implementação
 *
 * A maquina de banho deve permitir somente 1 pet por vez;
 * Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
 * A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
 * Se o pet for retirado da maquina sem estar limpo será necessário limpar a
 * máquina para permitir a entrada de outro pet;
 * A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
 * O abastecimento de água e shampoo deve permitir 2 litros por vez que for
 * acionado;
 *
 */
public class Main {
    public static void main(String... args){
        var mbp = new MaquinaDeBanhoDePets();
        while (true){
            System.out.println(mbp);
            System.out.println("""
                    Entre com a opção desejada:
                    1 - Dar Banho
                    2 - Abastecer com água
                    3 - Abastecer com shampoo
                    4 - Verificar nível da água
                    5 - Verificar nível do shampoo
                    6 - Verificar se tem pet na máquina
                    7 - Colocar pet na máquina
                    8 - Retirar pet da máquina
                    9 - Limpar a máquina
                    10 - Sair
                    """);
            System.out.print("> ");
            var option = new Scanner(System.in).nextInt();
            switch (option){
                case 1:
                    mbp.darBanhoNoPet();
                    break;
                case 2:
                    mbp.abastecerComAgua(2);
                    break;
                case 3:
                    mbp.abastecerComShampoo(2);
                    break;
                case 4:
                    System.out.printf("Nível da água: %s\n",
                            mbp.verificarNivelDeAgua());
                    break;
                case 5:
                    System.out.printf("Nível do shampoo: %s\n",
                            mbp.verificarNivelDeShampoo());
                    break;
                case 6:
                    System.out.printf("Tem pet na máquina: %s\n",
                            mbp.verificarSeTemPetNoBanho());
                    break;
                case 7:
                    mbp.colocarPetNaMaquina();
                    break;
                case 8:
                    mbp.retirarPetDaMaquina();
                    break;
                case 9:
                    mbp.limparMaquina();
                    break;
                case 10:
                    System.out.println("Finalizando o programa");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}


class MaquinaDeBanhoDePets{
    private int quantidadeDeAgua;
    private int quantidadeDeShampoo;
    private boolean pet;

    public void darBanhoNoPet(){
        if (!verificarSeTemPetNoBanho()){
            System.out.println("Colocar pet na máquina");
            return;
        }
        if (verificarNivelDeAgua() < 10 || verificarNivelDeShampoo() < 2) {
            System.out.println("Abastecer máquina");
            return;
        }
        System.out.println("iniciando banho de pet...");
        this.quantidadeDeAgua -= 10;
        this.quantidadeDeShampoo -= 2;
    }

    public void abastecerComAgua(int quantidade){
        var CAPACIDADE = 30;
        if (verificarNivelDeAgua() == CAPACIDADE){
            System.out.println("Capacidade máxima atingida");
            return;
        }
        if ((verificarNivelDeAgua() + quantidade) > CAPACIDADE){
            this.quantidadeDeAgua = CAPACIDADE;
            System.out.println("Máquina abastecida com capacidade completa");
            return;
        }
        if ((verificarNivelDeAgua() + quantidade) < CAPACIDADE){
            this.quantidadeDeAgua += quantidade;
            System.out.println("Máquina abastecida");
        }
    }

    public void abastecerComShampoo(int quantidade){
        var CAPACIDADE = 10;
        if (verificarNivelDeShampoo() == CAPACIDADE){
            System.out.println("Capacidade máxima atingida");
            return;
        }
        if ((verificarNivelDeShampoo() + quantidade) > CAPACIDADE){
            this.quantidadeDeShampoo = CAPACIDADE;
            System.out.println("Máquina abastecida com capacidade completa");
            return;
        }
        if ((verificarNivelDeShampoo() + quantidade) < CAPACIDADE){
            this.quantidadeDeShampoo += quantidade;
            System.out.println("Máquina abastecida");
        }
    }

    public int verificarNivelDeAgua(){
        return this.quantidadeDeAgua;
    }

    public int verificarNivelDeShampoo(){
        return this.quantidadeDeShampoo;
    }

    public boolean verificarSeTemPetNoBanho(){
        return this.pet;
    }

    public void colocarPetNaMaquina(){
        if (verificarSeTemPetNoBanho()){
            System.out.println("Já existe um pet na máquina");
            return;
        }
        System.out.println("Pet adicionado na máquina");
        this.pet = true;
    }

    public void retirarPetDaMaquina(){
        if (!verificarSeTemPetNoBanho()){
            System.out.println("A máquina já está vazia");
            return;
        }
        System.out.println("Pet retirado na máquina");
        this.pet = false;
    }

    public void limparMaquina(){
        if (verificarNivelDeAgua() < 3 || verificarNivelDeShampoo() < 1) {
            System.out.println("Abastecer máquina");
            return;
        }
        this.quantidadeDeAgua -= 3;
        this.quantidadeDeShampoo -= 1;
        System.out.println("iniciando limpeza da máquina");
    }

    @Override
    public String toString(){
        return """
                Qtde. Agua: %d, Qtde. Shampoo: %d
                """.formatted(
                        verificarNivelDeAgua(),
                        verificarNivelDeShampoo());
    }

}