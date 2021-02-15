package Treinamento1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyHour {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int qtd = leia.nextInt();

        String[][] horarios = new String[qtd][6];
        for (int i = 0; i < qtd; i++) {
            for (int j = 0; j < 6; j++) {
                horarios[i][j] = leia.next();
            }
        }

        ArrayList<Character> dia = new ArrayList<>();
        int cont = 0;
        int aparicoes = 0;
        String base = "ABCDEFGHIJKL";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < qtd; j++) {

                String aux = horarios[j][i];

                for (int k = 0; k < aux.length(); k++) {
                    char caracter = aux.charAt(k);
                    dia.add(caracter);
                }
            }

            while (cont < 12) {
                for (int j = 0; j < dia.size(); j++) {
                    if (dia.get(j) == base.charAt(cont)) {
                        aparicoes++;
                    }
                }
                if (aparicoes == qtd) {
                    System.out.print(base.charAt(cont));
                }
                cont++;
                aparicoes = 0;
            }
            System.out.print(" ");
            cont = 0;
            dia = new ArrayList<>();
        }

    }
}
