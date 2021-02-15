/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed2praticas;

import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Campeonato {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int[] res = new int[6];
        for (int i = 0; i < 6; i++) {
            res[i] = leia.nextInt();
        }

        int pCormengo = res[0] * 3 + res[1];
        int pFlaminthians = res[3] * 3 + res[4];

        if (pCormengo > pFlaminthians) {
            System.out.println("C");
        } else if (pCormengo < pFlaminthians) {
            System.out.println("F");
        } else if (pCormengo == pFlaminthians) {
            if (res[2] > res[5]) {
                System.out.println("C");
            } else if (res[2] < res[5]) {
                System.out.println("F");
            } else {
                System.out.println("=");
            }
        }

    }
}
