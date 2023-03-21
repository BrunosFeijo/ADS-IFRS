package Ex1_RevisaoMenu;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Aluno alunos = new Aluno();
        int op = -1;
        double nota;
        int matricula;
        String nome;

        while (op != 0) {
            menu();
            op = entrada.nextInt();

            switch (op){
                case 1:
                    System.out.println("Digite o nome do aluno:");
                    entrada.nextLine();
                    nome = entrada.nextLine();
                    System.out.println("Digite a nota: ");
                    nota = entrada.nextDouble();

                    alunos.cadastro(nome,nota);
                    break;
                case 2:
                    System.out.println("Informações: ------------------");
                    alunos.informacoes();
                    break;
                case 3:
                    System.out.println("Digite a nota: ");
                    nota = entrada.nextDouble();
                    System.out.println("Digite a Matricula: ");
                    matricula = entrada.nextInt();
                    alunos.modificarNota(nota, matricula);
                    break;
                case 4:
                    alunos.media();
                    break;
            }
        }
    }
    public static void menu(){
        System.out.println("-------------Menu-------------");
        System.out.println("F.1 - Cadastro de Alunos");
        System.out.println("F.2 - Informações de Alunos");
        System.out.println("F.3 - Modificar nota");
        System.out.println("F.4 - Média de notas ");
        System.out.println("F.0 - Sair: sair do sistema");
        System.out.println("------------------------------");
    }
}
