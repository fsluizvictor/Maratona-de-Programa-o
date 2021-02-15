package aed2praticas;

import java.util.Scanner;

public class AeroportoA {

    static int teste = 1;

    private static class Aeroporto {

        int id;
        int frequencia;

        public Aeroporto(int id) {
            this.id = id;
            this.frequencia = 1;
        }

        public void incrementaFrequencia() {
            this.frequencia++;
        }

        public int getFrequencia() {
            return frequencia;
        }

        public int getId() {
            return id;
        }

    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = -1;
        int qtdVoos = -1;

        do {
            qtd = leia.nextInt();
            qtdVoos = leia.nextInt();
            Aeroporto[] aeroportos = new Aeroporto[qtd];
            int cont = 1;
            for (int i = 0; i < qtd; i++) {
                aeroportos[i] = new Aeroporto(cont);
                cont++;
            }

            int maiorTrafego = Integer.MIN_VALUE;

            for (int i = 0; i < 2 * qtdVoos; i++) {
                int voo = leia.nextInt();

                aeroportos[voo - 1].incrementaFrequencia();

                if (maiorTrafego < aeroportos[voo - 1].getFrequencia()) {
                    maiorTrafego = aeroportos[voo - 1].getFrequencia();
                }

            }

            if (maiorTrafego > 0) {
                System.out.println("Teste " + teste);
            }

            for (int i = 0; i < qtd; i++) {
                if (aeroportos[i].getFrequencia() == maiorTrafego) {
                    System.out.print(aeroportos[i].getId() + " ");
                }
            }
            System.out.println("\n");

            teste++;

        } while (qtd != 0 && qtdVoos != 0);
    }
}
