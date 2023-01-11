package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe um valore positivo inteiro que representa
// o diâmetro de um círculo em cm, calcule a área deste círculo e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

import java.util.Scanner;

public class S05_AreaDoCirculo {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int raio = (teclado.nextInt())/2;
        double area = Math.PI*(raio*raio);
        System.out.print(String.format("%.2f",area));
    }
}
