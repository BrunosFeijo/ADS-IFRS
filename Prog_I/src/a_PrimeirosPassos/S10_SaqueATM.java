package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe um valor inteiro positivo,
// que representa o valor a ser sacado na máquina, que possui cédulas de 100, 20, 5 e 1.
// Calcule o menor número de cédulas possíveis no qual o valor pode ser decomposto e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//512
//
//SAIDA
//5 de 100
//4 de 20
//3 de 5
//3 de 1

import java.util.Scanner;

public class S10_SaqueATM {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int saque = user.nextInt();
        int nota100, nota20, nota5, nota1;
        nota100 = saque / 100;
        saque = saque % 100;
        System.out.println(nota100 + " de 100");
        nota20 = saque / 20;
        saque = saque % 20;
        System.out.println(nota20 + " de 20");
        nota5 = saque / 5;
        nota1 = saque % 5;
        System.out.println(nota5 + " de 5");
        System.out.println(nota1 + " de 1");
    }
}
