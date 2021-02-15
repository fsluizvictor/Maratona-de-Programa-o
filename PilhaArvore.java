package aed2praticas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PilhaArvore {

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

    private static int altura(No r) {
        if (r == null)//altura de árvore
        {
            return -1;
        } else {
            int he = altura(r.getNoEsquerda());
            int hd = altura(r.getNoDireita());
            if (he < hd) {
                return hd + 1;
            } else {
                return he + 1;
            }
        }
    }

    private static void iterativeInorder() {
        No p = raiz;
        Stack travStack = new Stack();
        while (p != null) {
            while (p != null) {
                if (p.getNoDireita() != null) {
                    travStack.push(p.getNoDireita());
                }
                travStack.push(p);
                p = p.getNoEsquerda();
            }
            p = (No) travStack.pop();
            while (!travStack.isEmpty() && p.getNoDireita() == null) {
                System.out.print(p.getValor() + " ");
                p = (No) travStack.pop();
            }
            System.out.print(p.getValor() + " ");
            if (!travStack.isEmpty()) {
                p = (No) travStack.pop();
            } else {
                p = null;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList();
        Scanner leia = new Scanner(System.in);
        boolean rep = false;
        int valor = 0;
        while (leia.hasNextInt()) {
            valor = leia.nextInt();
            //garante que não teremos valores repetidos
            //faz uma varredura na lista e 
            if (!lista.isEmpty()) {
                for (int n : lista) {
                    if (valor == n) {
                        rep = true;
                    }
                }
            }
            if (!rep) {
                lista.add(valor);
            }
            rep = false;
        }

        for (int n : lista) {
            // System.out.println(n);
            inserir(n);
        }
        //imprimirFolhas(raiz);
        iterativeInorder();
        System.out.println("\n");
        System.out.println(altura(raiz) + 1);
    }
}
