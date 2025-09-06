import java.util.Scanner;

public class Login {
    String loginUsuario;
    private String loginSenha;

    Verifications verification = new Verifications();

    /**
     * Construtor da classe Login. Atribui um valor padrão caso o nome de usuário seja null.
     */
    public Login(){
        if (!verification.verificarUsuario(this.loginUsuario)){
            this.loginUsuario = "[ Nenhum usuário cadastrado :( ]";
        }
    }

    /**
     * Método de cadastro, utlizado para cadastrar um usuário ao sistema de autenticação da EzBank.
     * @return verdadeiro caso o cadastro seja um sucesso.
     */
    public boolean cadastrar(){
        Scanner entrada = new Scanner(System.in);
        Verifications verificar = new Verifications();

        boolean sucesso = false;

        do {
            System.out.println("\nUsuario: ".trim());
            loginUsuario = entrada.nextLine();

            System.out.println("\nCPF: ".trim());
            String  cpfUsuario = entrada.nextLine();
            boolean validarCpf = verificar.verificarCpf(cpfUsuario);

            if (!validarCpf) {
                System.out.println("\nCPF invalido");
                continue;
            }

            System.out.println("\nSenha: ".trim());
            loginSenha = entrada.nextLine();

            System.out.println("Confirme sua senha: ");
            String confirmaSenha = entrada.nextLine();

            if (!loginSenha.equals(confirmaSenha)) {
                System.out.println("\nSenha invalida");
                continue;
            }
            sucesso = true;
        } while (!sucesso);

        return sucesso;
    }

    /**
     * Método de autenticação, utilizado para relizar o login de um usuário já cadastrado.
     * @param usuario Nome de usuário a ser cadastrado
     * @param senha senha do usuário.
     * @return Verdadeiro caso a autenticação seja bem sucedida.
     */
    public boolean autenticar(String usuario, String senha) {
        return usuario.equals(loginUsuario) && senha.equals(loginSenha);
    }

}
