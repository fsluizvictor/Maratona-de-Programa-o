package Treinamento1;

import java.util.Arrays;
import java.util.Scanner;

public class BatalhaBatalMatriz {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int tam = leia.nextInt();
        int qtd = leia.nextInt();

        int pecasSoltas = (tam * tam) - qtd;

        boolean[][] tabuleiro = new boolean[tam][tam];
        tam--;
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = false;
            }
        }

        for (int i = 0; i < qtd; i++) {
            int l = leia.nextInt();
            int c = leia.nextInt();
            tabuleiro[l - 1][c - 1] = true;
        }

        int sequencia = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tabuleiro[i][j] && sequencia >= 1) {
                    sequencia = 0;
                    pecasSoltas++;
                } else {
                    sequencia++;
                }
            }
        }

        sequencia = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tabuleiro[j][i] && sequencia >= 1) {
                    sequencia = 0;
                    pecasSoltas++;
                } else {
                    sequencia++;
                }
            }
        }

        System.out.println(pecasSoltas);
    }
}
