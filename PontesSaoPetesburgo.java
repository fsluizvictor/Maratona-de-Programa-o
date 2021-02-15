package aed2praticas;

import java.util.Scanner;
import java.util.Stack;

public class PontesSaoPetesburgo {

    //aresta - origem e destino
    //aresta possui região
    private static class Regiao {

        int id;
        int frequencia;

        public Regiao(int id) {
            this.id = id;
            this.frequencia = 0;
        }

        public void incrementaFrequencia() {
            this.frequencia++;
        }

        public int getFrequencia() {
            return frequencia;
        }

        public int getId() {
            return id;
        }

    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = -1;
        int nPontes = -1;
        Stack pilha = new Stack();

        do {
            qtd = leia.nextInt();
            nPontes = leia.nextInt();

            Regiao[] regioes = new Regiao[qtd];
            for (int i = 1; i <= qtd; i++) {
                regioes[i - 1] = new Regiao(i);
            }

            for (int i = 0; i < 2 * nPontes; i++) {
                //para evitar duplicação de pontes onde no caso teste as regioẽs passadas sejam iguais
                // como por exemplo 1 1 - a ponte não poderá ser contada 2 vezes
                int pos = leia.nextInt();
                if (i % 2 == 0) {
                    pilha.push(pos);
                    regioes[pos - 1].incrementaFrequencia();
                }
                if (i % 2 != 0 && (int) pilha.pop() != pos) {
                    regioes[pos - 1].incrementaFrequencia();
                }
            }

            int contPar = 0, contImpar = 0;
            for (int i = 0; i < qtd; i++) {
                if (regioes[i].getFrequencia() % 2 == 0) {
                    contPar++;
                } else {
                    contImpar++;
                }
            }
            int cont = 0;
            for (int i = 0; i < qtd; i++) {
                if (regioes[i].getFrequencia() == nPontes) {
                    cont++;
                }
            }

            if ((cont == qtd && nPontes % 2 == 0) || (contImpar == 2 && cont == qtd) || (cont == qtd && contPar == qtd)) {
                System.out.println("S");
            } else {
                System.out.println("N");
            }

        } while (leia.hasNextInt());
    }

}
