package br.com.ezbank.model;

public class Verifications {

    //Controladores do CPF
    private String originalCpf;
    private String subCpf;

    /**
     * Função criada para validar cpf do usuário, utilizando lógica simples de cálculo dos dígitos verificadores, que consistem numa
     * equação dos 9 digitos anteriores a ele.
     * @param cpf numero do cadastro de pessoa física (cpf) do usuário
     * @return {@code true}  caso o cpf seja válido.
     */
    public boolean verificarCpf(String cpf) {

        int primeiroDigito;
        int segundoDigito;

        if (cpf.length() != 11) {
           return false;
        }

        this.originalCpf = cpf;
        this.subCpf = cpf.substring(0, 9);

        //primeiro digito
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * (10 - i);
        }

        int resto = soma % 11;
        primeiroDigito = (resto < 2) ? 0 : 11 - resto;

        //Segundo dígito
        soma = 0;
        for (int i = 0; i < 10; i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * (11 - i);
        }

        resto = soma % 11;
        segundoDigito = (resto < 2) ? 0 : 11 - resto;

        int digitoReal1 = Character.getNumericValue(cpf.charAt(9));
        int digitoReal2 = Character.getNumericValue(cpf.charAt(10));

        return (primeiroDigito == digitoReal1 && segundoDigito == digitoReal2);

        }

    /**
     * Método de verificação do nome do usuário, utilizado para validar login
     * @param usuario irá receber o valor de usuário na classe de login
     * @return {@code true} caso o nome não esteja vazio
     */
    public boolean verificarUsuario(String usuario) {
            return usuario != null && usuario.trim().isEmpty();
        }
    }
