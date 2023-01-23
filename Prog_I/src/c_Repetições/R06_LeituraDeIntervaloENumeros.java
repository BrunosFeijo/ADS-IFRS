package c_Repetições;
//Construa um programa que leia, inicialmente, dois valores inteiros positivos que indicam um intervalo de interesse.
// Depois, o programa deve ler repetidamente uma quantidade indefinida de valores, até que o usuário informe 0 (zero);
// e apresenta uma mensagem informando quantos dos valores lidos estavam contidos no intervalo definido inicialmente,
// conforme determinado nos exemplos abaixo.

//ENTRADA
// 1 100 3 100 850 170 0

//SAIDA
// 2

import java.util.Scanner;

public class R06_LeituraDeIntervaloENumeros {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int inicio = entrada.nextInt();
        int fim = entrada.nextInt();
        int quantidade = 0;
        int valor = entrada.nextInt();

        while (valor != 0){
            if (valor >= inicio && valor <=fim){
                quantidade++;
            }
            valor = entrada.nextInt();
        }
        System.out.print(quantidade);
    }
}
