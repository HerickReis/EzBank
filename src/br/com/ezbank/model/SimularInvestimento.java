import java.util.Scanner;


public class SimularInvestimento {

        double valorInicial;
        int tempo;
        double valorSimulado;

        double valorFinal;

        public SimularInvestimento(double valorInicial, int tempo) {
            this.valorInicial = valorInicial;
            this.tempo = tempo * 12;
        }

    /**
     * Método principal, responsável pela execução do menu de investimento e funções auxiliares.
     * @return retorna valores simulados.
     */
    public double executar() {
        Scanner input = new Scanner(System.in);
        int op;
            do {
                System.out.println("""
                \nSeja bem vindo ao simulador de investimento da EzBank :)
                Escolha o tipo de investimento desejado abaixo:
                1- Renda Fixa
                2- Poupança
                0- Sair
                """);
                op = input.nextInt();


                switch (op) {
                    case 1:
                        valorSimulado = simularRendaFixa();
                        return valorSimulado;

                    case 2:
                       valorSimulado = simularPoupanca();
                       return valorSimulado;
                    case 3:

                }

            } while (op != 0);
        return 0.0;
    }

    /**
     * Método auxilidar, utilizado para simular investimento em renda fixa.
     * @return valor da simulação.
     */
    public double simularRendaFixa() {
        double taxaRendaFixa = 0.01;

        if (valorInicial > 0){

            System.out.println(tempo);
            double rendimento = 1 + taxaRendaFixa;
            valorFinal = valorInicial * Math.pow(rendimento, tempo);

            return valorFinal;
        }
        return 0;
    }
    /**
     * Método auxilidar, utilizado para simular investimento na poupança.
     * @return valor da simulação.
     */
    public double simularPoupanca() {
        double taxaPoupanca = 0.005;

        if (valorInicial > 0) {

            System.out.println(tempo);
            double rendimento = 1 + taxaPoupanca;
            valorFinal = valorInicial * Math.pow(rendimento, tempo);

            return valorFinal;
        }
        return 0;
    }
}
