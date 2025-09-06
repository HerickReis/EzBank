package br.com.ezbank.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Login {
    private String loginUsuario;
    private String loginSenha;
    private String cpf;
    private String dataAtual;

    protected Login(){
    }

    protected Login(String loginUsuario, String loginSenha, String cpf) {
        this.loginUsuario = loginUsuario;
        this.loginSenha = loginSenha;
        this.cpf = cpf;
    }

    protected String getLoginUsuario() {
        return loginUsuario;
    }

    protected void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    protected String getLoginSenha() {
        return loginSenha;
    }

    protected void setLoginSenha(String loginSenha) {
        this.loginSenha = loginSenha;
    }

    protected String getCpf() {
        return cpf;
    }

   protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected boolean getStatusCpf(String cpf){
        Verifications verifications = new Verifications();
        return verifications.verificarCpf(cpf);
    }

    public String getDataCriacao() {
        return dataAtual;
    }

    public void setDataCriacao() {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        this.dataAtual = dataHoraAtual.format(formato);
    }

    /**
     * Método de autenticação, utilizado para relizar o login de um usuário já cadastrado.
     * @param usuario Nome de usuário a ser cadastrado
     * @param senha senha do usuário.
     * @return {@code true} caso a autenticação seja bem sucedida.
     */
   public  boolean autenticar(String usuario, String senha) {
        return usuario.equals(getLoginUsuario()) && senha.equals(getLoginSenha());
    }

    public abstract String getInformacoes();

}
