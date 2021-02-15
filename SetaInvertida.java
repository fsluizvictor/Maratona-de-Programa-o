package aed2praticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetaInvertida {

    private static int vertices[][];

    private static class Graph {

        public Graph(int numVertices) {
            vertices = new int[numVertices][numVertices];
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    vertices[i][j] = -1;
                }
            }

        }

        public void makeEdge(int vertex1, int vertex2, int time) {
            vertices[vertex1 - 1][vertex2 - 1] = time;
            vertices[vertex2 - 1][vertex1 - 1] = 1;
        }

        public void removeEdge(int vertex1, int vertex2) {
            vertices[vertex1 - 1][vertex2 - 1] = 0;
            vertices[vertex2 - 1][vertex1 - 1] = 0;
        }

    }

    private static class No {

        int id, peso;
        No antecessor;
        boolean visitado;

        public No(int id) {
            this.id = id;
            this.visitado = false;
            this.antecessor = null;
            this.peso = Integer.MAX_VALUE;
        }

        public int getId() {
            return id;
        }

        public No getAntecessor() {
            return antecessor;
        }

        public void setAntecessor(No antecessor) {
            this.antecessor = antecessor;
        }

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

    }

    private static boolean naoVisitado(ArrayList<No> nVisitados) {
        int cont = nVisitados.size();
        for (No n : nVisitados) {
            if (n.isVisitado()) {
                cont--;
            }
        }

        if (cont != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Integer> getNeighbors(No vertex) {
        List<Integer> neighbors = new ArrayList<>();
        if (vertex != null) {
            for (int i = 0; i < vertices[vertex.getId() - 1].length; i++) {
                if (vertices[vertex.getId() - 1][i] >= 0) {
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }

    private static int getCost(int vertex1, int vertex2) {
        return vertices[vertex1 - 1][vertex2 - 1];
    }

    private static int dikjistra(ArrayList<No> nos, int destino) {
        int peso = 0;

        while (naoVisitado(nos) == true) {
            //como os indices começam do 0 é necessário subtrai 1
            //vale a pena ressaltar que todos os circulos estão com os id's em ordem
            //retorna o no mais próximo, ou o que possui menor valor entre todos que não foram visitados ainda
            No near = getMenor(nos);

            //percorre a lista de nós vizinho e faz as devidas alterações
            List<Integer> vizinhos = getNeighbors(near);
            //se a lista de vizinhos é vazia signfica que não existe caminho entre a origem e o destino
            if (vizinhos.size() > 0) {
                for (Integer neighbor : getNeighbors(near)) {
                    neighbor++;
                    int totalCost = near.getPeso() + getCost(near.getId(), neighbor);
                    if (totalCost < nos.get(neighbor - 1).getPeso()) {
                        nos.get(neighbor - 1).setPeso(totalCost);
                        nos.get(neighbor - 1).setAntecessor(near);
                        peso += near.getPeso();
                    }
                }
            } else {
                //se a lista estiver vazia é retornado -1;
                return -1;
            }

            if (near.getId() == destino) {
                break;
            }
        }
        return peso;
    }

    private static No getMenor(ArrayList<No> nos) {
        int aux = Integer.MAX_VALUE;
        No no = null;
        for (No n : nos) {
            if (n.getPeso() < aux && n.isVisitado() == false) {
                n.setVisitado(true);
                no = n;
            }
        }
        return no;
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int circulos = leia.nextInt();
        int setas = leia.nextInt();
        int origem = leia.nextInt();
        int destino = leia.nextInt();

        Graph grafo = new Graph(circulos);

        for (int i = 0; i < setas; i++) {
            int v1 = leia.nextInt();
            int v2 = leia.nextInt();
            grafo.makeEdge(v1, v2, 0);
        }

        for (int i = 0; i < circulos; i++) {
            for (int j = 0; j < circulos; j++) {
                System.out.print(vertices[i][j] + " ");
            }
            System.out.println("\n");
        }

        //vale ressaltar que cada linha representa um nó,logo não é nessário criar um objeto nó
        ArrayList<No> caminho1 = new ArrayList<No>();
        ArrayList<No> caminho2 = new ArrayList<No>();
        for (int i = 0; i < circulos; i++) {
            caminho1.add(new No(i + 1));
            caminho2.add(new No(i + 1));
        }

        //caminho da bibi partinda da origem;
        caminho1.get(origem - 1).setPeso(0);
        //caminho da bibika partindo do destino;
        caminho2.get(destino - 1).setPeso(0);

        int c1 = dikjistra(caminho1, destino);
        int c2 = dikjistra(caminho2, origem);

        c2++;

        if (c1 == c2 || c1 < 0 || c2 < 0) {
            System.out.println("Bibibibika");
        } else if (c1 < c2) {
            System.out.println("Bibi: " + c1);
        } else {
            System.out.println("Bibika: " + c2);
        }
    }
}
