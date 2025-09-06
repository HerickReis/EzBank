import java.util.Scanner;

public class ConversaoDeMoedas {
    double saldoBancario;

    public  ConversaoDeMoedas(double saldoBancario) {
        this.saldoBancario = saldoBancario;
    }

    /**
     * Método de compra e conversão de moedas a base de escolha do usuário.
     */
    public void converterMoedas() {
        Scanner input = new Scanner(System.in);
        int op;
        double montante;
        boolean confirmar;

        double valorDeCompra;
        double saldoBancario;

        double valorDolar = 5.41;
        double valorEuro = 6.31;
        double valorLibra = 7.32;
        double valorYene = 0.037;

        do {
            System.out.println("""
                    
                    1- Dolar
                    2- Euro
                    3- Libra
                    4- Yene
                    0- Sair""");
            System.out.println("\nEscolha a moeda que quer comprar: ");
            op = input.nextInt();

            switch (op) {
                case 1:

                    System.out.println("Digite o valor que deseja comprar: ");
                    montante = input.nextDouble();

                    valorDeCompra = valorDolar * montante;

                    System.out.println("\nDeseja comprar " + " $: " + montante + " Isso vai custar " + " R$: " + valorDeCompra + " Confirma (true/false)? ");
                    confirmar = input.nextBoolean();

                    if (!confirmar) {
                        System.out.println("Operação cancelada");
                        break;
                    }

                    if (valorDeCompra < this.saldoBancario) {
                        this.saldoBancario -= valorDeCompra;
                        System.out.println("\nVocê comprou " + " $: " + montante + " Isso vai custar " + " R$: " + valorDeCompra + " Confirma (true/false)? ");
                        break;
                    } else {
                        System.out.println("Valor insuficiente.");
                        break;
                    }

                case 2:
                    System.out.println("Digite o valor que deseja comprar: ");
                    montante = input.nextDouble();

                    valorDeCompra = valorEuro * montante;

                    System.out.println("\nDeseja comprar " + "€: " + montante + " Isso vai custar " + " R$: " + valorDeCompra + " Confirma (true/false)? ");
                    confirmar = input.nextBoolean();

                    if (!confirmar) {
                        System.out.println("Operação cancelada");
                        break;
                    } else System.out.println("Valor insuficiente.");

                    if (valorDeCompra < this.saldoBancario) {
                        this.saldoBancario -= valorDeCompra;
                        System.out.println("\nVocê comprou " + " €: " + montante + " e custou" + " R$: " + valorDeCompra);
                        break;
                    } else {
                        System.out.println("Valor insuficiente.");
                        break;
                    }

                case 3:
                    System.out.println("Digite o valor que deseja comprar: ");
                    montante = input.nextDouble();

                    valorDeCompra = valorLibra * montante;

                    System.out.println("\nDeseja comprar " + " £: " + montante + " Isso vai custar " + " R$: " + valorDeCompra + " Confirma (true/false)? ");
                    confirmar = input.nextBoolean();

                    if (!confirmar) {
                        System.out.println("Operação cancelada");
                        break;
                    } else System.out.println("Valor insuficiente.");

                    if (valorDeCompra < this.saldoBancario) {
                        this.saldoBancario -= valorDeCompra;
                        System.out.println("\nVocê comprou " + "£: " + montante + " e custou" + " R$: " + valorDeCompra);
                        break;
                    } else {
                        System.out.println("Valor insuficiente.");
                        break;
                    }

                case 4:
                    System.out.println("Digite o valor que deseja comprar: ");
                    montante = input.nextDouble();

                    valorDeCompra = valorYene * montante;

                    System.out.println("\nDeseja comprar " + " ¥: " + montante + " Isso vai custar " + " R$: " + valorDeCompra + " Confirma (true/false)? ");
                    confirmar = input.nextBoolean();

                    if (!confirmar) {
                        System.out.println("Operação cancelada");
                        break;
                    }

                    if (valorDeCompra < this.saldoBancario) {
                        this.saldoBancario -= valorDeCompra;
                        System.out.println("\nVocê comprou " + " ¥: " + montante + " e custou" + "R$: " + valorDeCompra);
                        break;
                    } else {
                        System.out.println("Valor insuficiente.");
                        break;
                    }
            }

        } while (op != 0);
    }
}
