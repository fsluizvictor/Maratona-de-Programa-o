import java.util.ArrayList;
import java.util.Scanner;

public class NatalinoRecursivo {

    // static class Pacote {
    // int peso, brinquedos;
    // }

    static ArrayList memoria_brinquedos[];
    static int aux;

    static int[] mochila(int peso_maximo, int pesos[], int brinquedos[], int qtd) {
        int vet[] = new int[2];
        if (peso_maximo == 0 || qtd == 0) {
            System.out.println("[TESTE 1]" + peso_maximo);
            aux = 50 - peso_maximo;
            vet[1] = aux;
            return vet;
        }

        if (pesos[qtd - 1] > peso_maximo) {
            System.out.println("[TESTE 2]" + peso_maximo);
            vet = mochila(peso_maximo, pesos, brinquedos, qtd - 1);

            return vet;

        } else {
            System.out.println("[TESTE 3]" + peso_maximo);
            int vet_1[] = mochila(peso_maximo - pesos[qtd - 1], pesos, brinquedos, qtd - 1);
            int vet_2[] = mochila(peso_maximo, pesos, brinquedos, qtd - 1);
            int max = Math.max(brinquedos[qtd - 1] + vet_1[0], vet_2[0]);

            // if (brinquedos[qtd - 1] + vet_1[0] > vet_2[0]) {
            // vet[1] += peso_maximo - pesos[qtd - 1];
            // } else {
            // vet[1] += pesos[qtd - 1];

            // }

            vet[0] = max;
            vet[1] = aux;
            // vet[1] = peso_maximo;
            return vet;
        }

    }

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        int viagens = leia.nextInt();
        int cont = 0;

        while (cont < viagens) {

            int pac = leia.nextInt();

            int brinquedos[] = new int[pac];
            int pesos[] = new int[pac];

            for (int i = 0; i < pac; i++) {
                brinquedos[i] = leia.nextInt();
                pesos[i] = leia.nextInt();
            }
            int resultado[] = mochila(50, pesos, brinquedos, pac);

            System.out.println(resultado[0] + " : brinquedos\n" + resultado[1] + " : pesos");

            cont++;
        }

    }
}
