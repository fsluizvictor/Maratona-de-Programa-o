package aed2praticas;

import java.util.Scanner;

public class Ordenado {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int tam = 0;
        while (leia.hasNextInt()) {
            tam = leia.nextInt();
            int[] vetor = new int[tam];
            for (int x = 0; x < tam; x++) {
                vetor[x] = leia.nextInt();
            }

            int cpar = 0, cimpar = 0;//contador dos vetores que possuem números ímpares e pares
            int[] impar = new int[(tam - (tam / 2))];

            int[] par;
            if (tam % 2 != 0) {//vê se o tamanho do vetor é um número ímpar ou não
                par = new int[(tam - (tam / 2)) - 1];
            } else {
                par = new int[tam - (tam / 2)];
            }

            for (int x = 0; x < tam; x++) {
                //os impares estão nas posições pares
                if (x % 2 == 0) {
                    impar[cimpar] = vetor[x];
                    cimpar++;
                } else {
                    par[cpar] = vetor[x];
                    cpar++;
                }
            }

            int aux = 0;
            for (int x = 0; x < impar.length; x++) {
                for (int y = x + 1; y < impar.length; y++) {
                    if (impar[x] > impar[y]) {
                        aux = impar[x];
                        impar[x] = impar[y];
                        impar[y] = aux;
                    }
                }
            }

            aux = 0;
            for (int x = 0; x < par.length; x++) {
                for (int y = x + 1; y < par.length; y++) {
                    if (par[x] < par[y]) {
                        aux = par[y];
                        par[y] = par[x];
                        par[x] = aux;
                    }
                }
            }

            int[] novo = new int[tam];
            //contador dos vetores que possuem números ímpares e pares
            cpar = 0;
            cimpar = 0;
            //concatena os vetores no vetor antigo
            for (int x = 0; x < tam; x++) {
                if (x % 2 == 0) {
                    novo[x] = impar[cimpar];
                    cimpar++;
                } else {
                    novo[x] = par[cpar];
                    cpar++;
                }
            }

            System.out.print("V = {");
            for (int x = 0; x < tam; x++) {
                if (x == tam - 1) {
                    System.out.print(" " + vetor[x]);
                } else {
                    System.out.print(" " + vetor[x] + ",");
                }
            }
            System.out.print("}");

            System.out.print("\n");
            System.out.print("O = {");
            for (int x = 0; x < tam; x++) {
                if (x == tam - 1) {
                    System.out.print(" " + novo[x]);
                } else {
                    System.out.print(" " + novo[x] + ",");
                }
            }
            System.out.print("}");
        }
    }
}
