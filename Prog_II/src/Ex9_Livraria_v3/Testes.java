package Ex9_Livraria_v3;

import java.util.Arrays;

public class Testes {
    public static void main(String[] args) {
        String texto = "Teste1\nTexte2";
        String[] aux = texto.split("\n",1);
//        texto += aux[0];
        System.out.println(texto);
        System.out.println(Arrays.stream(aux).toList());
    }
}
