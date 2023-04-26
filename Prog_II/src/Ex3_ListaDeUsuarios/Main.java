package Ex3_ListaDeUsuarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> lista = new ArrayList<>();
        Random numeroAleatorio = new Random();
        NumberFormat preencherZerosAEsquerda = new DecimalFormat("000000");

        String nome;
        String senha;
        String email;
        Date dataNascimento;

        for (int i = 0; i < 10; i++) {
            nome = String.valueOf((char)(65 + i));
            senha = preencherZerosAEsquerda.format(numeroAleatorio.nextInt(1000000));
            email = nome + "@gmail.com";
            dataNascimento = new Date(numeroAleatorio.nextInt(73) + 1950,
                    numeroAleatorio.nextInt(12) + 1,
                    numeroAleatorio.nextInt(31) + 1);

            lista.add(new Usuario(nome, senha, email, dataNascimento));
        }

        System.out.println("Maiores de Idade: ");
        for(Usuario usuario : lista){
            if (usuario.isMaiorDeIdade()){
                System.out.println(usuario + "\n");
            }
        }
        System.out.println("Menores de Idade: ");
        for(Usuario usuario : lista){
            if (!usuario.isMaiorDeIdade()){
                System.out.println(usuario + "\n");
            }
        }

        System.out.println("Alterar senha: (corretamente)");
        senha = preencherZerosAEsquerda.format(numeroAleatorio.nextInt(1000000));
        System.out.println(lista.get(1).setSenha(lista.get(1).getSenha(),senha));

        System.out.println("Alterar senha: (erro)");
        senha = preencherZerosAEsquerda.format(numeroAleatorio.nextInt(1000000));
        System.out.println(lista.get(2).setSenha(lista.get(1).getSenha(),senha));
        System.out.println();

        System.out.println("Alterar email: (corretamente)");
        email = "novoEmail@gmail.com";
        System.out.println(lista.get(3).setEmail(email,lista.get(3).getSenha()));
        System.out.println("Alterar email: (erro)");
        email = "novoEmail@gmail.com";
        System.out.println(lista.get(3).setEmail(email,lista.get(5).getSenha()));
    }
}
