package EscalonamentoDeProcessos;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Escalonador escalonador = new Escalonador();
        boolean continuar = true;
        escalonador.processosAleatorios();
        escalonador.processosAleatorios();
        escalonador.processosAleatorios();

        System.out.println(escalonador);
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
                case 7 -> System.out.println("Popular Escalonador");

                case 8 -> {
                    escalonador.clear();
                    System.out.println("Fila zerada.");
                }
                case 9 -> continuar = false;
            }
        }
    }

    public static int menu() {
        return 0;
    }

}
