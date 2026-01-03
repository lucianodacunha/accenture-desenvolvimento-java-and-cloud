package exercicios.carro;

import java.util.Scanner;

/**
 * Escreva um código onde controlamos as funções de um carro, ele deve ter as
 * seguintes funções:
 * Ligar o carro;
 * Desligar o carro;
 * Acelerar;
 * diminuir velocidade;
 * virar para esquerda/direita
 * verificar velocidade;
 * trocar a marcha
 *
 * Siga as seguintes regras na implementação
 *
 * Quando o carro for criado ele deve começar desligado, em ponto morto e com
 * sua velocidade em 0
 * O carro desligado não pode realizar nenhuma função;
 * Quando o carro for acelerado ele deve incrementar 1km em sua velocidade
 * (pode chegar no máximo a 120km);
 * Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua
 * velocidade (pode chegar no minimo a 0km);
 * o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no
 * carro;
 * A velocidade do carro deve respeitar os seguintes limites para cada
 * velocidade
 * se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
 * se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
 * se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
 * se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
 * se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
 * se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
 * se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
 * O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua
 * velocidade em 0 km
 * O carro só pode virar para esquerda/direita se sua velocidade for de no
 * mínimo 1km e no máximo 40km;
 *
 */
public class Main {
    public static void main(String... args){
        var carro = new Carro();
        while (true){
            System.out.println(carro);
            System.out.println("""
                    Entre com a opção desejada: 
                    1 - Ligar 
                    2 - Desligar
                    3 - Acelerar
                    4 - Desacelerar
                    5 - Virar para a esquerda
                    6 - Virar para a direita
                    7 - Verificar a velocidade
                    8 - Aumentar marcha
                    9 - Reduzir marcha
                    10 - Sair
                    """);
            System.out.print("> ");
            var option = new Scanner(System.in).nextInt();
            switch (option){
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.desacelerar();
                    break;
                case 5:
                    carro.virarAEsquerda();
                    break;
                case 6:
                    carro.virarADireita();
                    break;
                case 7:
                    carro.verificarAVelocidade();
                    break;
                case 8, 9:
                    if (option == 8){
                        carro.trocarAMarcha(TipoMarcha.AUMENTAR);
                    }
                    if (option == 9){
                        carro.trocarAMarcha(TipoMarcha.REDUZIR);
                    }
                    break;
                case 10:
                    System.out.println("Finalizando o programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}

enum TipoMarcha {
    AUMENTAR, REDUZIR;
}

class Carro {

    private String estado;
    private int marcha;
    private int velocidade;

    public Carro(){
        this.estado = "desligado";
        this.marcha = 0;
        this.velocidade = 0;
    }

    public void ligar(){
        if (estado.equals("desligado")){
            System.out.println("...ligando o carro");
            this.estado = "ligado";
        } else {
            System.out.println("Carro ligado");
        }

    }

    public void desligar(){
        if (estado.equals("desligado")){
            System.out.println("Carro desligado...");
            return;
        }
        if (estado.equals("ligado") && this.marcha == 0 && this.velocidade == 0){
            System.out.println("... Desligando carro");
            return;
        }
    }

    public void acelerar(){
        if (estado.equals("desligado")){
            System.out.println("Carro desligado...");
            return;
        }
        if (this.velocidade < 120){
            var acelerando = false;
            if (this.marcha == 1 && this.velocidade < 20){
                this.velocidade++;
                acelerando = true;
            }
            if (this.marcha == 2 && this.velocidade < 40){
                this.velocidade++;
                acelerando = true;
            }
            if (this.marcha == 3 && this.velocidade < 60){
                this.velocidade++;
                acelerando = true;
            }
            if (this.marcha == 4 && this.velocidade < 80){
                this.velocidade++;
                acelerando = true;
            }
            if (this.marcha == 5 && this.velocidade < 100){
                this.velocidade++;
                acelerando = true;
            }
            if (this.marcha == 6 && this.velocidade >= 100){
                this.velocidade++;
                acelerando = true;
            }
            if (!acelerando){
                System.out.println("Marcha incompativel com a velocidade");
            } else {
                System.out.println("Acelerando...");
            }
        } else {
            System.out.println("Velocidade máxima atingida");
        }
    }

    public void desacelerar(){
        if (estado.equals("desligado")){
            System.out.println("Carro desligado...");
            return;
        }
        if (this.velocidade > 0){
            this.velocidade--;
        }
    }

    public void virarAEsquerda(){
        if (estado.equals("desligado")){
            System.out.println("Carro desligado...");
            return;
        }
        if (this.velocidade >= 1 && this.velocidade <= 40){
            System.out.println("...Virando a esquerda");
        }
    }

    public void virarADireita(){
        if (estado.equals("desligado")){
            System.out.println("Carro desligado...");
            return;
        }
        if (this.velocidade >= 1 && this.velocidade <= 40){
            System.out.println("...Virando a direita");
        }
    }

    public void trocarAMarcha(TipoMarcha tipo){
        if (estado.equals("desligado")){
            System.out.println("Carro desligado...");
        }
        if (tipo.equals(TipoMarcha.REDUZIR)){
            System.out.println("Reduzindo a marcha...");
            if (this.marcha > 0) this.marcha--;
        }
        if (tipo.equals(TipoMarcha.AUMENTAR)){
            System.out.println("Aumentando a marcha...");
            if (this.marcha < 6) this.marcha++;
        }
    }

    @Override
    public String toString(){
        return """
                Estado %s, Velocidade: %s, Marcha: %s
                """.formatted(this.estado, this.velocidade, this.marcha);
    }

    public void verificarAVelocidade() {
        if (this.estado.equals("ligado")){
            System.out.printf("Velocidade %s\n", this.velocidade);
        } else {
            System.out.println("Carro desligado");
        }
    }
}