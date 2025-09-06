public class TransacoesBancarias {
    double saldoBancario;

    public TransacoesBancarias() {}

    /**
     * Método criado para realizar o depósito do saldo do usuário.
     * @param valorDeposito valor a ser depositado.
     * @return o saldo após o depósito ser bem sucedido.
     * @return Retorna 0 caso haja algum erro no valor inserido.
     */
    public double relizarDeposito(double valorDeposito){
        if (valorDeposito > 0){
            this.saldoBancario += valorDeposito;
            return saldoBancario + valorDeposito;
        }
        return 0;
    }

    /**
     * Método de saque do dinheiro já depositado.
     * @param valorSaque é o valor a ser sacado pelo usuário.
     * @return o saldo bancário após o saque ser bem sucedido.
     */
    public double realizarSaque(double valorSaque){
        if (valorSaque > 0) {
            this.saldoBancario -= valorSaque;
            return saldoBancario;

        }
        return 0;
    }

    /**
     * Método de retorno do saldo atual do usuário.
     * @return o valor total em conta.
     */
    public double getSaldoBancario() {
        return saldoBancario;
    }
}
