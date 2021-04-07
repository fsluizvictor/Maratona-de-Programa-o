import java.util.Scanner;

public class NatalinoPDRecursivo {

    static int peso = 0;

    static int mochila(int peso_maximo, int pesos[], int brinquedos[], int qtd) {
        if (peso_maximo == 0 || qtd == 0) {
            return 0;
        }

        if (pesos[qtd - 1] > peso_maximo) {

            return mochila(peso_maximo, pesos, brinquedos, qtd - 1);

        } else {

            int incluso = brinquedos[qtd - 1] + mochila(peso_maximo - pesos[qtd - 1], pesos, brinquedos, qtd - 1);
            peso += pesos[qtd - 1];
            int nao_incluso = mochila(peso_maximo, pesos, brinquedos, qtd - 1);
            int max = Math.max(incluso, nao_incluso);
            System.out.println("incluso: " + incluso + "peso : " + (peso_maximo - pesos[qtd - 1]));
            System.out.println("nao incluso: " + nao_incluso);
            // System.out.println("max : " + (pesos[qtd - 1]));

            return max;
        }

    }

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        int viagens = leia.nextInt();
        int cont = 0;

        while (cont < viagens) {

            int pac = leia.nextInt();

            int brinquedos[] = new int[pac];
            int pesos[] = new int[pac];

            for (int i = 0; i < pac; i++) {
                brinquedos[i] = leia.nextInt();
                pesos[i] = leia.nextInt();
            }

            int resultado = mochila(50, pesos, brinquedos, pac);

            System.out.println(resultado + " : brinquedos\n" + peso + " : peso");

            cont++;
        }

    }
}
