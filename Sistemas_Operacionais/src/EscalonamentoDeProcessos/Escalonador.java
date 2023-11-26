package EscalonamentoDeProcessos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Escalonador {
    private List<Processo> processos;

    public Escalonador(List<Processo> processos) {
        this.processos = new ArrayList<>();
    }

    public void processosAleatorios() {
        Random random = new Random();

        adicionarProcesso(random.nextInt(9) + 1, random.nextInt(20) + 1);
    }

    public void processosDefinidosUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o Tempo de Execução do Processo: ");
        int tempoExecucao = entrada.nextInt();
        System.out.print("Digite a Prioridade do Processo: ");
        int prioridade = entrada.nextInt();

        adicionarProcesso(tempoExecucao, prioridade);
    }

    private void adicionarProcesso(int tempoExecucao, int prioridade) {
        this.processos.add(new Processo(tempoExecucao, prioridade));
    }
    
}
