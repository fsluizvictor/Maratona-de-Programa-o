package Treinamento1;

import java.util.Scanner;

public class SomaCasasBuscaLinear {
    static int[] percorreVetor(int[] vetor, int k, int cont, int aux) {

        if (vetor[cont] + vetor[aux] < k) {
            percorreVetor(vetor, k, cont + 1, aux);
        }

        if (vetor[cont] + vetor[aux] > k) {
            percorreVetor(vetor, k, cont, aux - 1);
        }

        if (vetor[cont] + vetor[aux] == k) {
            vetor[0] = vetor[cont];
            vetor[1] = vetor[aux];
            return vetor;
        }

        return vetor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = in.nextInt();
        }

        int k = in.nextInt();

        vetor = percorreVetor(vetor, k, 0, vetor.length - 1);

        System.out.println(vetor[0] + " " + vetor[1]);
    }
}
