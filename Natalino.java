import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Natalino {

    static class Pacote implements Comparable<Pacote> {

        double peso, brinquedos, razao;

        Pacote(double peso, double brinquedos) {
            this.peso = peso;
            this.brinquedos = brinquedos;
        }

        // razao == quantidade/peso

        public void setRazao(double razao) {
            this.razao = razao;
        }

        public double getBrinquedos() {
            return brinquedos;
        }

        public double getPeso() {
            return peso;
        }

        @Override
        public int compareTo(Pacote pacote) {
            if (this.razao < pacote.razao) {
                return -1;
            } else if (this.razao < pacote.razao) {
                return 1;
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int viagens = leia.nextInt();
        int cont = 0;
        
        while (cont < viagens) {
            ArrayList<Pacote> pacotes = new ArrayList<Pacote>();
            ArrayList<Pacote> pilha = new ArrayList<Pacote>();
            ArrayList<Pacote> pilha_aux = new ArrayList<Pacote>();
            
            int qtd_pacotes = leia.nextInt();

            for (int i = 0; i < qtd_pacotes; i++) {
                Pacote pacote = new Pacote(leia.nextDouble(), leia.nextDouble();
                pacote.setRazao(pacote.getBrinquedos() / pacote.getPeso());
                pacotes.add(pacote);
            }

            Collections.sort(pacotes);

            double peso_total, sobras, qtd_peso_p, qtd_p, qtd_total, razao_pilha;
            int contador = pilha.size() - 1;

            for (int i = 0; i < pacotes.size(); i++) {
                if (peso_total + pacotes.get(i).getPeso() > 50) {
                    sobras = peso_total + pacotes.get(i).getPeso() -50;
                    while(sobras>50 && contador>=0){
                        sobras  -=pilha.get(contador).getPeso();
                        qtd_peso_p  += pilha.get(contador).getPeso();
                        qtd_p += pilha.get(contador).getBrinquedos();
                        contador--;
                    }
                    if(!(cont<0)){
                        razao_pilha = qtd_p;
                        if(razao_pilha<pacotes.get(i).getBrinquedos()){
                            for (int j = pilha.size() - 1; j > - 1; j--) {
                                peso_total -= pilha.get(j).getPeso();
                                qtd_total-=pilha.get(j).getBrinquedos();
                                pilha.remove(j);
                            }
                            pilha.add(pacotes.get(i));
                            peso_total += pacotes.get(i).getPeso();
                            qtd_total += pacotes.get(i).getBrinquedos();
                            contador = pilha.size() - 1;
                        }else{
                            contador = pilha.size() -1;
                         }
                    }
                }else{
                    pilha.add(pacotes.get(i));
                    peso_total += pacotes.get(i).getPeso();
                    qtd_total += pacotes.get(i).getBrinquedos();
                    contador = pilha.size() - 1;
                }

            }

            System.out.println(qtd_total);
            System.out.println(peso_total);
            System.out.println(pacotes.size() - pilha.size());

            cont++;
        }

    }
}
