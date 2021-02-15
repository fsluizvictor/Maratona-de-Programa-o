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
public class QuadradoMagico {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int n = leia.nextInt();
        int[][] mat = new int[n][n];
        int[] res = new int[2 + n + n];
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                mat[i][j] = leia.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[cont] += mat[i][j];
            }
            cont++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[cont] += mat[j][i];
            }
            cont++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    res[cont] += mat[i][j];
                }
            }
        }
        cont++;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == mat.length - 1) {
                    res[cont] += mat[i][j];
                }
            }
        }
        cont++;

        int soma = 0;
        for (int i = 0; i < res.length; i++) {
            soma += res[i];
        }

        int teste = 0;
        for (int i = 0; i < res.length; i++) {
            if (soma / res.length == res[i]) {
                teste++;
            }
        }
        if (teste == res.length) {
            System.out.println(res[0]);
        } else {
            System.out.println("-1");
        }
    }
}

//3
//100 1000 100
//100 100 100
//1000 100 1000
