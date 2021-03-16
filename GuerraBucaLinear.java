import java.util.ArrayList;
import java.util.Scanner;

public class GuerraBucaLinear {

    static int cont = 0;

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<Integer> quadradonia = new ArrayList<>();
        ArrayList<Integer> nlogonia = new ArrayList<>();

        int qtd = leia.nextInt();

        for (int i = 0; i < qtd; i++) {
            quadradonia.add(leia.nextInt());
        }

        for (int i = 0; i < qtd; i++) {
            nlogonia.add(leia.nextInt());
        }

        int cont = 0;
        for (int i = 0; i < nlogonia.size(); i++) {
            int aux = nlogonia.get(i);
            aux--;
            if (quadradonia.contains(aux)) {
                int index = quadradonia.indexOf(aux);
                quadradonia.set(index, -2);
                nlogonia.set(i, -1);
                cont++;
            } else {
                while (aux != -1) {
                    if (quadradonia.contains(aux)) {
                        int index = quadradonia.indexOf(aux);
                        quadradonia.set(index, -2);
                        nlogonia.set(i, -1);
                        cont++;
                        break;
                    }
                    aux--;
                }
                nlogonia.set(i, -1);
            }
        }

        System.out.println(cont);

    }
}
