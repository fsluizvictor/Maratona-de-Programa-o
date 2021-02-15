/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed2praticas;

import java.util.Scanner;

/**
 *
 * @author luiz_victor
 */
public class EquacaoSegundoGrau {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String p1 = "Equacao: ", p2 = "(x2) + ", p3 = "(x) + ";
        int v1;
        int v2;
        int v3;
        double raiz;
        double raiz2;
        double delta;

        while (leia.hasNextInt()) {

            v1 = leia.nextInt();
            v2 = leia.nextInt();
            v3 = leia.nextInt();
            delta = (v2 * v2) - (4 * v1 * v3);

            if (v1 == 0) {
                System.out.println("Nao e uma equacao de grau 2");
            } else if (delta == 0) {
                raiz = (-v2) / 2 * v1;
                System.out.println(p1 + v1 + p2 + v2 + p3 + v3);
                System.out.println("Solucao com 1 raiz real");
                System.out.println("X1: " + raiz);

            } else if (delta > 0) {
                raiz = ((-v2) + (Math.sqrt(delta))) / (2 * v1);
                raiz2 = ((-v2) - (Math.sqrt(delta))) / (2 * v1);
                System.out.println(p1 + v1 + p2 + v2 + p3 + v3);
                System.out.println("Solucao com 2 raizes reais");
                System.out.println("X1: " + raiz);
                System.out.println("X2: " + raiz2);

            } else {
                System.out.println(p1 + v1 + p2 + v2 + p3 + v3);
                System.out.println("Solucao com 0 raizes reais");
                System.out.println("X1: Nao existe raiz real");
            }

        }
    }

}
