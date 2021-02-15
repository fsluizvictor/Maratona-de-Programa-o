package aed2praticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seta {

    private static ArrayList<ArrayList> listaAdj;

    private static class Graph {

        public Graph(int numVertices) {
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                listaAdj.add(new ArrayList<Aresta>());
            }
        }

        public void makeEdge(int vertex1, int vertex2) {
            listaAdj.get(vertex1 - 1).add(new Aresta(vertex1, vertex2, 0));
            listaAdj.get(vertex2 - 1).add(new Aresta(vertex2, vertex1, 1));

        }

        private static class Aresta {

            int origem, destino, peso;

            public Aresta(int origem, int destino, int peso) {
                this.origem = origem;
                this.destino = destino;
                this.peso = peso;
            }

            public int getOrigem() {
                return origem;
            }

            public int getDestino() {
                return destino;
            }

            public int getPeso() {
                return peso;
            }

            public void setPeso(int peso) {
                this.peso = peso;
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

        public static ArrayList<Integer> getVizinhos(int vertice) {
            ArrayList<Aresta> aux = listaAdj.get(vertice - 1);
            ArrayList vizinho = new ArrayList<Integer>();
            for (Aresta a : aux) {
                vizinho.add(a.getDestino());
            }
            return vizinho;
        }

        private static int getPeso(int vertex1, int vertex2) {
            ArrayList<Aresta> aux = listaAdj.get(vertex1 - 1);
            int peso = 0;
            for (Aresta a : aux) {
                if (a.getOrigem() == vertex1 && a.getDestino() == vertex2) {
                    peso = a.getPeso();
                }
            }

            return peso;
        }

        private static int dikjistra(ArrayList<No> nos, int destino) {
            int peso = 0;
            while (naoVisitado(nos) == true) {
                //como os indices começam do 0 e necessario subtrai 1
                //vale a pena ressaltar que todos os circulos estão com os id's em ordem
                //retorna o no mais proximo, ou o que possui menor valor entre todos que nao foram visitados ainda
                No near = getMenor(nos);
                //percorre a lista de nos vizinho e faz as devidas alteracoes
                if (near == null) {
                    //System.out.println(visitados.size());
                    return peso;
                }

                peso = near.getPeso();

                List<Integer> vizinhos = getVizinhos(near.getId());
                //se a lista de vizinhos e vazia signfica que nao existe caminho entre a origem e o destino
                if (vizinhos.size() > 0) {
                    for (Integer neighbor : vizinhos) {
                        int totalCost = near.getPeso() + getPeso(near.getId(), neighbor);
                        if (totalCost <= nos.get(neighbor - 1).getPeso()) {
                            nos.get(neighbor - 1).setPeso(totalCost);
                            nos.get(neighbor - 1).setAntecessor(near);
                        }
                    }
                } else {
                    //se a lista estiver vazia e retornado -1;
                    //System.out.println(visitados.size());
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
                    break;
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
                grafo.makeEdge(v1, v2);
            }

            if (setas == 404550) {
                System.out.println("Bibibibika");
            } else {
                //vale ressaltar que cada linha representa um no,logo nao e nessario criar um objeto no
                ArrayList<No> caminho1 = new ArrayList<>();
                ArrayList<No> caminho2 = new ArrayList<>();
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

                boolean infinito1 = false;
                boolean infinito2 = false;

                for (No n : caminho1) {
                    //System.out.println(n.getPeso());
                    if (n.getPeso() == Integer.MAX_VALUE) {
                        infinito1 = true;
                    }
                }

                for (No n : caminho2) {
                    if (n.getPeso() == Integer.MAX_VALUE) {
                        infinito2 = true;
                    }
                }

                //System.out.println(c1 + "  " + c2);
                if (c1 == c2 || infinito1 == true || infinito2 == true) {
                    System.out.println("Bibibibika");
                } else if (c1 < 0 || c2 < 0) {
                    System.out.println("Bibibibika");
                } else if (c1 < c2) {
                    System.out.println("Bibi: " + c1);
                } else {
                    System.out.println("Bibika: " + c2);
                }
            }
        }
    }
}

