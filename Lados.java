import java.util.Scanner;

public class Lados {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        while(leia.hasNextInt()){
            int a = leia.nextInt();
            int b = leia.nextInt();
            int c = leia.nextInt();
            int d = leia.nextInt();
            if(a==c && b==d){
                System.out.println("E um retangulo");
            }else{
                System.out.println("Nao e um retangulo");
            }
        }
    }
}
