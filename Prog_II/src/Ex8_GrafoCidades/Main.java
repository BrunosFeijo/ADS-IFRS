package Ex8_GrafoCidades;

import Ex7_SistemaBancario.BancosDisponiveis;

import java.util.Scanner;

public class Main {
    static Grafo grafo = new Grafo();
    public static void main(String[] args) {
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {

                case 1 -> cadastrarCidade();
                case 2 -> cadastrarConexao();
                case 3 -> listarCidades();
                case 4 -> listarConexoes();
                case 5 -> listarVizinhanca();
                case 6 -> exemplos();
            }
        } while (opcao != 0);
        System.out.println("Fim do programa");

    }
    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        System.out.println("-----------------Menu-----------------");
        System.out.println("1 - Cadastrar Cidade");
        System.out.println("2 - Cadastrar Conexão");
        System.out.println("3 - Listar todas as cidades cadastratadas");
        System.out.println("4 - Listar todas as conexões");
        System.out.println("5 - Listar as conexões de uma cidade específica");
        System.out.println("6 - Instanciar exemplos prontos");
        System.out.println("0 - Sair");
        System.out.println("--------------------------------------");
        System.out.print("Digite uma opção: ");
        while (opcao < 0 || opcao > 6) {
            opcao = entrada.nextInt();
            if (opcao < 0 || opcao > 6) System.out.println("Opção inválida!");
        }
        return opcao;
    }
    public static void cadastrarCidade(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        boolean cadastrada = grafo.cadastraCidade(entrada.nextLine());
        if (cadastrada){
            System.out.println("Cidade cadastrada");
        }else{
            System.out.println("Registro duplicado! Cidade já cadastrada!");
        }
    }
    public static void cadastrarConexao(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome da primeira cidade: ");
        String cidade1 = entrada.nextLine();
        System.out.print("Digite o nome da segunda cidade: ");
        String cidade2 = entrada.nextLine();
        System.out.print("Digite a distância entre elas: ");
        int distancia = entrada.nextInt();

        grafo.cadastraConexao(cidade1,cidade2,distancia);
        System.out.println("Conexão cadastrada!");
    }
    public static void listarCidades(){
        grafo.infoCidades();
    }
    public static void listarConexoes(){
        grafo.infoConexoes();
    }
    public static void listarVizinhanca(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome da cidade para ver suas conexões: ");
        grafo.infoCidades(entrada.nextLine());
    }
    public static void exemplos(){
        grafo.cadastraConexao("Porto Alegre", "Canoas", 20);
        grafo.cadastraConexao("Porto Alegre", "Gramado", 117);
        grafo.cadastraConexao("Porto Alegre", "Pelotas", 262);
        grafo.cadastraConexao("Porto Alegre", "Santa Maria", 297);
        grafo.cadastraConexao("Canoas", "Novo Hamburgo", 16);
        grafo.cadastraConexao("Canoas", "São Leopoldo", 10);
        grafo.cadastraConexao("Canoas", "Gravataí", 27);
        grafo.cadastraConexao("Gramado", "Canela", 7 );
        grafo.cadastraConexao("Gramado", "Bento Gonçalves", 99);
        grafo.cadastraConexao("Pelotas", "Rio Grande", 52 );
        grafo.cadastraConexao("Pelotas", "Bagé", 118);
        grafo.cadastraConexao("Santa Maria", "Cachoeira do Sul", 136);
        grafo.cadastraConexao("Santa Maria", "São Gabriel", 184);
        grafo.cadastraConexao("Rio Grande", "São José do Norte", 36);
        grafo.cadastraConexao("Rio Grande", "Chuí", 291);
    }
}
