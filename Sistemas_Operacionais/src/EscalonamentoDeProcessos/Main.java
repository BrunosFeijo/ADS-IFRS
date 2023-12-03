package EscalonamentoDeProcessos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Escalonador escalonador = new Escalonador();
        boolean continuar = true;

        while (continuar) {
            switch (menu()) {
                case 1 -> {
                    if (!escalonador.isEmpty()) {
                        escalonador.FCFS();
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
                case 2 -> {
                    if (!escalonador.isEmpty()) {
                        escalonador.SJFPreemptivo();
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
                case 3 -> {
                    if (!escalonador.isEmpty()) {
                        escalonador.SJFNaoPreemptivo();
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
                case 4 -> {
                    if (!escalonador.isEmpty()) {
                        escalonador.PrioridadePreemptivo();
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
                case 5 -> {
                    if (!escalonador.isEmpty()) {
                        escalonador.PrioridadeNaoPreemptivo();
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
                case 6 -> {
                    if (!escalonador.isEmpty()) {
                        escalonador.RoundRobin();
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
                case 7 -> {
                    escalonador.popularFilaDeProcessos();
                    System.out.println(escalonador);
                }
                case 8 -> {
                    escalonador.clear();
                    System.out.println("Fila vazia");
                }
                case 9 -> continuar = false;
            }
        }
        System.out.println("Fim do Programa!");
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n-------Menu-------");
        System.out.println("1- FCFS");
        System.out.println("2- SJF Preemptivo");
        System.out.println("3- SJF Não Preemptivo");
        System.out.println("4- Prioridade Preemptivo");
        System.out.println("5- Prioridade Não Preemptivo");
        System.out.println("6- Round Robin");
        System.out.println("7- Popular processos");
        System.out.println("8- Limpar processos");
        System.out.println("9- Sair");
        System.out.println("------------------");
        System.out.print("Escolha uma opção: ");
        return entrada.nextInt();
    }

}
