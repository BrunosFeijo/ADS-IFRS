package c_Repetições;

//Construa um programa que leia repetidamente uma quantidade indefinida de valores,
// até que o usuário informe 0 (zero); e apresenta uma mensagem informando quantos dos valores lidos estavam no
// intervalo entre 100 e 200 (inclusive), conforme determinado nos exemplos abaixo.

//ENTRADA
// 3 100 850 170 0

//SAIDA
// 2

import java.util.Scanner;

public class R04_NumerosEmIntervalo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int valor;
        int qtdValores = 0;

        valor = entrada.nextInt();
        while (valor != 0) {
            if (valor >= 100 && valor <= 200) {
                qtdValores++;
            }
            valor = entrada.nextInt();
        }
        System.out.print(qtdValores);
    }
}
