package Treinamento1;

import java.util.Scanner;

public class VolumeDaTv {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int inicial = leia.nextInt();
        int qtd = leia.nextInt();
        for (int i = 0; i < qtd; i++) {
            int volume = leia.nextInt();
            if (volume < 0) {
                volume *= -1;
                if (volume > inicial) {
                    while (volume > inicial) {
                        volume--;
                    }
                }
                volume *= -1;
            }
            inicial += volume;
            if (inicial > 100) {
                int dif = inicial - 100;
                inicial -= dif;
            }
        }
        System.out.println("O volume da TV eh: " + inicial);
    }
}
