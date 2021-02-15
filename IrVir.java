package aed2praticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IrVir {

    private static class Esquina {

        int id, peso;
        boolean visitado;

        public Esquina(int id) {
            this.id = id;
            this.peso = Integer.MAX_VALUE;
            this.visitado = false;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }

    }

    private static class Graph {

        private int vertices[][];

        public Graph(int numVertices) {
            this.vertices = new int[numVertices][numVertices];
        }

        public void makeEdge(int vertex1, int vertex2, int time) {
            if (time == 2) {
                vertices[vertex1 - 1][vertex2 - 1] = time;
                vertices[vertex2 - 1][vertex1 - 1] = time;
            } else {
                vertices[vertex1 - 1][vertex2 - 1] = time;
            }
        }

        public int getCost(int vertex1, int vertex2) {
            return vertices[vertex1 - 1][vertex2 - 1];
        }

        public ArrayList<Integer> getNeighbors(int vertex) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int i = 0; i < vertices[vertex - 1].length; i++) {
                if (vertices[vertex - 1][i] > 0) {
                    neighbors.add(i + 1);
                }
            }
            return neighbors;
        }

        public boolean dijkistra(ArrayList<Esquina> lista, int destino) {
            boolean retorno = true;
            Esquina atual = null;

            while (naoVisitado(lista)) {

                atual = getMenor(lista);

                if (atual == null) {
                    return false;
                }

                ArrayList<Integer> vizinhos = getNeighbors(atual.getId());
                if (vizinhos.isEmpty()) {
                    return false;
                }
                for (Integer vizinho : vizinhos) {
                    int tamanhoTotal = atual.getPeso() + getCost(atual.getId(), vizinho);
                    if (tamanhoTotal < lista.get(vizinho - 1).getPeso()) {
                        lista.get(vizinho - 1).setPeso(tamanhoTotal);
                    }
                }

                if (atual.getId() == destino) {
                    for (Esquina e : lista) {
                        if (e.getPeso() == Integer.MAX_VALUE) {
                            retorno = false;
                        }
                    }
                    break;
                }
            }
            return retorno;
        }

        private static boolean naoVisitado(ArrayList<Esquina> nVisitados) {
            boolean retorno = false;
            for (Esquina e : nVisitados) {
                if (!e.isVisitado()) {
                    retorno = true;
                }
            }
            return retorno;
        }

        //procurar o peso comparando com todos da lista e vendo se já foi visitado
        //aux é inicializado com o valor máximo de um int e id é inicializado com o 0
        private static Esquina getMenor(ArrayList<Esquina> cidades) {
            int aux = Integer.MAX_VALUE;
            Esquina c = null;
            for (Esquina e : cidades) {
                if (e.getPeso() < aux && !e.isVisitado()) {
                    aux = e.getPeso();
                    e.setVisitado(true);
                    c = e;
                }
            }
            return c;
        }

        public static void main(String[] args) {
            Scanner leia = new Scanner(System.in);
            int inter = 0;
            int ruas = 0;
            do {
                ArrayList<Esquina> lista1 = new ArrayList<>();
                inter = leia.nextInt();
                ruas = leia.nextInt();

                for (int i = 1; i <= inter; i++) {
                    lista1.add(new Esquina(i));
                }

                Graph g = new Graph(inter);
                for (int i = 0; i < ruas; i++) {
                    g.makeEdge(leia.nextInt(), leia.nextInt(), leia.nextInt());
                }

                lista1.get(0).setPeso(0);

                boolean t1 = g.dijkistra(lista1, inter);

                if (t1) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } while (leia.hasNextInt());
        }
    }
}
