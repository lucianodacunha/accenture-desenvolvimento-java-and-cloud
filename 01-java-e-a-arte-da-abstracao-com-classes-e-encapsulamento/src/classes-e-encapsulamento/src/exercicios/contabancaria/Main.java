package exercicios.contabancaria;

import javax.swing.*;
import java.util.Scanner;

/**
 * Escreva um código onde temos uma conta bancaria que possa realizar as
 * seguintes operações:
 * Consultar saldo
 * consultar cheque especial
 * Depositar dinheiro;
 * Sacar dinheiro;
 * Pagar um boleto.
 * Verificar se a conta está usando cheque especial.
 * Siga as seguintes regras para implementar
 * A conta bancária deve ter um limite de cheque especial somado ao saldo da
 * conta;
 * O o valor do cheque especial é definido no momento da criação da conta, de
 * acordo com o valor depositado na conta em sua criação;
 * Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque
 * especial deve ser de R$50,00
 * Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor
 * depositado;
 * Caso o limite de cheque especial seja usado, assim que possível a conta deve
 * cobrar uma taxa de 20% do valor usado do cheque especial.
 */

public class Main {
    public static void main(String[] args){
        var conta = new ContaBancaria(1, 1000.0);

        while (true){
            System.out.println(conta);
            System.out.println("""
                    Entre com a opção desejada:
                    1 - Consultar Saldo
                    2 - Consultar Cheque Especial
                    3 - Depositar
                    4 - Sacar
                    5 - Pagar Boleto
                    6 - Verificar Se Está Usando Cheque Especial
                    7 - Sair
                    """);
            System.out.print("> ");
            var opcao = new Scanner(System.in).nextInt();
            switch (opcao) {
                case 1:
                    System.out.printf("Saldo da Conta: %.2f\n",
                            conta.consultarSaldo());
                    break;
                case 2:
                    System.out.printf("Saldo da Cheque Especial: %.2f\n",
                            conta.consultaChequeEspecial());
                    break;
                case 3:
                    System.out.print("Entre com o valor do depósito: ");
                    var valorDeposito = new Scanner(System.in).nextDouble();
                    if (conta.depositar(valorDeposito)) {
                        System.out.println("Deposito realizado com sucesso");
                    }
                    break;
                case 4:
                    System.out.print("Entre com o valor do saque: ");
                    var valorSaque = new Scanner(System.in).nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso");
                    }
                    break;
                case 5:
                    System.out.print("Entre com o valor do boleto: ");
                    var valorBoleto = new Scanner(System.in).nextDouble();
                    if (conta.pagarBoleto(valorBoleto)) {
                        System.out.println("Boleto pago com sucesso");
                    }
                    break;
                case 6:
                    if (conta.estaUsandoChequeEspecial()){
                        System.out.println("Sim, está usando cheque especial");
                    } else {
                        System.out.println("Não está usando o cheque especial");
                    }
                    break;
                case 7:
                    System.out.println("Finalizando o programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}

class ContaBancaria {

    private final int numero;
    private double saldo;
    private double limiteChequeEspecial;
    private double saldoChequeEspecial;

    public ContaBancaria(int numero, double depositoInicial){
        this.numero = numero;
        this.depositar(depositoInicial);
        this.limiteChequeEspecial = this.configuraLimiteChequeEspecial(
                depositoInicial);
        this.saldoChequeEspecial = this.limiteChequeEspecial;
    }

    private double configuraLimiteChequeEspecial(double valor){
        var valorLimiteChequeEspecial = 0.0;
        if (valor <= 500.0){
            valorLimiteChequeEspecial = 50.0;
        } else {
            valorLimiteChequeEspecial = valor * 0.50;
        }
        return valorLimiteChequeEspecial;
    }

    public double consultarSaldo(){
        return this.saldo;
    }

    public double consultaChequeEspecial(){
        return this.saldoChequeEspecial;
    }

    public boolean depositar(double valor){
        if (valor < 0){
            System.out.println("Valor não permitido => " + valor);
            return false;
        }
        if (this.estaUsandoChequeEspecial()){
            var usoDoChequeEspecial =
                    (this.limiteChequeEspecial - this.saldoChequeEspecial);
            if (valor > usoDoChequeEspecial){
                valor -= usoDoChequeEspecial;
                this.saldoChequeEspecial = this.limiteChequeEspecial;
                System.out.printf(
                        "Depositando %.2f no Cheque Especial\n",
                        usoDoChequeEspecial);
            } else {
                this.saldoChequeEspecial += valor;
                System.out.printf(
                        "Depositando %.2f no Cheque Especial\n",
                        valor);
                return true;
            }
        }

        if (valor > 0) {
            System.out.printf("Depositando %.2f no Saldo Principal\n", valor);
            this.saldo += valor;
        }
        return true;
    }

    public boolean sacar(double valor){
        if (valor < 0){
            System.out.println("Valor não permitido => " + valor);
            return false;
        }
        if ((valor * 1.20) > (this.saldo + this.saldoChequeEspecial)){
            System.out.println("Saldo indisponível");
            return false;
        }
        if (valor > this.saldo) {
            if (this.saldo > 0) {
                valor -= this.saldo;
                this.saldo = 0;
            }
            this.saldoChequeEspecial -= valor + (valor * 0.2);
            return true;
        }

        System.out.printf("Sacando %.2f\n", valor);
        this.saldo -= valor;
        return true;
    }

    public boolean pagarBoleto(double valor){
        return this.sacar(valor);
    }

    public boolean estaUsandoChequeEspecial(){
        return this.saldoChequeEspecial != this.limiteChequeEspecial;
    }

    @Override
    public String toString(){
        return """
                Conta => Numero: %s, Saldo: %.2f, Limite: %.2f
                """.formatted(this.numero, this.saldo,
                                this.saldoChequeEspecial);
    }
}
