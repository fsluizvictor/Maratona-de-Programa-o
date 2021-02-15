package aed2praticas;

import java.util.Scanner;

public class alarme {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        int h1 = 1, m1 = 1, h2 = 1, m2 = 1;
        int hor1 = 0, hor2 = 0;

        do {

            h1 = leia.nextInt();
            m1 = leia.nextInt();
            h2 = leia.nextInt();
            m2 = leia.nextInt();

            if (h1 == 0 && h2 == 0 && m1 == 0 && m2 == 0) {
                break;
            } else {

                h1 = h1 * 60;
                hor1 = 24 * 60 - (h1 + m1);

                h2 = h2 * 60;
                hor2 = h2 + m2;

                int res = 0;

                if (hor1 + hor2 < 1440) {
                    res = hor1 + hor2;
                    System.out.println(res);
                } else {
                    hor1 = h1 + m1;
                    res = hor1 - hor2;
                    if (res < 0) {
                        res *= -1;
                    }
                    System.out.println(res);
                }
            }
        } while (leia.hasNextInt());
    }
}
