package EscalonamentoDeProcessos;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Escalonador escalonador = new Escalonador();

        escalonador.processosAleatorios();
        escalonador.processosAleatorios();
        escalonador.processosAleatorios();

        System.out.println(escalonador);

        escalonador.FCFS();
        System.out.println();

        escalonador.SJFPreemptivo();
    }
}
