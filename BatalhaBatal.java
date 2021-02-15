package Treinamento1;

import java.util.ArrayList;
import java.util.Scanner;

public class BatalhaBatal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int Q = in.nextInt();

        int pecasSoltas = (N * N) - Q; // Peças individuais soltas no tabuleiro, o próximo passo é saber a quantida de
                                       // conjuntos

        ArrayList<Integer>[] tabuleiro = new ArrayList[N];

        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[i] = new ArrayList<>();
        }

        for (int i = 0; i < Q; i++) {
            int linha = in.nextInt();
            int coluna = in.nextInt();
            tabuleiro[linha - 1].add(coluna - 1);
        }

        int cont = 1;
        // testa incidencias de conjuntos na horizontal
        for (int j = 0; j < N; j++) {
            for (int k = 0; k <= N; k++) {
                if (tabuleiro[j].contains(k)) {
                    if (cont == k) {
                        cont = 0;
                        pecasSoltas++;
                    } else {
                        cont++;
                    }
                }
            }
        }

        // completa os espaços que não existem no tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].size(); j++) {
                if (tabuleiro[i].contains(j)) {
                    tabuleiro[i].remove(j);
                } else {
                    tabuleiro[i].add(j);
                }
            }
        }

        boolean sequencia = false;
        // testa as incidencias de conjuntos na vertical
        for (int i = 0; i < tabuleiro.length; i++) {
            cont = i + 1;
            if (cont < N) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    if (tabuleiro[i].contains(j) && tabuleiro[cont].contains(j)) {
                        while (tabuleiro[cont].contains(j)) {
                            if (cont >= N) {
                                break;
                            }
                            sequencia = true;
                            tabuleiro[cont].remove(j);
                            cont++;
                        }
                    }
                    if (sequencia) {
                        pecasSoltas++;
                    }
                    sequencia = false;
                }
            }
        }

        // testa incidencia de conjuntos na vertical
        // for (int i = 0; i < tabuleiro.length; i++) {
        // cont = i + 1;
        // if (cont < N) {
        // for (int j = 0; j < tabuleiro.length; j++) {
        // if()
        // }

        // }
        // }

        System.out.println(pecasSoltas);
    }
}
