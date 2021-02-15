package aed2praticas;

import java.util.Scanner;

public class PontesSaoPetesburgoPD {

    static int maxR = 101;
    static int maxK = 10010;
    static int[] grau = new int[maxR];
    static int[][] dp = new int[maxR][maxK];
    static int r = 0, k = 0, possivel = 0;

    private static int resolve(int regiao, int restam) {
        if (possivel == 1) {
            return 1;
        }
        if (restam < 0 || regiao > r) {
            return 0;
        }
        if (restam == 0) {
            possivel = 0;
            return dp[regiao][restam] = 1;
        }
        if (dp[regiao][restam] != -1) {
            //System.out.println(dp[regiao][restam]);
            return dp[regiao][restam];
        }
        if (dp[regiao][restam] == resolve(regiao + 1, restam) || dp[regiao][restam] == resolve(regiao + 1, restam - grau[regiao])) {
            return dp[regiao][restam];
        }
        return dp[regiao][restam];
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        while (leia.hasNextInt()) {
            r = leia.nextInt();
            k = leia.nextInt();
            possivel = 0;
            for (int i = 0; i < r; i++) {
                grau[i] = 0;
                for (int j = 0; j < k; j++) {
                    dp[i][j] = -1;
                }
            }
            for (int i = 0; i < k; i++) {
                int u = leia.nextInt();
                int v = leia.nextInt();
                grau[u]++;
                grau[v]++;
            }

            if (resolve(1, k) == 1) {
                System.out.println("S");
            } else {
                System.out.println("N");
            }
        }
    }
}
