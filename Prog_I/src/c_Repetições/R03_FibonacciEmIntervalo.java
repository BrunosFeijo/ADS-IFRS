package c_Repetições;
//A Série de Fibonacci é uma sequencia de valores onde cada elemento é o resultado da soma dos seus dois antecessores,
// considerando que os dois primeiros elementos são 0 e 1.
//
//Construa um programa que leia dois valores inteiros positivos e, a partir de uma estratégia que usa repetições,
// gere os elementos da Série de Fibonacci entre esses dois valores (inclusive) e apresenta uma mensagem informando
// o resultado

//ENTRADA
//2
//10
//SAIDA
//2 3 5 8

import java.util.Scanner;

public class R03_FibonacciEmIntervalo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int penValor = 0;
        int ultValor = 1;
        int soma = 0;

        int inicioIntervalo = entrada.nextInt();
        int fimIntervalo = entrada.nextInt();

        for (int i = 0; i < fimIntervalo; i++) {
            if (soma >= inicioIntervalo && soma <= fimIntervalo) {
                System.out.print(soma + " ");
            }
            penValor = ultValor;
            ultValor = soma;
            soma = ultValor + penValor;
        }
    }
}
