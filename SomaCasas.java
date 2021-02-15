package Treinamento1;

import java.util.Scanner;

public class SomaCasas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = in.nextInt();
        }

        int k = in.nextInt();

        int n1 = 0, n2 = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] + vetor[j] == k) {
                    n1 = vetor[i];
                    n2 = vetor[j];
                    break;
                }
            }
        }

        System.out.println(n1 + " " + n2);
    }
}
