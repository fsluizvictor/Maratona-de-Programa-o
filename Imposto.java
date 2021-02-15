package aed2praticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imposto {

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
        private boolean visitado, prox;

        public Cidade(int id, int divida) {
            this.id = id;
            this.divida = divida;
            this.peso = Integer.MAX_VALUE;
            this.visitado = false;
            this.prox = false;
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

        public void setProx(boolean prox) {
            this.prox = prox;
        }

        public boolean isProx() {
            return prox;
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
                cd.setProx(true);
                c = cd;
            }
        }
        return c;
    }

    private static void resetPeso(ArrayList<Cidade> cidades) {
        for (Cidade cd : cidades) {
            cd.setPeso(Integer.MAX_VALUE);
            if (cd.isProx()) {
                cd.setVisitado(false);
            }
        }
    }

    private static int km = 0;

    public static int dijkistra(ArrayList<Cidade> cidades, int capacidade) {

        int menorCaminho = 0;
        Cidade prox = null;
        //int km = 0;
        int qtdImposto = cidades.get(0).getDivida();

        while (dividaNaoPaga(cidades)) {
//            if (qtdImposto >= capacidade) {
//                resetPeso(cidades);
//                cidades.get(0).setPeso(0);
//                cidades.get(0).setVisitado(false);
//                prox = getMenor(cidades);
//                qtdImposto = 0;
//                menorCaminho = 0;
//            } else {
            prox = getMenor(cidades);
            //menorCaminho = 0;
            // }

            if (prox == null) {
                //km += menorCaminho;
                return km;
            }

            if (prox.getDivida() >= capacidade) {
                while (prox.getDivida() >= capacidade) {
                    km += menorCaminho;
                    prox.setDivida(prox.getDivida() - capacidade);
                }
                qtdImposto += prox.getDivida();

            } else {
                qtdImposto += prox.getDivida();
            }

            km += 2 * prox.getPeso();
            menorCaminho += 2 * prox.getPeso();

            for (Integer vizinho : getNeighbors(prox.getId())) {
                int totalComprimento = getComprimento(prox.getId(), vizinho);
                if (totalComprimento <= cidades.get(vizinho - 1).getPeso()) {
                    cidades.get(vizinho - 1).setPeso(totalComprimento);
                    if (cidades.get(vizinho - 1).getDivida() > 0) {
                        //km += 2 * totalComprimento;
                        qtdImposto += cidades.get(vizinho - 1).getDivida();
                        if (qtdImposto >= capacidade) {
                            //cidades.get(vizinho - 1).setDivida(0);
                            while (qtdImposto >= capacidade) {
                                qtdImposto -= capacidade;
                                km += menorCaminho;
                                km += 2 * cidades.get(vizinho - 1).getPeso();
                            }
                            km += 2 * cidades.get(vizinho - 1).getPeso();
                            cidades.get(vizinho - 1).setDivida(0);
                            //qtdImposto = 0;
                        } else {
                            km += 2 * cidades.get(vizinho - 1).getPeso();
                            cidades.get(vizinho - 1).setDivida(0);
                        }
                    }
                }
                if (qtdImposto >= capacidade) {
                    resetPeso(cidades);
                    cidades.get(0).setPeso(0);
                    cidades.get(0).setVisitado(false);
                    dijkistra(cidades, capacidade);
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
        //a divida da capital não pode ser zerada, logo teremos de manipulá-la de modo a adicioná-la no qtdImporto
        //se a dividada da capital for maior que a capacidade da carruagem subtraio o valor da capacidade dela até 
        //ser menor que a capacidade
        if (cidades.get(0).getDivida() > capacidade) {
            while (cidades.get(0).getDivida() >= capacidade) {
                cidades.get(0).setDivida(cidades.get(0).getDivida() - capacidade);
            }
        }

        cidades.get(0).setDivida(0);

        System.out.println(dijkistra(cidades, capacidade));
    }
}
