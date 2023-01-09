package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe seis valores positivos -
// que podem conter até duas casas decimais.
// Esses valores correspondem a 3 pares de valores onde cada par é composto pela nota e
// o respectivo peso desta nota no cálculo da média final. Calcule a média ponderada entre eles e
// mostre uma mensagem com o resultado, conforme determinado nos exemplos abaixo.
//
//No primeiro exemplo, os valores informados 5 2 6 2 6 4 indicam que a primeira nota (5) tem peso (2),
// a segunda nota (6) tem peso (2) e a terceira nota (6) tem peso (4).

import java.util.Scanner;

public class MediaPonderada {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        double priValor = teclado.nextDouble();
        double priPeso = teclado.nextDouble();
        double segValor = teclado.nextDouble();
        double segPeso = teclado.nextDouble();
        double terValor = teclado.nextDouble();
        double terPeso = teclado.nextDouble();
        double resultado = ((priValor * priPeso) + (segValor * segPeso) + (terValor * terPeso))/(priPeso + segPeso + terPeso);

        System.out.print(resultado);
    }
}
