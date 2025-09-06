package br.com.ezbank.view;


public class EzBank {
    public static void main(String[] args) {
        ViewLogin viewLogin = new ViewLogin();
        ViewConta viewConta = new ViewConta();

        while (true) {
            if (!viewLogin.executarViewLogin()) {
                System.out.println("\nErro ao autenticar.");
            } else viewConta.executarView();
        }


    }
}
