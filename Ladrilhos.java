package aed2praticas;

import java.util.Scanner;

public class Ladrilhos {

    private static int tamanhoSequencia(int[][] parede, int i, int j, int h, int l, int cor) {
        if (i < 0 || i >= h) {
            return 0;
        }

        if (j < 0 || j >= l) {
            return 0;
        }

        if (parede[i][j] == cor) {
            parede[i][j] = -1;
            //recursão feita para testar aonde a cor se repete na matriz 
            return 1
                    + tamanhoSequencia(parede, i + 1, j, h, l, cor)
                    + tamanhoSequencia(parede, i - 1, j, h, l, cor)
                    + tamanhoSequencia(parede, i, j + 1, h, l, cor)
                    + tamanhoSequencia(parede, i, j - 1, h, l, cor);
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int h = leia.nextInt();
        int l = leia.nextInt();
        int[][] parede = new int[h][l];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                parede[i][j] = leia.nextInt();
            }
        }

        int sequencia = 0;
        int menorSequencia = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (parede[i][j] != -1) {
                    sequencia = tamanhoSequencia(parede, i, j, h, l, parede[i][j]);

                    if (menorSequencia == -1 || sequencia < menorSequencia) {
                        menorSequencia = sequencia;
                    }

                    if (menorSequencia == 1) {
                        break;
                    }
                }
            }
        }
        System.out.println(menorSequencia);

    }
}
