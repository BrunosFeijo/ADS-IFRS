package c_Repetições;
//Um número perfeito é aquele que a soma de todos os seus divisores totaliza o próprio número.
//Construa um programa que leia um número inteiro positivo.
// Elabore uma estratégia que, por repetições, verifique se esse é um "número perfeito" e
// apresenta uma mensagem informando o resultado

import java.util.Scanner;

public class R02_NumeroPerfeito {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int valor = entrada.nextInt();
        int soma = 0;

        for (int i = 1; i < valor; i++) {
            if ((valor % i) == 0) {
                soma = soma + i;
            }
        }

        if (soma == valor) {
            System.out.print("sim");
        } else {
            System.out.print("não");
        }
    }
}
