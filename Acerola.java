package Treinamento1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Acerola {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = -1;
        int f = -1;

        while (n != 0 && f != 0) {
            n = in.nextInt();
            f = in.nextInt();

            double qtd = (f * 0.05) / n;

            System.out.printf("%.2f", qtd);
        }

    }
}
