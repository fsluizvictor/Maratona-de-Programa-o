import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Ponto implements Comparable<Ponto> {
    int esquerdo;
    int direito;
    int dist;

    public Ponto() {
    }

    public Ponto(int esquerdo, int direito) {
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    public int getEsquerdo() {
        return this.esquerdo;
    }

    public int getDireito() {
        return this.direito;
    }

    public void setDist(int d) {
        this.dist = d;
    }

    @Override
    public int compareTo(Ponto p) {
        if (this.getDireito() < p.getDireito()) {
            return -1;
        } else if (this.getDireito() > p.getDireito()) {
            return 1;
        }
        return 0;
    }

    static int calculaDist(Ponto p1, Ponto p2) {
        int dist = (int) Math.sqrt(
                Math.pow(p2.getDireito() - p1.getDireito(), 2) + Math.pow(p2.getEsquerdo() - p1.getEsquerdo(), 2));
        return dist;
    }


    static Ponto menorDistancia(ArrayList<Ponto> pontos, int qtd) {
        return pontos.get(0);
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int qtd = leia.nextInt();
        ArrayList<Ponto> pontos = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            int p1 = leia.nextInt();
            int p2 = leia.nextInt();
            Ponto ponto = new Ponto(p1, p2);
            pontos.add(ponto);
        }

        Collections.sort(pontos);
    }
}