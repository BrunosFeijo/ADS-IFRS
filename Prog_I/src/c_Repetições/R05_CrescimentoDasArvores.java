package c_Repetições;
//No pomar há hoje várias árvores, que foram plantadas em tempos distintos e possuem velocidade de crescimento diferentes.
// Por exemplo, existe a árvore A que já tem 1,50 metro e cresce 2 centímetros por ano e a árvore B
// que tem somente 1,10 metro mas cresce 3 centímetros por ano. Queremos saber, ao comparar duas árvores,
// se aquela que hoje é mais baixa vai, com o passar dos anos, ultrapassar a altura da que hoje é mais alta e,
// nesse caso, quantos anos serão necessários para isso acontecer.
//
//Construa um programa que recebe quatro valores inteiros positivos, os quais representam, respectivamente,
// a altura em centímetros e a velocidade de crescimento em centímetros por ano, de duas árvores quaisquer.
// Verifica se a mais baixa chegará a ultrapassar a altura da mais alta e, em caso positivo,
// calcula quantos anos ainda serão necessários para que isso ocorra; e apresenta uma mensagem informando o resultado,
// conforme determinado nos exemplos abaixo.

//ENTRADA
//150 2 110 3

//SAÍDA
//41

import java.util.Scanner;

public class R05_CrescimentoDasArvores {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int priAltura = entrada.nextInt();
        int priTaxaCresc = entrada.nextInt();
        int segAltura = entrada.nextInt();
        int segTaxaCresc = entrada.nextInt();
        int anos = 0;
        int difAltura;

        //Caso a primeira árvore seja a maior
        if (priAltura > segAltura) {
            //Definir qual é a taxa de crescimento maior
            if (priTaxaCresc >= segTaxaCresc) {
                System.out.print("nunca");
                System.exit(0);
            } else {
                difAltura = priAltura - segAltura;
                while (difAltura >= 0) {
                    priAltura = priAltura + priTaxaCresc;
                    segAltura = segAltura + segTaxaCresc;
                    difAltura = priAltura - segAltura;
                    anos++;
                }
            }
            //Caso sejam do mesmo tamanho
        } else if (priAltura == segAltura) {
            if (priTaxaCresc == segTaxaCresc) {
                System.out.print("nunca");
                System.exit(0);
            } else {
                System.out.print("1");
                System.exit(0);
            }
            //Caso a segunda árvore seja maior
        } else if (segTaxaCresc >= priTaxaCresc) {
            System.out.print("nunca");
            System.exit(0);
        } else {
            difAltura = segAltura - priAltura;
            while (difAltura >= 0) {

                priAltura = priAltura + priTaxaCresc;
                segAltura = segAltura + segTaxaCresc;
                difAltura = segAltura - priAltura;
                anos++;
            }
        }
        System.out.print(anos);
    }
}
