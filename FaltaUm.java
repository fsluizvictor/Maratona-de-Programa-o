import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FaltaUm {

    private static char[] p;
    static ArrayList<String> permutacoes = new ArrayList<>();

    private static void permuta(char vet[], int n) {
        if (n == vet.length) {
            String aux = String.valueOf(p);
            permutacoes.add(aux);
        } else {
            for (int i = 0; i < vet.length; i++) {
                boolean achou = false;
                for (int j = 0; j < n; j++) {
                    if (p[j] == vet[i]) {
                        achou = true;
                    }
                }
                if (!achou) {
                    p[n] = vet[i];
                    permuta(vet, n + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int n = leia.nextInt();
        p = new char[n];

        char vet[] = new char[n];
        for (int i = 1; i <= vet.length; i++) {
            char aux = Integer.toString(i).charAt(0);
            vet[i - 1] = aux;
        }

        permuta(vet, 0);

        ArrayList<String> lista = new ArrayList<>();
        for (String s : permutacoes) {
            String aux = "";
            for (int i = 0; i < s.length(); i++) {
                aux += s.charAt(i);
                if (i != s.length() - 1)
                    aux += " ";
            }
            lista.add(aux);
        }

        ArrayList<String> termos = new ArrayList<>();

        int fatorial = 1;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }

        for (int i = 0; i < fatorial; i++) {
            String aux = leia.nextLine();
            termos.add(aux);
        }

        for (String s : lista) {
            if (!termos.contains(s))
                System.out.println(s);
        }
    }
}
