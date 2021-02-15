package Treinamento1;

import java.util.Scanner;

public class Copa {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int times = leia.nextInt();
        int partidas = leia.nextInt();
        partidas *= 3;
        int pontuacao = 0;
        for (int i = 0; i < times; i++) {

            String nome = leia.next();
            int ponto = leia.nextInt();
            pontuacao += ponto;
        }

        int res = partidas - pontuacao;
        if (res < 0) {
            res *= -1;
        }

        System.out.println(res);

    }
}
