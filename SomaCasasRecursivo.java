package Treinamento1;

import java.util.Scanner;

public class SomaCasasRecursivo {

    static long[] percorreVetor(long[] vetor, long k, long cont, long aux) {

        if (cont == vetor.length - 1) {
            return vetor;
        }

        if (vetor[(int) cont] + vetor[(int) aux] == k) {
            vetor[0] = vetor[(int) cont];
            vetor[1] = vetor[(int) aux];
            return vetor;
        }

        if (aux == vetor.length - 1) {
            aux = 0;
            cont++;
        }

        aux++;
        return percorreVetor(vetor, k, cont, aux);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        long[] vetor = new long[(int) n];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = in.nextInt();
        }

        long k = in.nextLong();

        vetor = percorreVetor(vetor, k, 0, 1);

        System.out.println(vetor[0] + " " + vetor[1]);
    }
}
