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

        int n = 0, q = 0, vitorias = 0;

        while (n < nlogonia.size() && q < quadradonia.size()) {
            if (nlogonia.get(n) > quadradonia.get(q)) {
                n++;
                q++;
                vitorias++;
            } else {
                n++;
            }
        }

        System.out.println(vitorias);
    }
}
