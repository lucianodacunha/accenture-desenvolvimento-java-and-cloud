import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // if, else if e else
        var random = new Random();
        var idade = random.nextInt(50);

        if (idade >= 18){
            System.out.printf("Vc tem %s anos, é Maior de idade\n", idade);
        } else {
            System.out.printf("Vc tem %s anos, é Menor de idade\n", idade);
        }

        // com múltiplas condições
        var nota = random.nextInt(11);

        if (nota >= 9) {
            System.out.printf("Nota %s - Excelente\n", nota);
        } else if (nota >= 7) {
            System.out.printf("Nota %s - Satisfatório\n", nota);
        } else {
            System.out.printf("Nota %s - Insuficiente\n", nota);
        }

        // estrutura condicional switch case
        var dia = random.nextInt(8);
        switch (dia){
            case 1:
                System.out.printf("Dia %s, Domingo\n", dia); break;
            case 2:
                System.out.printf("Dia %s, Segunda\n", dia); break;
            case 3:
                System.out.printf("Dia %s, Terça\n", dia); break;
            case 4:
                System.out.printf("Dia %s, Quarta\n", dia); break;
            case 5:
                System.out.printf("Dia %s, Quinta\n", dia); break;
            case 6:
                System.out.printf("Dia %s, Sexta\n", dia); break;
            default:
                System.out.printf("Dia %s, Sábado\n", dia);
        }

        var valor = random.nextInt(12) + 1;
        switch (valor) {
            case 1 -> System.out.println("Mês " + valor + ", Janeiro");
            case 2 -> System.out.println("Mês " + valor + ", Fevereiro");
            case 3 -> System.out.println("Mês " + valor + ", Março");
            case 4 -> System.out.println("Mês " + valor + ", Abril");
            case 5 -> System.out.println("Mês " + valor + ", Maio");
            case 6 -> System.out.println("Mês " + valor + ", Junho");
            case 7 -> System.out.println("Mês " + valor + ", Julho");
            case 8 -> System.out.println("Mês " + valor + ", Agosto");
            case 9 -> System.out.println("Mês " + valor + ", Setembro");
            case 10 -> System.out.println("Mês " + valor + ", Outubro");
            case 11 -> System.out.println("Mês " + valor + ", Novembro");
            default -> System.out.println("Mês " + valor + ", Dezembro");
        }

        var mes = random.nextInt(12) + 1;
        var estacao = switch (valor) {
            case 1, 2, 3 -> "Mês " + mes + ", Verão";
            case 4, 5, 6 -> "Mês " + mes + ", Outono";
            case 7, 8, 9 -> "Mês " + mes + ", Inverno";
            case 10, 11, 12 -> "Mês " + mes + ", Primarera";
            default -> "Mês " + mes + ", Mês inexistente";
        };
        var mensagem = String.format("%s", estacao);
        System.out.println(mensagem);

        // repetição com for
        var limite = random.nextInt(10);

        System.out.printf("Imprimindo sequências com for, limite %d\n", limite);
        for (var i = 0; i <= limite; i++)
            System.out.printf("%d ", i);

        // repetição com while e do while
        System.out.println();
        var contador = 0;
        var maximo = random.nextInt(20);
        System.out.println("Imprimindo com loop - while, máximo: " + maximo);
        while (contador <= maximo) {
            System.out.printf("%s ", contador);
            contador++;
        }

        System.out.println();
        contador = 0;
        maximo = random.nextInt(20);
        System.out.println("Imprimindo com loop - do-while, máximo: " + maximo);
        do {
            System.out.printf("%s ", contador);
            contador++;
        } while (contador <= maximo);
    }

}