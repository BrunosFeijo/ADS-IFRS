package e_Metodos_Funcoes;

//Desenvolva um programa que solicite ao usuário que informe dois valores inteiros,
// calcule a soma entre eles e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.
//
//O programa deverá ser composto pelo método principal (main),
// um método para leitura e outro para a soma de dois valores.

import java.util.Scanner;

public class M01_SomaEntreDoisValores {
    public static void main(String[] args) {
        int valor1, valor2;

        valor1 =teclado();
        valor2 =teclado();

        System.out.println(soma(valor1,valor2));
    }
    public static int teclado(){
        Scanner teclado = new Scanner(System.in);
        int valor = teclado.nextInt();

        return valor;
    }
    public static int soma(int numero1, int numero2){
        return numero1 + numero2;
    }
}
