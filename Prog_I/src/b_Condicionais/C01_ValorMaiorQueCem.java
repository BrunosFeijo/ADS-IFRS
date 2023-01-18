package b_Condicionais;

//Desenvolva um programa que solicite ao usuário que informe um valore inteiro positivo.
// Verifique se este valor é maior do que 100 e mostre uma mensagem com o resultado ,
// conforme determinado nos exemplos abaixo.

import java.util.Scanner;

public class C01_ValorMaiorQueCem {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int valor = entrada.nextInt();

        if (valor > 100){
            System.out.println("sim");
        }else{
            System.out.println("não");
        }
    }
}
