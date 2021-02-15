package aed2praticas;

import java.util.ArrayList;

public class Natal {
     private static class No {

        int valor;
        ArrayList<No> lista;
        int maisAlto;

        public No(int valor) {
            this.valor = valor;
            this.lista = new ArrayList<No>();
        }

        public int getValor() {
            return valor;
        }

    }

    
}
