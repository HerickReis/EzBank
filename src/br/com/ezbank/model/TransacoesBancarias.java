package br.com.ezbank.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransacoesBancarias extends Conta{

    private int saques;
    protected List<Double> totalSaques = new ArrayList<>();

    public TransacoesBancarias() {
        super();
    }

    /**
     * Método criado para realizar o depósito do saldo do usuário.
     * @param valorDeposito valor a ser depositado.
     * @return o saldo após o depósito ser bem sucedido.
     */
    public void realizarDeposito(double valorDeposito){
        if (valorDeposito > 0){
            setSaldo(valorDeposito + getSaldo());
        }
    }

    /**
     * Método de saque do dinheiro já depositado.
     * @param valorSaque é o valor a ser sacado pelo usuário.
     */
    public void realizarSaque(double valorSaque){
        if (valorSaque > 0 && valorSaque <= getSaldo()) {

            double valorAtualizado = getSaldo() - valorSaque;
            setSaldo(valorAtualizado);
            setSaques();

            totalSaques.add(valorSaque);
        } else System.out.println("Valor inválido");
    }

    /**
     * Itera sob uma array que contém informações sobre o valor de todos os saques realizados e os contabilizam.
     * @return {@code double} Soma de todos os saques realizados
     */
    protected double contabilizarSaques(){
        if (saques > 0){
            double saquesTotais = 0;

            for (int i = 0; i < totalSaques.size(); i++) {
                saquesTotais += totalSaques.get(i);
            }

            return saquesTotais;

        }
        return 0;
    }

    public double getSaques() {
        return saques;
    }

    public void setSaques() {
        this.saques += 1;
    }

    /**
     * Obtém o valor total dos saques, vindo da função contabilizarSaques
     * @return {@code double} valor total sacado
     */
    public double getTotalSaques() {
        return contabilizarSaques();
    }
}
