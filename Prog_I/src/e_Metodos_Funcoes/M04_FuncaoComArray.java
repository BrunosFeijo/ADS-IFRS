package e_Metodos_Funcoes;

//Crie uma interação com o usuário incluindo e excluindo valores em um vetor (use metodos)

import java.util.Scanner;

public class M04_FuncaoComArray {

    public static int maior(int vet[]) {
        int maior = 0, i = 0;
        for (; maior == 0; i++) {
            if (vet[i] != 0) {
                maior = vet[i];
            }
        }
        for (; i < vet.length; i++) {
            if (vet[i] > maior && vet[i] != 0) {
                maior = vet[i];
            }
        }
        return maior;
    }

    public static int menor(int vet[]) {
        int menor = 0, i = 0;
        for (; menor == 0; i++) {
            if (vet[1] != 0) {
                menor = vet[i];
            }
        }
        for (; i < vet.length; i++) {
            if (vet[i] < menor && vet[i] != 0) {
                menor = vet[i];
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tam = 10; // quantidade de elementos de um vetor
        int vetor[] = new int[tam];
        int quantos = 0; //total de valores armazenados no vetor
        int numero, posicao;
        int op = 1; //uso exclusivo no menu
        while (op != 0) {
            System.out.println("\n \nAplicação com vetores \n");
            System.out.println(" \n Menu de opções");
            System.out.println("   1 - inserir valor no vetor");
            System.out.println("   2 - apagar um valor no vetor");
            System.out.println("   3 - consultar um valor no vetor");
            System.out.println("   4 - informar quantos valores estão no vetor");
            System.out.println("   5 - informar maior e menor valores no vetor");
            System.out.println("   9 - listar vetor");
            System.out.println("   0 - para sair");

            op = teclado.nextInt();
            if (op == 1) {
                if (quantos < tam) {
                    System.out.println("Digite o valor a ser incluído (valor inteiro e positivo):");
                    numero = teclado.nextInt();
                    for (int i = 0; i < tam; i++) {
                        if (vetor[i] == 0) {
                            vetor[i] = numero;
                            i = tam;
                        }
                    }
                    quantos++;
                } else {
                    System.out.println("Vetor sem espaço para novos valores");
                }
            }
            if (op == 2) {
                System.out.println("Digite a posição a ser excluída (valor inteiro e positivo):");
                posicao = teclado.nextInt();
                if (posicao < tam && posicao >= 0) {
                    if (vetor[posicao] != 0) {
                        vetor[posicao] = 0;
                        quantos--;
                    } else {
                        System.out.println("Posição vazia!");
                    }
                } else {
                    System.out.println("Posição inexistente");
                }
            }
            if (op == 3) {
                System.out.println("Digite o valor a ser consultado (valor inteiro e positivo):");
                numero = teclado.nextInt();
                posicao = tam;
                for (int i = 0; i < tam; i++) {
                    if (vetor[i] == numero){
                        posicao = i;
                    }
                }
                if (posicao < tam) {
                    System.out.println("O valor " + numero + " está na posição " + posicao);
                } else {
                    System.out.println("Valor não encontrado!");
                }
            }
            if (op == 4) {
                System.out.println("Existem " + quantos + " valores armazenados no vetor");
            }
            if (op == 5) {
                if (quantos > 0) {
                    System.out.println("O maior valor é " + maior(vetor) + " e o menor valor é " + menor(vetor));
                } else {
                    System.out.println("O vetor está vazio");
                }
            }
            if (op == 9) {
                for (int i = 0; i < tam; i++) {
                    System.out.println("vetor[ " + i + " ] => " + vetor[i]);
                }
            }

        }
        teclado.close();

    }
}
