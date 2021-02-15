package aed2praticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImpostoReal {

    private static int vertices[][];

    private static class Graph {

        public Graph(int numVertices) {
            vertices = new int[numVertices][numVertices];
        }

        public void makeEdge(int vertex1, int vertex2, int time) {
            vertices[vertex1 - 1][vertex2 - 1] = time;
            vertices[vertex2 - 1][vertex1 - 1] = time;
        }

        public void removeEdge(int vertex1, int vertex2) {
            vertices[vertex1 - 1][vertex2 - 1] = 0;
            vertices[vertex2 - 1][vertex1 - 1] = 0;
        }

    }

    public static int getComprimento(int vertex1, int vertex2) {
        return vertices[vertex1 - 1][vertex2 - 1];
    }

    public static List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < vertices[vertex - 1].length; i++) {
            if (vertices[vertex - 1][i] > 0) {
                neighbors.add(i + 1);
            }
        }
        return neighbors;
    }

    private static class Cidade {

        private int id, divida, peso;
        private boolean visitado;

        public Cidade(int id, int divida) {
            this.id = id;
            this.divida = divida;
            this.peso = Integer.MAX_VALUE;
            this.visitado = false;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDivida() {
            return divida;
        }

        public void setDivida(int divida) {
            this.divida = divida;
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

    private static boolean dividaNaoPaga(ArrayList<Cidade> nVisitados) {
        boolean retorno = false;
        for (Cidade c : nVisitados) {
            if (c.getDivida() > 0) {
                retorno = true;
            }
        }
        return retorno;
    }

    //procurar o peso comparando com todos da lista e vendo se já foi visitado
    //aux é inicializado com o valor máximo de um int e id é inicializado com o 0
    private static Cidade getMenor(ArrayList<Cidade> cidades) {
        int aux = Integer.MAX_VALUE;
        Cidade c = null;
        for (Cidade cd : cidades) {
            if (cd.getPeso() < aux && !cd.isVisitado()) {
                aux = cd.getPeso();
                cd.setVisitado(true);
                c = cd;
            }
        }
        return c;
    }

    private static void resetPeso(ArrayList<Cidade> cidades) {
        for (Cidade cd : cidades) {
            cd.setPeso(Integer.MAX_VALUE);
            cd.setVisitado(false);
        }
    }

    public static int dijkistra(ArrayList<Cidade> cidades, int capacidade) {

        Cidade prox = null;
        int km = 0;
        int qtdImposto = 0;
        int menorCaminho = 0;

        while (dividaNaoPaga(cidades)) {
            if (qtdImposto == capacidade) {
                resetPeso(cidades);
                cidades.get(0).setPeso(0);
                cidades.get(0).setVisitado(false);
                prox = getMenor(cidades);
                qtdImposto = 0;
            } else {
                qtdImposto = 0;
                prox = getMenor(cidades);
            }

            if (prox == null) {
                return km;
            }
            km += 2 * prox.getPeso();
            menorCaminho += 2 * prox.getPeso();

            for (Integer vizinho : getNeighbors(prox.getId())) {
                int totalComprimento = getComprimento(prox.getId(), vizinho);
                if (totalComprimento <= cidades.get(vizinho - 1).getPeso()) {
                    cidades.get(vizinho - 1).setPeso(totalComprimento);
                    //System.out.println(totalComprimento);
                    km += 2 * totalComprimento;
                    if (cidades.get(vizinho - 1).getDivida() > 0) {
                        if (cidades.get(vizinho - 1).getDivida() + qtdImposto <= capacidade) {
                            qtdImposto += cidades.get(vizinho - 1).getDivida();
                            cidades.get(vizinho - 1).setDivida(cidades.get(vizinho - 1).getDivida() - capacidade);
                        } else {
                            km += menorCaminho;
                            int diferenca = (cidades.get(vizinho - 1).getDivida() + qtdImposto) - capacidade;
                            qtdImposto += diferenca;
                            cidades.get(vizinho - 1).setDivida(cidades.get(vizinho - 1).getDivida() - capacidade);
                        }
                    }
                    if (qtdImposto >= capacidade) {

                    }
                }
            }
        }
        return km;
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtdcidades = leia.nextInt();
        int capacidade = leia.nextInt();

        Graph g = new Graph(qtdcidades);

        ArrayList<Cidade> cidades = new ArrayList<>();
        //Adiciona todas as cidades com suas respectivas dividas 
        for (int i = 0; i < qtdcidades; i++) {
            int imposto = leia.nextInt();
            cidades.add(new Cidade(i + 1, imposto));
        }

        while (leia.hasNextInt()) {
            g.makeEdge(leia.nextInt(), leia.nextInt(), leia.nextInt());
        }

        cidades.get(0).setPeso(0);
        cidades.get(0).setDivida(0);
        System.out.println(dijkistra(cidades, capacidade));
    }
}
