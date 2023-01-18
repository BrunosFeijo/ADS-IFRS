package b_Condicionais;
//Desenvolva um programa que solicite ao usuário que informe um valor inteiro.
// Verifique se este valor é par ou é ímpar, e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

import java.util.Scanner;

public class C02_ParOuImpar {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double valor = entrada.nextDouble();

        if ((valor % 2) == 0) {
            System.out.print("par");
        } else {
            System.out.print("impar");
        }
    }
}
