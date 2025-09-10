package br.com.ezbank.model;

import br.com.ezbank.Validations.ValidarCpf;

public class Conta extends Login{
    public double saldo;

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
        ValidarCpf validarCpf = new ValidarCpf();
        return  validarCpf.verificarCpf(getCpf());

    }

    @Override
    public String getInformacoes() {
        return "";
    }
}
