package aed2praticas;

import java.util.Scanner;

public class CachorroQuente {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        while (leia.hasNextInt()) {
            double cachorro = leia.nextDouble();
            double pessoas = leia.nextDouble();
            double med = cachorro / pessoas;
            System.out.printf("%.2f", med);
        }
    }
}
