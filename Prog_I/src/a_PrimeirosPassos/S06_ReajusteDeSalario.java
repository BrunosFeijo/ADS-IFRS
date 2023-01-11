package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe dois valores positivos,
// com até duas casas decimais, que representam, respectivamente,
// o salário e o percentual de reajuste salarial.
// Calcule qual o novo salário e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

//entrada
//200
//15.2

//saída
//230.40

import java.util.Scanner;

public class S06_ReajusteDeSalario {
    public static void main(String[]args){
        Scanner user = new Scanner(System.in);
        double salario = user.nextDouble();
        double aumento = user.nextDouble();
        double novoSalario = salario + (salario*(aumento/100));
        System.out.print(novoSalario);
    }
}
