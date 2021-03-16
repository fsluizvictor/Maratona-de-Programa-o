import java.util.ArrayList;
import java.util.Scanner;

public class Guerra {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        int qtd = leia.nextInt();
        int quadradonia[] = new int[qtd];
        int nlogonia[] = new int[qtd];

        for (int i = 0; i < qtd; i++) {
            quadradonia[i] = leia.nextInt();
        }

        for (int i = 0; i < qtd; i++) {
            nlogonia[i] = leia.nextInt();
        }

        int cont = 0;
        for (int i = 0; i < nlogonia.length; i++) {
            for (int j = 0; j < nlogonia.length; j++) {
                if (nlogonia[i] > quadradonia[j] && quadradonia[j] != -1) {
                    cont++;
                    nlogonia[i] = -1;
                    quadradonia[j] = -1;
                    break;
                }
            }
        }
        System.out.println(cont);
    }
}
