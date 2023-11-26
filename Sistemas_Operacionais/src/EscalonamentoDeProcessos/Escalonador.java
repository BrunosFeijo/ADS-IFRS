package EscalonamentoDeProcessos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Escalonador {
    private List<Processo> processos;

    public Escalonador() {
        this.processos = new ArrayList<>();
    }

    public void processosAleatorios() {
        Random random = new Random();

        adicionarProcesso(
                random.nextInt(10) + 1,
                random.nextInt(10) + 1,
                random.nextInt(20) + 1
        );
    }

    public void processosDefinidosUsuario() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o Tempo de Execução do Processo: ");
        int tempoExecucao = entrada.nextInt();

        System.out.print("Digite o Tempo de Chegada do Processo: ");
        int tempoChegada = entrada.nextInt();

        System.out.print("Digite a Prioridade do Processo: ");
        int prioridade = entrada.nextInt();

        adicionarProcesso(tempoExecucao, tempoChegada, prioridade);
    }

    private void adicionarProcesso(int tempoExecucao, int tempoChegada, int prioridade) {
        this.processos.add(new Processo(tempoExecucao, tempoChegada, prioridade));
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (int i = 0; i < processos.size();i++ ){
            stringBuilder.append("Processos[").append(i).append("]:")
                    .append(" tempo_execução= ").append(processos.get(i).getTempoExecucao())
                    .append(" tempo_restante= ").append(processos.get(i).getTempoRestante())
                    .append(" tempo_chegada= ").append(processos.get(i).getTempoChegada())
                    .append(" prioridade= ").append(processos.get(i).getPrioridade())
                    .append("\n");

        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }


}
