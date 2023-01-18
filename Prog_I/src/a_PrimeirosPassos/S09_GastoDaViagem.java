package a_PrimeirosPassos;

//Desenvolva um programa que solicite ao usuário que informe dados referentes ao seu carro e uma determinada viagem:
// consumo de combustível do carro (Kl/litros), valor do litro de combustível (R$),
// distância percorrida (Km), total de pedágios Não no trajeto e o valor unitário de cada pedágio (R$).
// Calcule o gasto total da viagem (combustível mais pedágios) e mostre uma mensagem com esse resultado,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//12
//8
//240
//4
//5

import java.util.Scanner;

//SAIDA
//180
public class S09_GastoDaViagem {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        double kmL = user.nextDouble();
        double valorCom = user.nextDouble();
        double km = user.nextDouble();
        double pedagio = user.nextDouble();
        double valorPed = user.nextDouble();
        double gastoDaViagem = ((km / kmL) * valorCom) + (valorPed * pedagio);
        System.out.print(String.format("%.2f", gastoDaViagem));
    }
}
