package br.com.ezbank.view;

import br.com.ezbank.model.Conta;
import br.com.ezbank.Services.ConversaoDeMoedas;
import br.com.ezbank.Services.SimularInvestimento;
import br.com.ezbank.model.TransacoesBancarias;

import java.util.Scanner;

public class ViewConta extends Conta {

    public ViewConta() {
        super();
    }

    public void executarMenu(){
        System.out.println("""
                \n
                Escolha uma opção abaixo:
                1 - Realizar Depósito
                2 - Consultar Saldo
                3 - Realizar Saque
                4 - Consultar Saques.
                5 - Comprar moedas estrangeiras.
                6 - Simular investimento.
                0 - Sair""");
    }

    public void executarView() {
        double saque;
        int op;

        TransacoesBancarias transacoesBancarias = new TransacoesBancarias();
        ViewConta viewConta = new ViewConta();
        Scanner sc = new Scanner(System.in);

            do {
                viewConta.executarMenu();

                op = sc.nextInt();
                switch (op) {

                    case 1:
                        System.out.println("\nValor a ser depositado: ");
                        double deposito = sc.nextDouble();
                        transacoesBancarias.realizarDeposito(deposito);
                        break;

                    case 2:
                        System.out.println("\nVocê tem um saldo disponível de R$: " + transacoesBancarias.getSaldo());
                        break;

                    case 3:
                        System.out.println("\nValor do saque R$: ");
                        saque = sc.nextDouble();
                        transacoesBancarias.realizarSaque(saque);
                        break;

                    case 4:
                        System.out.println("\nVocê realizou um total de " +
                                           transacoesBancarias.getSaques() + " saques"
                                           +
                                " contabilizando um valor total de R$: " + transacoesBancarias.getTotalSaques());
                        break;

                    case 5:
                        ConversaoDeMoedas converter = new ConversaoDeMoedas(transacoesBancarias.getSaldo());
                        int opcao = converter.menu();
                        double valorCompra = converter.realizarConversao(opcao);

                        transacoesBancarias.realizarSaque(valorCompra);
                        break;

                    case 6:
                        System.out.println("Valor do aporte inicial: ");
                        double valorInicial = sc.nextDouble();

                        System.out.println("Tempo de rendimento (em anos): ");
                        int tempo = sc.nextInt();


                        SimularInvestimento simularInvestimento = new SimularInvestimento(valorInicial, tempo);

                        double valorDoRendimento = simularInvestimento.executar();

                        double rendimentoBruto = valorDoRendimento - valorInicial;

                        System.out.printf("O valor incial de R$ %.2f rendendo por %d anos irá render aproximandamente " +
                                "R$: %.3f e terá o valor final de: R$ %.2f ", valorInicial, tempo, rendimentoBruto, valorDoRendimento);

                        break;
                }

            } while (op != 0);
    }
}
