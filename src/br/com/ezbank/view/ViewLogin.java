package br.com.ezbank.view;

import br.com.ezbank.model.Login;

import java.util.Scanner;

public class ViewLogin extends Login {
    static Scanner sc = new Scanner(System.in);

    public ViewLogin() {
        super();
    }

//    public ViewLogin(String usuario, String senha,  String cpf) {
//        super(usuario, senha, cpf);
//    }

    @Override
    public String getInformacoes() {
        return "Nome: " + getLoginUsuario() +
                "\tData de criação: " + getDataCriacao() + "\n";
    }

    private static void exibirMenuLogin(){
        System.out.println("\nEscolha uma opção abaixo: ");
        System.out.println("1 - Abrir conta Bancária. ");
        System.out.println("2 - Autenticar.");
        System.out.println("3 - Ver Informações da conta.");
        System.out.println("0 - Sair.");
    }

    protected void cadastro(){

        System.out.println("Digite seu nome Completo: ");
        String nome = sc.nextLine().trim();
        setLoginUsuario(nome);

        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine().trim();
        setLoginSenha(senha);

        String cpf;

        do {
            System.out.println("Digite seu CPF: ");
            cpf = sc.nextLine().trim();

            if (getStatusCpf(cpf)){
                setCpf(cpf);
                break;
            }
            System.out.println("\nCpf inválido, tente novamente.");

        } while (!getStatusCpf(cpf));

        setDataCriacao();
    }

    public boolean executarViewLogin() {
        ViewLogin viewLogin = new ViewLogin();
        int op;

        do {

            exibirMenuLogin();
            String LinhaOp = sc.nextLine();
            op = Integer.parseInt(LinhaOp);

            switch (op) {
                case 1:
                    viewLogin.cadastro();
                    break;

                case 2:
                    System.out.println("\nDigite seu nome de cadastro:");
                    String nome = sc.nextLine();

                    System.out.println("Digite sua senha:");
                    String senha = sc.nextLine();

                    if (viewLogin.autenticar(nome, senha)) {
                        System.out.println("\nAutenticação bem sucedida.");
                        return true;
                    } else {
                        return false;
                    }

                case 3:
                    System.out.println(viewLogin.getInformacoes());
                    break;
            }

        } while (op != 0);
    return  false;
    }
}
