import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Collections;

public class GuerraArrayList {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = leia.nextInt();
        ArrayList<Integer> quadradonia = new ArrayList<Integer>();
        ArrayList<Integer> nlogonia = new ArrayList<Integer>();

        for (int i = 0; i < qtd; i++) {
            quadradonia.add(leia.nextInt());
        }

        for (int i = 0; i < qtd; i++) {
            nlogonia.add(leia.nextInt());
        }

        Collections.sort(quadradonia);
        Collections.sort(nlogonia);

        int cont = 0;
        int res[] = new int[2];
        for (int i = 0; i < qtd; i++) {
            for (Integer quad : quadradonia) {
                if (nlogonia.get(i) > quad) {
                    quadradonia.remove(quad);
                    cont++;
                    break;
                }
            }

        }

        System.out.println(cont);

    }
}
