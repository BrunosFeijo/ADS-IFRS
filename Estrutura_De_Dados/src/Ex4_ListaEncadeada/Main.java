package Ex4_ListaEncadeada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Lista lista = null;
        int opcao = menuDeCriacao();
        switch (opcao) {
            case 1 -> {lista = new Lista();}
            case 2 -> {lista = new Fila();}
            case 3 -> {lista = new Pilha();}
            case 0 -> {System.exit(0);}
        }
        do {
            opcao = menu();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite um número inteiro");
                    opcao = entrada.nextInt();
                    lista.adicionar(opcao);
                    System.out.println("Valor " + opcao + " adicionado com sucesso!");
                }
                case 2 -> {
                }
                case 3 -> {
                    System.out.println("Valor do inicio: " + lista.espiarInicio());
                }
                case 4 -> {
                    System.out.println("Valor do fim: " + lista.espiarFim());
                }
                case 5 -> {
                    System.out.println("Tamanho: " + lista.getTamanho());
                }
                case 6 -> {
                    
                }
                case 0 -> {
                }
            }
        }while(opcao != 0);
        System.out.println("Programa encerrado");
    }

    public static int menuDeCriacao() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("---------------Menu---------------");
            System.out.println("1- Criar Lista");
            System.out.println("2- Criar Fila");
            System.out.println("3- Criar Pilha");
            System.out.println("0- Sair");
            System.out.println("----------------------------------");
            System.out.print("Digite uma opção: ");
            opcao = entrada.nextInt();

        } while (opcao < 0 || opcao > 3);
        return opcao;
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("---------------Menu---------------");
            System.out.println("1- Adicionar itens na lista");
            System.out.println("2- Remover itens da lista");
            System.out.println("3- Espiar inicio da lista");
            System.out.println("4- Espiar fim da lista");
            System.out.println("5- Tamanho da lista");
            System.out.println("6- Listar elementos");
            System.out.println("0- Sair");
            System.out.println("----------------------------------");
            System.out.print("Digite uma opção: ");
            opcao = entrada.nextInt();
        } while (opcao < 0 || opcao > 6);
        return opcao;
    }

    public static int menuRemoverItemLista() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("---------------Menu---------------");
            System.out.println("1- Remover por valor");
            System.out.println("2- Remover por índice");
            System.out.println("0- Sair");
            System.out.println("----------------------------------");
            System.out.print("Digite uma opção: ");
            opcao = entrada.nextInt();
        } while (opcao < 0 || opcao > 2);
        return opcao;
    }

    public static void opcao(int opcao) {

    }

    public static void testesManuais() {
        //Testes manuais
        System.out.println("---------------Lista---------------");
        Lista listaTeste = new Lista();
        listaTeste.adicionar(2);
        listaTeste.adicionar(5);
        listaTeste.adicionar(1);
        listaTeste.adicionar(3);
        listaTeste.adicionar(4);
        listaTeste.adicionar(-10);
        listaTeste.adicionar(100);
        listaTeste.adicionar(99);
        System.out.println(listaTeste); // ordenado
        System.out.println(listaTeste.getTamanho()); // 8
        System.out.println("Elemento do início da lista: " + listaTeste.espiarInicio());
        System.out.println("Elemento do fim da lista: " + listaTeste.espiarFim());

        listaTeste.removerPorValor(2);
        listaTeste.removerPorValor(5);
        listaTeste.removerPorValor(1);
        listaTeste.removerPorValor(3);
        listaTeste.removerPorValor(10); //não encontrado
        System.out.println("Valor " + listaTeste.removerPorIndice(2) + " removido");
        System.out.println("Valor " + listaTeste.removerPorIndice(1) + " removido");
        System.out.println("Valor " + listaTeste.removerPorIndice(0) + " removido");
        listaTeste.removerPorIndice(1); //índice inválido
        System.out.println("Valor " + listaTeste.removerPorIndice(0) + " removido");
        listaTeste.removerPorIndice(1); //Lista vazia
        System.out.println(listaTeste); // []
        System.out.println(listaTeste.getTamanho()); // 0

        System.out.println("---------------Fila---------------");
        Fila filaTeste = new Fila();

        filaTeste.adicionar(2);
        filaTeste.adicionar(5);
        filaTeste.adicionar(9);
        filaTeste.adicionar(4);
        filaTeste.adicionar(1);
        System.out.println(filaTeste);

        System.out.println("Valor " + filaTeste.remover() + " removido");
        System.out.println("Valor " + filaTeste.remover() + " removido");
        System.out.println("Valor " + filaTeste.remover() + " removido");
        System.out.println(filaTeste);
        System.out.println("Valor " + filaTeste.remover() + " removido");
        System.out.println("Valor " + filaTeste.remover() + " removido");
        filaTeste.remover();//Fila Vazia
        System.out.println(filaTeste);


        System.out.println("---------------Pilha---------------");

        Pilha pilhaTeste = new Pilha();

        pilhaTeste.adicionar(2);
        pilhaTeste.adicionar(5);
        pilhaTeste.adicionar(9);
        pilhaTeste.adicionar(4);
        pilhaTeste.adicionar(1);
        System.out.println(pilhaTeste);

        System.out.println("Valor " + pilhaTeste.remover() + " removido");
        System.out.println("Valor " + pilhaTeste.remover() + " removido");
        System.out.println("Valor " + pilhaTeste.remover() + " removido");
        System.out.println(pilhaTeste);
        System.out.println("Valor " + pilhaTeste.remover() + " removido");
        System.out.println("Valor " + pilhaTeste.remover() + " removido");
        pilhaTeste.remover();//Fila Vazia
        System.out.println(pilhaTeste);
    }
}
