package br.com.ezbank.model;

public class Conta extends Login{
    public double saldo;
    private double totalInvestido;
    private double moedasEstrangeiras;

    public Conta() {
        super();
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getLogin() {
        return getLoginUsuario();
    }

    public boolean getStatusCpf() {
        Verifications v = new Verifications();
        return  v.verificarCpf(getCpf());

    }

    @Override
    public String getInformacoes() {
        return "";
    }
}
