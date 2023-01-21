package b_Condicionais;

//Desenvolva um programa que solicite ao usuário que informe três valores inteiros positivos,
// os quais representam três segmentos de reta. Verifique se é possível compor um triângulo com esses segmentos
// e mostre uma mensagem com o resultado , conforme determinado nos exemplos abaixo.

//ENTRADA
//3
//4
//5

//SAIDA
//sim

import java.util.Scanner;


public class C04_RetasTriangulo {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int priValor = entrada.nextInt();
        int segValor = entrada.nextInt();
        int terValor = entrada.nextInt();

        if (priValor >0 && segValor>0 && terValor>0){
            if (priValor >= (segValor+terValor) || segValor >= (priValor + terValor) || terValor >= (priValor+segValor)){
                System.out.print("não");
            }else{
                System.out.print("sim");
            }
        }else{
            System.out.print("inválido");
        }
    }
}
