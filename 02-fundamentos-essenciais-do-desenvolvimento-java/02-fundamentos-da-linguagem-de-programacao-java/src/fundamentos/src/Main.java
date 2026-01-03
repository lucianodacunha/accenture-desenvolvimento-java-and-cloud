import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // declarando variáveis
        var scanner = new Scanner(System.in);
        System.out.println("Olá, informe o seu nome: ");
        var nome = "Luciano"; // scanner.nextLine();
        System.out.println("Informe sua idade: ");;
        var idade = 40; // scanner.nextInt();
        System.out.printf("Olá %s, sua idade é %s.\n", nome, idade);
        System.out.println();

        // tipos de dados
        var inteiro = 10;
        var longo = 1l;
        var flutuante = 10.2f;
        var caracter = 'A';
        var booleano = true;

        System.out.println();
        System.out.println("Tipos declarados:");
        System.out.printf("intero: %s\n", inteiro);

        // operadores de atribuição
        int x = 0;
        x += 5;
        x -= 4;
        x *= 3;
        x /= 2;

        System.out.println();
        System.out.println("Operadores de atribuição:");
        System.out.println("Valor de x: " + x);

        System.out.println();
        System.out.println("Operadores lógicos: ");
        var a = true;
        var b = false;
        System.out.println("a && b = " + (a && b));
        System.out.println("a || b = " + (a || b));
        System.out.println("a != b = " + (a != b));
        System.out.println("!a == !b = " + (!a && !b));

        System.out.println();
        System.out.println("Operadore Aritméticos");
        var n1 = 10;
        var n2 = 3;
        System.out.printf("n1: %s \nn2: %s\n", n1, n2);
        System.out.println("n1 + n2: " + (n1 + n2));
        System.out.println("n1 - n2: " + (n1 - n2));
        System.out.println("n1 * n2: " + (n1 * n2));
        System.out.println("n1 / n2: " + (n1 / n2));
        System.out.println("n1 % n2: " + (n1 % n2));
    }
}