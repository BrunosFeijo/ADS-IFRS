package PrimeirosPassos;

import java.util.Scanner;

//Desenvolva um programa que solicite ao usuário que informe dois valores inteiros,
// calcule o produto entre eles e mostre uma mensagem com o resultado.
public class ProdutoDeDoisValores {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int priValor = teclado.nextInt();
        int segValor = teclado.nextInt();
        int resultado = priValor * segValor;

        System.out.print(resultado);

    }

}
