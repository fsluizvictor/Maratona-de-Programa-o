package aed2praticas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ImpostoDFSrecursivo {

    private static class Grafo {

        private ArrayList<Aresta>[] lista;
        private int vertices;

        //Grafo feito com lista de adjacência
        public Grafo(int vertices) {
            this.vertices = vertices;
            this.lista = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                lista[i] = new ArrayList<>();
            }
        }

        private void fazAresta(int vertice1, int vertice2, int dist) {
            this.lista[vertice1 - 1].add(new Aresta(vertice1, vertice2, dist));
            this.lista[vertice2 - 1].add(new Aresta(vertice2, vertice1, dist));
        }

        private ArrayList<Integer> vizinhos(int vertice) {
            ArrayList<Aresta> aux = lista[vertice - 1];
            ArrayList<Integer> listaVizinhos = new ArrayList<Integer>();
            for (Aresta a : aux) {
                listaVizinhos.add(a.getDest());
            }
            return listaVizinhos;
        }

        private int retornaPeso(int vertice1, int vertice2) {
            int peso = 0;
            ArrayList<Aresta> aux = lista[vertice1 - 1];
            for (Aresta a : aux) {
                if (a.getOri() == vertice1 && a.getDest() == vertice2) {
                    peso = a.getPeso();
                    break;
                }
            }
            return peso;
        }

        // A function used by DFS 
        void DFSUtil(ArrayList<Cidade> cidades, int pos) {
            // Mark the current node as visited and print it 
            

            cidades.get(pos).setVisitado(true);
            
            // Recur for all the vertices adjacent to this vertex 
            ArrayList aux =  vizinhos(cidades.get(pos).getId());
            while (aux.) {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

//        // The function to do DFS traversal. It uses recursive DFSUtil() 
//        void DFS(int v) {
//            // Mark all the vertices as not visited(set as 
//            // false by default in java) 
//            boolean visited[] = new boolean[this.vertices];
//
//            // Call the recursive helper function to print DFS traversal 
//            DFSUtil(v, visited);
//        }

    }

    private static class Cidade {

        private int divida, id;
        boolean visitado;

        public Cidade(int id, int divida) {
            this.divida = divida;
            this.id = id;
            this.visitado = false;
        }

        public int getDivida() {
            return divida;
        }

        public void setDivida(int divida) {
            this.divida = divida;
        }

        public int getId() {
            return id;
        }

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }

    }

    private static class Aresta {

        private int ori, dest, peso;

        public Aresta(int ori, int dest, int peso) {
            this.ori = ori;
            this.dest = dest;
            this.peso = peso;
        }

        public int getOri() {
            return ori;
        }

        public void setOri(int ori) {
            this.ori = ori;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtdcidades = leia.nextInt();
        int capacidade = leia.nextInt();

        Grafo g = new Grafo(qtdcidades);

        ArrayList<Cidade> cidades = new ArrayList<>();
        //Adiciona todas as cidades com suas respectivas dividas 
        for (int i = 0; i < qtdcidades; i++) {
            int imposto = leia.nextInt();
            cidades.add(new Cidade(i + 1, imposto));
        }

        while (leia.hasNextInt()) {
            g.fazAresta(leia.nextInt(), leia.nextInt(), leia.nextInt());
        }

        //a divida da capital não pode ser zerada, logo teremos de manipulá-la de modo a adicioná-la no qtdImporto
        //se a dividada da capital for maior que a capacidade da carruagem subtraio o valor da capacidade dela até 
        //ser menor que a capacidade
        if (cidades.get(0).getDivida() > capacidade) {
            while (cidades.get(0).getDivida() >= capacidade) {
                cidades.get(0).setDivida(cidades.get(0).getDivida() - capacidade);
            }
        }

        cidades.get(0).setDivida(0);
        
        g.DFS(1);
        //System.out.println(dijkistra(cidades, capacidade));
    }

}
