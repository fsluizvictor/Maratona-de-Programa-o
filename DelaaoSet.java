import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DelaaoSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> delatores = new HashSet<Integer>();
        int qtd = in.nextInt();
        int adv = in.nextInt();
        for (int i = 1; i < qtd; i++) {
            int n = in.nextInt();
            delatores.add(n);
        }
        System.out.println(delatores.size() + adv);
    }
}
