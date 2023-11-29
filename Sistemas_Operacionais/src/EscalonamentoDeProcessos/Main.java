package EscalonamentoDeProcessos;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Escalonador escalonador = new Escalonador();

        escalonador.processosAleatorios();
        escalonador.processosAleatorios();
        escalonador.processosAleatorios();

        System.out.println(escalonador);

//        escalonador.FCFS();
//
//        escalonador.SJFPreemptivo();
//
//        escalonador.SJFNaoPreemptivo();

//        escalonador.PrioridadePreemptivo();

//        escalonador.PrioridadeNaoPreemptivo();


    }
}
