package b_Condicionais;

//O novo jogo, com partidas que podem durar até um dia inteiro
// ( máximo de 24 horas, quando inicia num dia e termina no próximo)
// se transformou num sucesso entre os alunos. Mas resolveram que é necessário registrar um pouco melhor
// o tempo de duração: com horas e minutos. Desenvolva um programa que solicite ao usuário que informe quatro
// valores inteiros, os quais representam, respectivamente, a hora e minuto de início, e a hora e minuto
// de finalização de uma partida. Calcule o tempo de duração da partida e mostre uma mensagem com o resultado,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//20
//50
//12
//10

//SAIDA
//15:20

import java.util.Scanner;

public class C07_DuracaoPartidaEmHorasEMinutos {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int horaInicio = entrada.nextInt()*60;
        int minutoInicio = entrada.nextInt();
        int horaFim = entrada.nextInt()*60;
        int minutoFim = entrada.nextInt();

        int horarioInicio = horaInicio + minutoInicio;
        int horarioFim = horaFim + minutoFim;

        int hora, minuto;

        if (horaInicio >= 0 && minutoInicio >= 0 && horaFim >= 0 && minutoFim >= 0){
            if (horarioInicio == horarioFim){
                System.out.print("24:00");

            }else if(horarioInicio < horarioFim){
                hora = (horarioFim - horarioInicio) / 60;
                minuto = (horarioFim - horarioInicio) % 60;
                System.out.printf("%d:%02d", hora , minuto);

            }else{
                hora = (((24*60) - horarioInicio) + horarioFim) / 60;
                minuto = (((24*60) - horarioInicio) + horarioFim) % 60;
                System.out.printf("%d:%02d" , hora , minuto);
            }
        }else{
            System.out.print("-");
        }
    }
}
