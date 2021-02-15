package aed2praticas;

import java.util.ArrayList;
import java.util.Scanner;

public class TabHash {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int casoTeste = leia.nextInt();
        int cont = 0;
        while (cont < casoTeste) {
            int endBase = leia.nextInt();
            int qtdChave = leia.nextInt();
            int[] chaves = new int[qtdChave];
            for (int i = 0; i < qtdChave; i++) {
                chaves[i] = leia.nextInt();
            }
            ArrayList[] enderecos = new ArrayList[endBase];
            for (int j = 0; j < endBase; j++) {
                enderecos[j] = new ArrayList();
            }

            //for para fazer o calculo do endereco de alocacao dos elementos
            for (int x = 0; x < qtdChave; x++) {
                int novoLocal = chaves[x] % endBase;
                enderecos[novoLocal].add(chaves[x]);
            }

            for (int x = 0; x < endBase; x++) {
                System.out.print(x);
                System.out.print(" -> ");
                if (enderecos[x].isEmpty()) {
                    System.out.print(" \\ ");
                } else {
                    for (Object endereco : enderecos[x]) {
                        System.out.print(endereco);
                        System.out.print(" -> ");
                    }
                    System.out.print(" \\ ");
                }
                System.out.println();
            }
            cont++;
            System.out.println("\n");
        }
    }

}
