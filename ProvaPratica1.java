package aed2praticas;

import java.util.ArrayList;
import java.util.Scanner;

public class ProvaPratica1 {

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

        private void fazAresta(int vertice1, int vertice2) {
            this.lista[vertice1 - 1].add(new Aresta(vertice1, vertice2, 0));
            this.lista[vertice2 - 1].add(new Aresta(vertice2, vertice1, 1));
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

        private Circulo retornaMenor(ArrayList<Circulo> lista) {
            int menor = Integer.MAX_VALUE;
            Circulo aux = null;
            for (Circulo c : lista) {
                if (c.getPeso() < menor && !c.isVisitado()) {
                    menor = c.getPeso();
                    c.setVisitado(true);
                    aux = c;
                }
            }
            return aux;
        }

        private boolean naoVisitado(ArrayList<Circulo> lista) {
            boolean visitado = false;
            for (Circulo c : lista) {
                if (!c.isVisitado()) {
                    visitado = true;
                }
            }
            return visitado;
        }

        public int dijkistra(ArrayList<Circulo> lista, int destino) {
            int peso = 0;
            while (naoVisitado(lista)) {
                //retorna o no mais proximo, ou o que possui menor valor entre todos que nao foram visitados ainda
                Circulo atual = retornaMenor(lista);
                //percorre a lista de nos vizinho e faz as devidas alteracoes
                if (atual == null) {
                    return peso;
                }

                peso = atual.getPeso();

                ArrayList<Integer> vizinhos = vizinhos(atual.getId());
                //se a lista de vizinhos e vazia signfica que nao existe caminho entre a origem e o destino
                if (vizinhos.size() > 0) {
                    for (Integer neighbor : vizinhos) {
                        int totalCost = atual.getPeso() + retornaPeso(atual.getId(), neighbor);
                        if (totalCost <= lista.get(neighbor - 1).getPeso()) {
                            lista.get(neighbor - 1).setPeso(totalCost);
                        }
                    }
                } else {
                    //se a lista estiver vazia e retornado -1;
                    return -1;
                }
                if (atual.getId() == destino) {
                    break;
                }
            }
            return peso;
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

    private static class Circulo {

        private int id, peso;
        boolean visitado;

        public Circulo(int id) {
            this.id = id;
            //inicializo cada vertice com "infinito"
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

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int circulos = leia.nextInt();
        int setas = leia.nextInt();
        int origem = leia.nextInt();
        int destino = leia.nextInt();
        Grafo grafo = new Grafo(circulos);
        for (int i = 0; i < setas; i++) {
            grafo.fazAresta(leia.nextInt(), leia.nextInt());
        }
        ArrayList<Circulo> bibi = new ArrayList<>();
        ArrayList<Circulo> bibika = new ArrayList<>();
        for (int i = 0; i < circulos; i++) {
            bibi.add(new Circulo(i + 1));
            bibika.add(new Circulo(i + 1));
        }

        //para solução é traçado dois caminhos: 1 - origem ao destino  2 - destino a origem
        //desde já coloco 0 no peso para que seja pego o menor caminho
        bibi.get(0).setPeso(0);
        bibika.get(circulos - 1).setPeso(0);

        int b1 = grafo.dijkistra(bibi, destino);
        int b2 = grafo.dijkistra(bibika, origem);

        if (b1 == b2 || b1 < 0 || b2 < 0) {
            System.out.println("Bibibibika");
        } else if (b1 < b2) {
            System.out.println("Bibi: " + b1);
        } else {
            System.out.println("Bibika: " + b2);
        }
    }

}
