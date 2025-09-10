package br.com.ezbank.Services;

import java.util.HashMap;
import java.util.Scanner;

public class ConversaoDeMoedas{
    private double saldoBancario;

    Scanner input = new Scanner(System.in);

    public  ConversaoDeMoedas(double saldoBancario) {
        this.saldoBancario = saldoBancario;
    }

    /**
     * Método dedicado a armazenar e retornar os simbolos monetários de suas respectivas moedas, utilizando HashMap
     * @param moeda - Nome da moeda.
     * @return {@code String} - Simbolo monetário
     */
    public String simbolosMonetarios(String moeda){
        HashMap<String, String> simbolosMonetarios = new HashMap<>();

        // Simbolos monetários para formatação.
        simbolosMonetarios.put("DOLAR", "US$");
        simbolosMonetarios.put("EURO", "€");
        simbolosMonetarios.put("LIBRA", "£");
        simbolosMonetarios.put("IENE", "¥");

        return simbolosMonetarios.get(moeda);
    }

    /**
     * Método dedicado a armazenar e retornar os valores  respectivas moedas em relação ao "R$" real, utilizando HashMap
     * @param moeda - Nome da moeda.
     * @return {@code double} - Valor monetário
     */
    public double valorMoeda(String moeda){
        HashMap<String, Double> valorMoeda = new HashMap<>();

        // Valores de moeda para simulação. *por hora fixos
        valorMoeda.put("DOLAR", 5.42);
        valorMoeda.put("EURO", 6.35);
        valorMoeda.put("LIBRA", 7.27);
        valorMoeda.put("IENE", 0.037);


        return valorMoeda.get(moeda);
    }

    /**
     * Método dedicado a exibição do menu de escolha.
     * @return {@code int} - Valor inteiro da opção selecionada
     */
    public int menu(){
        int op;


        System.out.println("""
                \nEscolha uma moeda para comprar:
                1 - Dolar
                2 - Euro
                3 - Libra
                4 - Iene
                0 - Sair
                """);

        System.out.println("\nEscolha a moeda que quer comprar: ");
        op = input.nextInt();

        return op;
    }


    /**
     * Método dedicado ao cálculo do valor de compra da moeda
     * @param valorMoeda - Valor da moeda a ser comprada.
     * @param montante - Quantidade de moeda a ser comprada.
     * @return {@code double} Valor da compra em frente ao Real.
     */
    public double calcularValorMoeda(double valorMoeda, double montante){
        return  valorMoeda * montante;
    }

    /**
     * Método dedicado a realização de conversão e compra das moedas
     *
     * @param opcao - Valor inteiro da escolha do usuario.
     */
    public double realizarConversao(int opcao){
        double montante;
        boolean confirmar;

        String moeda = "";

        moeda = switch (opcao) {
            case 1 -> "DOLAR";
            case 2 -> "EURO";
            case 3 -> "LIBRA";
            case 4 -> "IENE";
            default -> moeda;
        };

        System.out.println("Digite o valor que deseja comprar: ");
        montante = input.nextDouble();

        System.out.println("\nDeseja comprar " + simbolosMonetarios(moeda) + montante
                + " Isso vai custar R$: "
                + calcularValorMoeda(valorMoeda(moeda), montante) + " Confirma (true/false)? ");

        confirmar = input.nextBoolean();

        if (confirmar) {
            if (valorMoeda(moeda) < this.saldoBancario) {
                double valorTotal = calcularValorMoeda(valorMoeda(moeda), montante);
                System.out.println("\nVocê comprou " + " $: " + montante +
                        " Isso custou R$ " + calcularValorMoeda(valorMoeda(moeda), montante));
                return valorTotal;
            } else {
                System.out.println("Valor insuficiente.");
                return 0;}
        }
        else {
            System.out.println("Operação cancelada");
            return 0;
        }

    }
}


