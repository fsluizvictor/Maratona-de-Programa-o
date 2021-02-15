package aed2praticas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ArvoreBinaria {

    private static class No {

        int valor;
        No noEsquerda, noDireita;
        int maisAlto;

        public No(int valor) {
            this.valor = valor;
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

    }

    private static No raiz;

    private static void inserir(int valor) {
        inserir(raiz, valor);
    }

    private static void inserir(No node, int valor) {
        if (node == null) {
            //System.out.println("Raiz " + valor);
            raiz = new No(valor);
        } else {
            if (valor < node.valor) {
                if (node.noEsquerda != null) {
                    inserir(node.noEsquerda, valor);
                } else {
                    //System.out.println("Inserindo " + valor + " a esquerda de " + node.valor);
                    node.noEsquerda = new No(valor);
                }

            } else {
                if (node.noDireita != null) {
                    inserir(node.noDireita, valor);
                } else {
                    //System.out.println("Inserindo " + valor + " a direita de " + node.valor);
                    node.noDireita = new No(valor);
                }
            }
        }
    }

    
    private static void erd(No no) {
        if (no != null) {
            erd(no.noEsquerda);
            System.out.print(no.valor + " ");
            erd(no.noDireita);
        }
    }

    private static void red(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            red(no.getNoEsquerda());
            red(no.getNoDireita());
        }
    }

    private static void edr(No no) {
        if (no != null) {
            edr(no.getNoEsquerda());
            edr(no.getNoDireita());
            System.out.print(no.getValor() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int quant = leia.nextInt();
        int cont = 1;
        while (cont <= quant) {
            int tam = leia.nextInt();
            for (int i = 0; i < tam; i++) {
                inserir(leia.nextInt());
            }
            System.out.println("\n");
            System.out.print("Case ");
            System.out.print(cont);
            System.out.print(":");
            System.out.println("\n");
            System.out.print("Pre.: ");
            red(raiz);
            System.out.println("\n");
            System.out.print("In..: ");
            erd(raiz);
            System.out.println("\n");
            System.out.print("Post: ");
            edr(raiz);
            raiz = null;
            cont++;
        }
    }
}
