package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe quatro valores positivos -
// que podem conter até duas casas decimais,
// calcule a média aritmética entre eles e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

import java.util.Scanner;

public class S03_Media {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double priValor = teclado.nextDouble();
        double segValor = teclado.nextDouble();
        double terValor = teclado.nextDouble();
        double quaValor = teclado.nextDouble();
        double resultado = (priValor + segValor + terValor + quaValor) / 4;

        System.out.print(resultado);

    }
}
