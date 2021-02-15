package aed2praticas;

import java.util.Scanner;

public class PontesS {

    private static class Graph {

        private int vertices[][];

        public Graph(int numVertices) {
            vertices = new int[numVertices][numVertices];
        }

        public void makeEdge(int vertex1, int vertex2) {
            vertices[vertex1 - 1][vertex2 - 1]++;
            vertices[vertex2 - 1][vertex1 - 1]++;
        }

        public void removeEdge(int vertex1, int vertex2) {
            vertices[vertex1 - 1][vertex2 - 1] = 0;
            vertices[vertex2 - 1][vertex1 - 1] = 0;
        }

        public int getCost(int vertex1, int vertex2) {
            return vertices[vertex1 - 1][vertex2 - 1];
        }

        public int[] qtdPontes() {
            int[] nPontes = new int[vertices.length];

            for (int i = 0; i < vertices.length; i++) {
                for (int j = 0; j < vertices.length; j++) {
                    nPontes[i] += vertices[i][j];
                }
                System.out.println(i + " " + nPontes[i]);
            }
            return nPontes;
        }

        public static void main(String[] args) {
            Scanner leia = new Scanner(System.in);
            int qtd = -1;
            int nPontes = -1;

            do {
                qtd = leia.nextInt();
                nPontes = leia.nextInt();
                Graph g = new Graph(qtd);
                for (int i = 0; i < nPontes; i++) {
                    g.makeEdge(leia.nextInt(), leia.nextInt());
                }

                int cont = 0;
                for (int i = 0; i < g.vertices.length; i++) {
                    if (g.qtdPontes()[i] == nPontes) {
                        cont++;
                    }
                }

                if (cont == qtd) {
                    System.out.println("S");
                } else {
                    System.out.println("N");
                }

            } while (leia.hasNextInt());
        }

    }

}
