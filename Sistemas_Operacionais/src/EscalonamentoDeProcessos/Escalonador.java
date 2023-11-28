package EscalonamentoDeProcessos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Escalonador {
    private final List<Processo> processos;

    public Escalonador() {
        this.processos = new ArrayList<>();
    }

    public List<Processo> copiaProcessos() throws CloneNotSupportedException {
        List<Processo> listaProcessos = new ArrayList<>();
        for (Processo processo: processos             ) {
            listaProcessos.add(processo.clone());
        }

        return listaProcessos;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (int i = 0; i < processos.size(); i++) {
            stringBuilder.append("Processos[").append(i).append("]:")
                    .append(" tempo_execução= ").append(processos.get(i).getTempoExecucao())
                    .append(" tempo_restante= ").append(processos.get(i).getTempoRestante())
                    .append(" tempo_chegada= ").append(processos.get(i).getTempoChegada())
                    .append(" prioridade= ").append(processos.get(i).getPrioridade())
                    .append("\n");

        }
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }

    public void FCFS() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        int tempoExecucaoTotal = listaProcessos.stream().mapToInt(Processo::getTempoExecucao).sum();
        int indexProcesso = 0;

        for (int i = 1; i <= tempoExecucaoTotal; i++) {
            if (listaProcessos.get(indexProcesso).getTempoRestante() == 0) indexProcesso++;
            System.out.println("tempo[" + i + "]:" +
                    " processo[" + indexProcesso + "]" +
                    " restante[" + listaProcessos.get(indexProcesso).DecrementarTempoRestante() + "]");

        }
    }


    public void SJFPreemptivo() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        boolean tudoPronto = false;
        int tempoExecucaoTotal = 0;
        int i = 1;
        int menor = Integer.MAX_VALUE;
        int indexProcesso = -1;

        while (!tudoPronto) {
            for (int j = 0; j < listaProcessos.size(); j++) {
                //TODO Verificar chegada
                if (i >= listaProcessos.get(j).getTempoChegada()) {
                    //TODO Verificar tempo de execucao
                    if (listaProcessos.get(j).getTempoRestante() < menor
                            && listaProcessos.get(j).getTempoRestante() != 0) {
                        menor = listaProcessos.get(j).getTempoRestante();
                        indexProcesso = j;
                    }
                }
            }
            //TODO decrementar tempo restante
            if (indexProcesso == -1) {
                System.out.println("tempo[" + i + "]: " + "Nenhum processo na fila");
            } else {
                System.out.println("tempo[" + i + "]:" +
                        " processo[" + indexProcesso + "]" +
                        " restante[" + listaProcessos.get(indexProcesso).DecrementarTempoRestante() + "]");
            }

            //TODO Verificar se todos os processos ja finalizarar
            tempoExecucaoTotal = listaProcessos.stream().mapToInt(Processo::getTempoRestante).sum();
            if (tempoExecucaoTotal == 0) tudoPronto = true;


            i++;
            menor = Integer.MAX_VALUE;
            indexProcesso = -1;
        }
    }


}
