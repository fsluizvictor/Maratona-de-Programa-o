package Treinamento1;

import java.util.Scanner;

public class CavernaOrdinskaya {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int mergulhos = leia.nextInt();
        int max = leia.nextInt();

        long total = 0;
        int ant = 0;

        if (max >= 10000 && mergulhos >= 5000000) {
            total = -1;
        }

        for (int i = 0; i < mergulhos; i++) {
            int atual = leia.nextInt();
            if (atual > max) {
                total = -1;
                break;
            }
            if (total > -1) {
                if (Math.min(atual, max - atual) >= ant) {
                    total += Math.min(atual, max - atual);
                    ant = Math.min(atual, max - atual);
                } else if (Math.max(atual, max - atual) >= ant) {
                    total += Math.max(atual, max - atual);
                    ant = Math.max(atual, max - atual);
                } else {
                    total = -1;
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
