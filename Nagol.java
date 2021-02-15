package aed2praticas;

import java.util.Scanner;

public class Nagol {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int linha = leia.nextInt();
        int coluna = leia.nextInt();
        int posicaosLinha = leia.nextInt();
        int posicaoColuna = leia.nextInt();
        int cont = 0;
        int contFinal = 0;
        for (int x = 0; x < linha; x++) {
            for (int y = 0; y < coluna; y++) {
                cont++;
                if (x == posicaosLinha && y == posicaoColuna) {
                    contFinal = cont;
                }
            }
        }
        if (contFinal % 2 == 0) {
            System.out.println("Esquerda");
        } else {
            System.out.println("Direita");
        }
    }

}
