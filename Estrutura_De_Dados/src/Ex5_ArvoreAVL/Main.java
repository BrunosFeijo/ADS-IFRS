package Ex5_ArvoreAVL;

//Construir um programa que implementa uma árvore binária balanceada ( AVL ) composto por :
//* No (ou Nodo ) : Elemento construtivo das estruturas de dados.
//Deve armazenar um valor inteiro e também referências (ponteiro / apontamento / endereço )
//para os dois "filhos" (é possível utilizar mais um apontamento para o "pai").

//* Métodos para inserir e remover nodos, calcular o balanceamento e corrigir balanceamento
//( rotações simples e duplas para esquerda e direita ).

//* O menu principal do programa deve apresentar opções para inserir e excluir elementos na árvore e
//mais uma opção para apresentar a árvore inteira (como estamos usando somente interface de texto,
//pode ser mais adequado usar a opção de visualização da esquerda para a direita, como uma árvore de pastas)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArvoreAVL lista = new ArvoreAVL();
        int opcao = -1;

        while(opcao != 0){
            opcao = menu();
            switch (opcao){
                case 1 -> {
                    System.out.print("Digite um valor: ");
                    if (lista.adicionar(entrada.nextInt())){
                        System.out.println("Adicionado com sucesso");
                    }else{
                        System.out.println("Valor já existe na árvore");
                    }
                }
                case 2 -> {
                    System.out.print("Digite um valor: ");
                    if (lista.remover(entrada.nextInt())){
                        System.out.println("Removido com sucesso");
                    }else{
                        System.out.println("Valor não encontrado");
                    }
                }
                case 3 -> {
                    System.out.print("Digite um valor para consultar:");
                    if (lista.contem(entrada.nextInt())){
                        System.out.println("Valor está na árvore");
                    }else{
                        System.out.println("Valor não consta na árvore");
                    }
                }
                case 4 ->{
                    lista.limparArvore();
                    System.out.println("Árvore vazia");
                }
                case 5 ->{
                    System.out.println(lista.imprimirEmOrdem(lista.getRaiz()));
                }
                case 6 ->{
                    System.out.println(lista.imprimirPosOrdem(lista.getRaiz()));
                }
                case 7->{
                    System.out.println(lista.imprimirPreOrdem(lista.getRaiz()));
                }
                case 8->{
                    System.out.println(lista);
                }
            }
        }
        System.out.println("Fim do programa");
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("--------------------Menu--------------------");
            System.out.println("1- Inserir valor");
            System.out.println("2- Excluir valor");
            System.out.println("3- Verificar se contém valor");
            System.out.println("4- Limpar Árvore");
            System.out.println("5- Listar Árvore em ordem");
            System.out.println("6- Listar Árvore em pós-ordem");
            System.out.println("7- Listar Árvore em pré-ordem");
            System.out.println("8- Listar Árvore em formato de pastas");
            System.out.println("0- Sair");
            System.out.println("--------------------------------------------");
            System.out.print("Digite a opção desejada: ");
            opcao = entrada.nextInt();
            if (opcao < 0 || opcao > 8) System.out.println("Opção Inválida!!");
        }while(opcao < 0 || opcao > 8);
        System.out.println();
        return opcao;
    }
}
