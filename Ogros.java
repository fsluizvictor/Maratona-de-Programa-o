import java.util.Scanner;

public class Ogros {

    static int[] buscaMaiorIgual(int vet[], int x) {
        int res[] = new int[3];
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] >= x) {
                res[0] = vet[i];
                res[1] = i;
                res[2] = x;
                break;
            }
        }
        if (res[0] == 0) {
            res[0] = vet[vet.length - 1];
            res[1] = vet.length - 1;
            res[2] = x;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int n = leia.nextInt();
        int m = leia.nextInt();
        int faixa[] = new int[n - 1];
        int premiacoes[] = new int[n];
        int ogros[] = new int[m];
        int resultado[] = new int[m];

        for (int i = 0; i < faixa.length; i++) {
            faixa[i] = leia.nextInt();
        }

        for (int i = 0; i < premiacoes.length; i++) {
            premiacoes[i] = leia.nextInt();
        }

        for (int i = 0; i < ogros.length; i++) {
            ogros[i] = leia.nextInt();
        }

        for (int i = 0; i < ogros.length; i++) {
            int res[] = buscaMaiorIgual(faixa, ogros[i]);
            if (res[2] < faixa[0]) {
                resultado[i] = premiacoes[0];
            } else {
                for (int j = 0; j < faixa.length - 1; j++) {
                    if (res[2] == faixa[j]) {
                        resultado[i] = premiacoes[res[1] + 1];
                    }
                }
            }

            if (resultado[i] == 0) {
                if (res[2] >= faixa[faixa.length - 1]) {
                    resultado[i] = premiacoes[premiacoes.length - 1];
                } else {
                    resultado[i] = premiacoes[res[1]];
                }
            }
        }

        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }

    }
}