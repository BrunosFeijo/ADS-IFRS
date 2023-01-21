package b_Condicionais;

//Os alunos criaram um novo jogo, com partidas que podem durar até um dia inteiro
// ( máximo de 24 horas, quando inicia num dia e termina no próximo).
// Desenvolva um programa que solicite ao usuário que informe dois valores inteiros (hora cheia),
// os quais representam, respectivamente, a hora de início e a hora de finalização de uma partida.
// Calcule o tempo de duração da partida e mostre uma mensagem com o resultado ,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//20
//12

import java.util.Scanner;

//SAIDA
//16
public class C06_DuracaoPartidaEmHoras {
    public static void main (String[]args){
        Scanner entrada = new Scanner(System.in);
        int horaInicio = entrada.nextInt();
        int horaFim = entrada.nextInt();
        int duracao;

        if (horaInicio >= 0 && horaFim >= 0){
            if (horaInicio == horaFim){
                System.out.print(24);
            }else if (horaInicio < horaFim){
                System.out.print(horaFim - horaInicio);
            }else{
                System.out.print((24-horaInicio) + horaFim);
            }
        }else{
            System.out.print("-");
        }
    }
}
