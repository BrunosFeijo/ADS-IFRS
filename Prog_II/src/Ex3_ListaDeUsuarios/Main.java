package Ex3_ListaDeUsuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> lista = new ArrayList<>();
        Random numeroAleatorio = new Random();
        String nome;
        int senha;
        String email;
        Date dataNascimento;

        for (int i = 0; i < 10; i++){
            nome = String.valueOf(65 + i);
            senha = numeroAleatorio.nextInt(1000000);
//            lista.add(new Usuario(nome,))


        }


    }
}
