import java.util.Scanner;

public class Fechadura {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = leia.nextInt();
        int altura = leia.nextInt();

        int vet[] = new int[qtd];

        for (int i = 0; i < vet.length; i++) {
            vet[i] = leia.nextInt();
        }

        int soma = 0, diferenca = 0;

        for (int i = 0; i < vet.length; i++) {
            diferenca = altura - vet[i];
            soma += Math.abs(altura - vet[i]);
            vet[i] +=diferenca;
            if (i + 1 < vet.length)
                vet[i + 1] += diferenca;
        }
        System.out.println(soma);
    }
}
//soma == 5 + 10 + 5
// vet[i+1] = 40 45