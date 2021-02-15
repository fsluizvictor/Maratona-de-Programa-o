package aed2praticas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Delacao {

    private static class No {

        //Set<Integer> teste = new HashSet<>();
        int valor;
        No noEsquerda, noDireita, pai;
        int maisAlto;
        //boolean delatado;

        public No(int valor) {
            this.valor = valor;
            //this.delatado = false;
        }

        public No getNoEsquerda() {
            return noEsquerda;
        }

        public No getNoDireita() {
            return noDireita;
        }

        public int getValor() {
            return valor;
        }

        public void setDelatado(boolean delatado) {
            //this.delatado = delatado;
        }

    }

    //inicializa a raiz com o número 1
    private static No raiz = new No(1);
    //contador de nós da árvore
    private static int cont = 0;

    private static void inserir(int valor) {
        inserir(raiz, valor);
    }

    //NÃO CONSIDERAMOS DUPLAS CHAVES, OU SEJA, CHAVES REPETIDAS NÃO SÃO CONSIDERADAS NESSE CASO
    private static void inserir(No node, int valor) {
        if (valor != node.getValor()) {
            if (valor < node.valor) {
                if (node.noEsquerda != null) {
                    inserir(node.noEsquerda, valor);
                } else {
                    //System.out.println("Inserindo " + valor + " a esquerda de " + node.valor);
                    node.noEsquerda = new No(valor);
                    node.noEsquerda.pai = node;
                }

            } else {
                if (node.noDireita != null) {
                    inserir(node.noDireita, valor);
                } else {
                    //System.out.println("Inserindo " + valor + " a direita de " + node.valor);
                    node.noDireita = new No(valor);
                    node.noDireita.pai = node;
                }
            }
        }
    }

    private static void red(No no) {
        if (no != null) {
            cont++;
            red(no.getNoEsquerda());
            red(no.getNoDireita());
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = leia.nextInt();
        int adv = leia.nextInt();
        qtd--;
        int[] vet = new int[qtd];
        for (int i = 0; i < qtd; i++) {
            vet[i] = leia.nextInt();
        }
        for (int i = qtd - 1; i >= 0; i--) {
            inserir(vet[i]);
        }
        red(raiz);
        int presos = adv + cont;
        System.out.println(presos);
    }
}
