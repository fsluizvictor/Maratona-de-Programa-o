package Treinamento1;

import java.util.Scanner;

public class SomaCasasBuscaBinaria {
    static int[] pesquisaBinaria(int[] vetor, int k, int cont, int aux) {

        if (cont > aux && cont < vetor.length && aux < vetor.length)
            return vetor;

        // int meio = (aux + cont) / 2;

        if (vetor[cont] + vetor[aux] == k) {
            vetor[0] = vetor[cont];
            vetor[1] = vetor[aux];
            return vetor;
        }

        if (vetor[cont] + vetor[aux] < k) {
            return pesquisaBinaria(vetor, k, (aux + cont) / 2 + 1, aux);
        } else if (vetor[cont] + vetor[aux] > k) {
            return pesquisaBinaria(vetor, k, cont, (aux + cont) / 2 - 1);
        } else if (vetor[cont] + vetor[aux] == k) {

            vetor[0] = vetor[cont];
            vetor[1] = vetor[aux];

            return vetor;
        }

        return vetor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] vetor = new int[(int) n];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = in.nextInt();
        }

        int k = in.nextInt();

        vetor = pesquisaBinaria(vetor, k, 0, vetor.length - 1);

        System.out.println(vetor[0] + " " + vetor[1]);

    }
}
