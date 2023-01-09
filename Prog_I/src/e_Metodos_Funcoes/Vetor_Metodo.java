package e_Metodos_Funcoes;
//Construa um programa que leia um valor inteiro e positivo N e declare um vetor com nome "v" com N elementos do
// tipo double. Depois, leia mais um número, atribuindo esse valor ao primeiro elemento do vetor.
// Para cada elemento subsequente desse vetor, atribua o valor correspondente à metade do valor
// armazenado no elemento anterior. Por fim, mostre tod o conteúdo do vetor, no formato "v[indice] =
//  valor", onde valor possui 4 casas decimais,  conforme determinado nos exemplos abaixo.
//ENTRADA
//6
//8
//SAÍDA
//v[0] = 8.0000
//v[1] = 4.0000
//v[2] = 2.0000
//v[3] = 1.0000
//v[4] = 0.5000
//v[5] = 0.2500
//ENTRADA
//-3
// SAÍDA
// -
//ENTRADA
//4
//15.8
//SAÍDA
//v[0] = 15.8000
//v[1] = 7.9000
//v[2] = 3.9500
//v[3] = 1.9750
//
//Este programa deverá ter, além do método main(), métodos para as seguintes funcionalidades :
//a) ler um valor inteiro
//b) ler um valor double
//c) mostrar tod o vetor

import java.util.Scanner;

public class Vetor_Metodo {
    public static void main(String[] args) {
//        Scanner teclado = new Scanner(System.in);
        int tam = 0;
        tam = teclado(tam);
        if (tam >= 0) {

            double vet[] = new double[tam];
            double valor = 0;
            valor = teclado(valor);
            vet[0] = valor;

            for (int i = 1; i < tam; i++) {
                vet[i] = vet[i - 1] / 2;
            }

            mostrarVetor(vet);
        } else {
            System.out.println("-");
        }
    }

    public static int teclado(int valor) {
        Scanner scanner = new Scanner(System.in);
        valor = scanner.nextInt();
        return valor;
    }

    public static double teclado(double valor) {
        Scanner scanner = new Scanner(System.in);
        valor = scanner.nextDouble();
        return valor;
    }

    public static void mostrarVetor(double vet[]) {
        for (int i = 0; i < vet.length; i++) {
            System.out.printf("v[%d] = %.4f\n", i, vet[i]);
        }
    }
}
