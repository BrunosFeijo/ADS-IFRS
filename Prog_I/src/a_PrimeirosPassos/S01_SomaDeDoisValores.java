package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe dois valores inteiros,
// calcule a soma entre eles e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

import java.util.Scanner;

public class S01_SomaDeDoisValores {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int priValor = teclado.nextInt();
        int segValor = teclado.nextInt();
        int resultado = priValor + segValor;

        System.out.print(resultado);
    }

}
