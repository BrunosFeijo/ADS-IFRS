import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char letra = 65;
        String nome = String.valueOf(letra);
        Random numeroAleatorio = new Random();

        System.out.println(numeroAleatorio.nextInt(1000000));
    }
}