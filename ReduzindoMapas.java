package aed2praticas;

import java.io.*;
import java.util.Scanner;

public class ReduzindoMapas {

    static int n;

    private static class Kruskal {

        Scanner leia = new Scanner(System.in);
        public int[][] G;
        public int[][] t;
        public boolean[][] in;
        public boolean[][] temp;
        int mincost;

        public int k, l, num_ed = 0;

        public Kruskal(int n) throws IOException {
            this.G = new int[n + 1][n + 1];
            this.in = new boolean[n + 1][n + 1];
            this.t = new int[n + 1][3];
            this.mincost = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    in[i][j] = in[j][i] = false;
                    if ((i != j) && (i < j)) {
                        G[j][i] = G[i][j] = 0;
                        if (G[i][j] == 0) {
                            G[j][i] = G[i][j] = 7001;
                        }
                    }
                    if (i == j) {
                        G[i][j] = 7001;
                    }
                }
            }
        }

        private void fazAresta(int vertice1, int vertice2, int peso) {
            G[vertice1][vertice2] = peso;
            G[vertice2][vertice1] = peso;
        }

        public void Kruskals() {
            for (int i = 1; i <= n; i++) {
                getMinKL();
                if (k == l) {
                    break;
                }
                if (formscycle(i - 1)) {
                    i--;
                    continue;
                } else {
                    System.out.println();
                }

                mincost = mincost + G[k][l];
                num_ed = (isPresent(i, k)) ? num_ed : num_ed + 1;
                num_ed = (isPresent(i, l)) ? num_ed : num_ed + 1;

                t[i][1] = l;
                t[i][2] = k;
                if (num_ed >= n) {
                    if (allconnect(i)) {
                        return;
                    }
                }
            }
        }

        public boolean allconnect(int i) {
            for (int c = 2; c <= n; c++) {
                temp = new boolean[n + 1][n + 1];
                for (int a = 1; a <= n; a++) {
                    for (int b = 1; b <= n; b++) {
                        temp[a][b] = temp[b][a] = false;
                    }
                }

                if (can_reach(1, c, i) == false) {
                    return false;
                }
            }
            return true;
        }

        public boolean formscycle(int i) {
            if (isPresent(i, k) && isPresent(i, l)) {
                temp = new boolean[n + 1][n + 1];
                for (int a = 1; a <= n; a++) {
                    for (int b = 1; b <= n; b++) {
                        temp[a][b] = temp[b][a] = false;
                    }
                }

                if (can_reach(k, l, i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean can_reach(int k, int l, int i) {
            temp[k][l] = temp[l][k] = true;
            for (int o = 1; o <= i; o++) {
                if (((k == t[o][1]) && (l == t[o][2])) || ((l == t[o][1]) && (k == t[o][2]))) {
                    return true;
                }
                if ((k == t[o][1]) && !(temp[t[o][2]][l])) {
                    if (can_reach(t[o][2], l, i) == true) {
                        return true;
                    }
                } else if ((k == t[o][2]) && !(temp[t[o][1]][l])) {
                    if (can_reach(t[o][1], l, i) == true) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isPresent(int i, int val) {
            for (int o = 1; o <= i; o++) {
                if ((val == t[o][1]) || ((val == t[o][2]))) {
                    return true;
                }
            }
            return false;
        }

        public void getMinKL() {
            int k1 = 1, l1 = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((i != j) && (i < j)) {
                        if ((G[i][j] < G[k1][l1]) && G[i][j] != 0 && in[j][i] == false) {
                            k1 = i;
                            l1 = j;
                        }
                    }
                }
            }
            if (G[k1][l1] != 0) {
                k = k1;
                l = l1;
                in[k][l] = in[l][k] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner leia = new Scanner(System.in);

        n = leia.nextInt();

        Kruskal kr = new Kruskal(n);

        int m = leia.nextInt();

        for (int i = 0; i < m; i++) {
            kr.fazAresta(leia.nextInt(), leia.nextInt(), leia.nextInt());
        }

        kr.Kruskals();
        System.out.println(kr.mincost);
    }
}
