package Treinamento1;

import java.util.Scanner;

/**
 * Esquerda
 */
public class Esquerda {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] sentidoHorario = { 'N', 'L', 'S', 'O' };
        char[] sentidoAntiHorario = { 'N', 'O', 'S', 'L' };
        int cont = 0;

        int qtd = in.nextInt();

        while (qtd != 0) {
            String comandos = in.next();
            cont = 0;
            if (comandos.charAt(0) == 'D') {
                for (int i = 0; i < comandos.length(); i++) {
                    if (comandos.charAt(i) == 'D') {
                        cont++;
                    } else {
                        cont--;
                    }
                    if (cont > 3 || cont < -3) {
                        cont = 0;
                    }
                }

                if (cont < 0) {
                    cont *= -1;
                }

                System.out.println(sentidoHorario[cont]);
            } else {
                cont = 0;
                for (int i = 0; i < comandos.length(); i++) {
                    if (comandos.charAt(i) == 'E') {
                        cont++;
                    } else {
                        cont--;
                    }
                    if (cont > 3 || cont < -3) {
                        cont = 0;
                    }
                }

                if (cont < 0) {
                    cont *= -1;
                }

                System.out.println(sentidoAntiHorario[cont]);
            }
            qtd = in.nextInt();
        }
    }
}