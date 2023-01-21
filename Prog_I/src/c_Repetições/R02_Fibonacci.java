package c_Repetições;

//A Série de Fibonacci é uma sequencia de valores onde cada elemento é o resultado da soma dos seus dois antecessores,
// considerando que os dois primeiros elementos são 0 e 1.
//Construa um programa que, a partir de uma estratégia que usa repetições,
// gere os primeiros dez elementos da Série de Fibonacci e apresenta uma mensagem informando o resultado

public class R02_Fibonacci {
    public static void main(String[] args) {
        int ultValor = 1;
        int penValor = 0;
        int soma = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print(soma + " ");

            penValor = ultValor;
            ultValor = soma;
            soma = ultValor + penValor;
        }

    }

}
