package b_Condicionais;

//Desenvolva um programa que solicite ao usuário que informe três valores inteiros positivos.
// Mostre uma mensagem com os valores em ordem crescente ,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//2
//3
//1

//SAIDA
// 1 2 3

import java.util.Scanner;

public class C05_TresValoresCrescentes {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int priValor = entrada.nextInt();
        int segValor = entrada.nextInt();
        int terValor = entrada.nextInt();

        if (priValor>0 && segValor>0 && terValor>0){

            if (priValor<=segValor && priValor<=terValor){
                System.out.print(priValor + " ");
                if (segValor<=terValor){
                    System.out.print(segValor+ " ");
                    System.out.print(terValor);
                }else{
                    System.out.print(terValor + " ");
                    System.out.print(segValor);
                }
            }else{
                if (segValor<=priValor && segValor<=terValor){
                    System.out.print(segValor+ " ");
                    if (priValor<=terValor){
                        System.out.print(priValor + " ");
                        System.out.print(terValor);
                    }else{
                        System.out.print(terValor + " ");
                        System.out.print(priValor);
                    }
                }else{
                    System.out.print(terValor + " ");
                    if (priValor<=segValor){
                        System.out.print(priValor +  " ");
                        System.out.print(segValor);
                    }else{
                        System.out.print(segValor + " ");
                        System.out.print(priValor);
                    }
                }
            }
        }else{
            System.out.print("-");
        }

    }
}
