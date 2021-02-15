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
public class ParesBotas {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int qtd = leia.nextInt();
        int dif = -1;

        String[] lado = new String[qtd];
        int[] tam = new int[qtd];
        for (int x = 0; x < qtd; x++) {
            tam[x] = leia.nextInt();
            lado[x] = leia.next();
        }
        int cont = 0;
        for (int x = 0; x < qtd; x++) {
            for (int y = x + 1; y < qtd; y++) {
                if (tam[x] == tam[y] && !lado[x].equalsIgnoreCase(lado[y])) {
                    cont += 1;
                    tam[y] = dif;
                    dif--;
                    lado[y] = String.valueOf(dif);
                    dif--;
                    break;
                }
            }
        }
        System.out.println(cont);
        cont = 0;

    }
}
