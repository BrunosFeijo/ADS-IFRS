package b_Condicionais;

//Desenvolva um programa que solicite ao usuário que informe dois valores inteiros positivos.
// Verifique qual deles é maior, e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

// ENTRADA
//50
//60

//SAIDA
//segundo

import java.util.Scanner;

public class C03_MaiorEntreDoisNumeros {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double priValor = entrada.nextDouble();
        double segValor = entrada.nextDouble();

        if (priValor > 0 && segValor > 0) {

            if (priValor > segValor) {
                System.out.print("primeiro");
            } else {
                if (priValor < segValor) {
                    System.out.print("segundo");
                } else {
                    System.out.print("iguais");
                }
            }
        } else {
            System.out.print("inválido");
        }
    }
}
