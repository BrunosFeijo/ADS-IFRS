package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe um valor positivo,
// com até uma casa decimal, que representa uma temperatura em graus Fahrenheit.
// Calcule a temperatura correspondente em Kelvin e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//32

//SAIDA
//273


import java.util.Scanner;

public class S08_ConverterKelvin {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        double grausFar = user.nextDouble();
        double grausKel = ((grausFar - 32) / (1.8)) + 273;
        System.out.print(String.format("%.1f", grausKel));
    }
}
