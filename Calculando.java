package Treinamento1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calculando
 */
public class Calculando {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int operandos = leia.nextInt();
        ArrayList<String> numeros = new ArrayList();
        ArrayList<Character> sinais = new ArrayList();
        int cont = 1;
        while (operandos != 0) {
            String expressao = leia.next();
            String str = new String();
            for (int i = 0; i < expressao.length(); i++) {
                if (expressao.charAt(i) != '+' && expressao.charAt(i) != '-') {
                    str += expressao.charAt(i);
                } else {
                    sinais.add(expressao.charAt(i));
                    numeros.add(str);
                    str = new String();
                }
            }

            if (!str.isEmpty() && str != "+" && str != "-") {
                numeros.add(str);
            }

            int soma = 0;
            for (int j = 0; j < sinais.size(); j++) {
                if (sinais.get(j).equals('-')) {
                    int aux = Integer.parseInt(numeros.get(j + 1));
                    numeros.set(j + 1, "0");
                    aux *= -1;
                    soma += aux;
                }
            }

            for (String s : numeros) {
                int aux = Integer.parseInt(s);
                soma += aux;
            }

            System.out.println("Teste " + cont);
            System.out.println(soma);

            numeros = new ArrayList();
            sinais = new ArrayList();
            cont++;
            operandos = leia.nextInt();
        }
    }

}