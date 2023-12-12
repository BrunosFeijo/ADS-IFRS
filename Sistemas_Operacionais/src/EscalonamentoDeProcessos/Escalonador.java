package EscalonamentoDeProcessos;

import java.util.*;

public class Escalonador {
    private final List<Processo> processos;

    public Escalonador() {
        this.processos = new ArrayList<>();
    }

    public List<Processo> copiaProcessos() throws CloneNotSupportedException {
        List<Processo> listaProcessos = new ArrayList<>();
        for (Processo processo : processos) {
            listaProcessos.add(processo.clone());
        }

        return listaProcessos;
    }

    public void popularFilaDeProcessos() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Quantos processos deseja adicionar a fila? ");
        int qtd = entrada.nextInt();
        boolean continuar = true;
        String opcao;

        while (continuar) {
            System.out.println("Deseja popular a fila aleatoriamente? (y/n)");
            opcao = entrada.next();
            if (opcao.equals("y")) {
                for (int i = 0; i < qtd; i++) {
                    processosAleatorios();
                }
                continuar = false;
            } else if (opcao.equals("n")) {
                for (int i = 0; i < qtd; i++) {
                    processosDefinidosUsuario();
                }
                continuar = false;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private void processosAleatorios() {
        Random random = new Random();

        adicionarProcesso(
                random.nextInt(10) + 1,
                random.nextInt(10) + 1,
                random.nextInt(20) + 1
        );
    }

    private void processosDefinidosUsuario() {
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

    public boolean isEmpty() {
        return processos.isEmpty();
    }

    public void clear() {
        processos.clear();
    }

    public void FCFS() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        int tempoExecucaoTotal = listaProcessos.stream().mapToInt(Processo::getTempoExecucao).sum();
        int indexProcesso = 0;

        for (int i = 1; i <= tempoExecucaoTotal; i++) {
            if (listaProcessos.get(indexProcesso).getTempoRestante() == 0) indexProcesso++;
            System.out.println("tempo[" + i + "]:" +
                    " processo[" + indexProcesso + "]" +
                    " restante[" + listaProcessos.get(indexProcesso).decrementarTempoRestante() + "]");

        }
        System.out.println(); //pular linha

        tempoDeEsperaFCFS();
    }

    private void tempoDeEsperaFCFS() {
        double media = 0;
        int espera = 0;
        System.out.println("processo[0]: tempo_espera: 0");
        for (int i = 1; i < processos.size(); i++) {
            espera += processos.get(i - 1).getTempoExecucao();
            processos.get(i).setTempoEspera(espera);
            System.out.println("processo[" + i + "]: tempo_espera: " + espera);
        }
        media = espera / (double) processos.size();

        System.out.println("Tempo_espera médio: " + media);
    }

    public void SJFPreemptivo() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        boolean tudoPronto = false;
        int tempoRestanteTotal = 0;
        int i = 1;
        int menor = Integer.MAX_VALUE;
        int indexProcesso = -1;

        while (!tudoPronto) {
            for (int j = 0; j < listaProcessos.size(); j++) {
                if (i >= listaProcessos.get(j).getTempoChegada()) {
                    if (listaProcessos.get(j).getTempoRestante() < menor
                            && listaProcessos.get(j).getTempoRestante() != 0) {
                        menor = listaProcessos.get(j).getTempoRestante();
                        indexProcesso = j;
                    }
                }
            }
            if (indexProcesso == -1) {
                System.out.println("tempo[" + i + "]: " + "Nenhum processo está pronto");
            } else {
                System.out.println("tempo[" + i + "]:" +
                        " processo[" + indexProcesso + "]" +
                        " restante[" + listaProcessos.get(indexProcesso).decrementarTempoRestante() + "]");
            }

            tempoRestanteTotal = listaProcessos.stream().mapToInt(Processo::getTempoRestante).sum();
            if (tempoRestanteTotal == 0) tudoPronto = true;


            i++;
            menor = Integer.MAX_VALUE;
            indexProcesso = -1;
        }
        imprimirTempoEspera(listaProcessos);
    }

    public void SJFNaoPreemptivo() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        boolean tudoPronto = false;
        int tempoRestanteTotal = 0;
        int i = 1;
        int menor = Integer.MAX_VALUE;
        int indexProcesso = -1;

        while (!tudoPronto) {
            for (int j = 0; j < listaProcessos.size(); j++) {
                if (i >= listaProcessos.get(j).getTempoChegada()) {
                    if (listaProcessos.get(j).getTempoRestante() < menor
                            && listaProcessos.get(j).getTempoRestante() != 0) {
                        menor = listaProcessos.get(j).getTempoRestante();
                        indexProcesso = j;
                    }
                }
            }
            if (indexProcesso == -1) {
                System.out.println("tempo[" + i++ + "]: " + "Nenhum processo está pronto");
            } else {
                while (listaProcessos.get(indexProcesso).getTempoRestante() != 0) {
                    System.out.println("tempo[" + i++ + "]:" +
                            " processo[" + indexProcesso + "]" +
                            " restante[" + listaProcessos.get(indexProcesso).decrementarTempoRestante() + "]");
                }
            }

            tempoRestanteTotal = listaProcessos.stream().mapToInt(Processo::getTempoRestante).sum();
            if (tempoRestanteTotal == 0) tudoPronto = true;

            menor = Integer.MAX_VALUE;
            indexProcesso = -1;
        }
        imprimirTempoEspera(listaProcessos);
    }

    public void PrioridadePreemptivo() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        boolean tudoPronto = false;
        int tempoRestanteTotal = 0;
        int i = 1;
        int maior = Integer.MIN_VALUE;
        int indexProcesso = -1;

        while (!tudoPronto) {
            for (int j = 0; j < listaProcessos.size(); j++) {
                if (i >= listaProcessos.get(j).getTempoChegada()) {
                    if (listaProcessos.get(j).getPrioridade() > maior
                            && listaProcessos.get(j).getTempoRestante() != 0) {
                        maior = listaProcessos.get(j).getPrioridade();
                        indexProcesso = j;
                    }
                }
            }
            if (indexProcesso == -1) {
                System.out.println("tempo[" + i + "]: " + "Nenhum processo está pronto");
            } else {
                System.out.println("tempo[" + i + "]:" +
                        " processo[" + indexProcesso + "]" +
                        " restante[" + listaProcessos.get(indexProcesso).decrementarTempoRestante() + "]");
            }

            tempoRestanteTotal = listaProcessos.stream().mapToInt(Processo::getTempoRestante).sum();
            if (tempoRestanteTotal == 0) tudoPronto = true;

            i++;
            maior = Integer.MIN_VALUE;
            indexProcesso = -1;
        }
        imprimirTempoEspera(listaProcessos);
    }

    public void PrioridadeNaoPreemptivo() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        boolean tudoPronto = false;
        int tempoRestanteTotal = 0;
        int i = 1;
        int maior = Integer.MIN_VALUE;
        int indexProcesso = -1;

        while (!tudoPronto) {
            for (int j = 0; j < listaProcessos.size(); j++) {
                if (i >= listaProcessos.get(j).getTempoChegada()) {
                    if (listaProcessos.get(j).getPrioridade() > maior
                            && listaProcessos.get(j).getTempoRestante() != 0) {
                        maior = listaProcessos.get(j).getPrioridade();
                        indexProcesso = j;
                    }
                }
            }
            if (indexProcesso == -1) {
                System.out.println("tempo[" + i++ + "]: " + "Nenhum processo está pronto");
            } else {
                while (listaProcessos.get(indexProcesso).getTempoRestante() != 0) {
                    System.out.println("tempo[" + i++ + "]:" +
                            " processo[" + indexProcesso + "]" +
                            " restante[" + listaProcessos.get(indexProcesso).decrementarTempoRestante() + "]");
                }
            }

            tempoRestanteTotal = listaProcessos.stream().mapToInt(Processo::getTempoRestante).sum();
            if (tempoRestanteTotal == 0) tudoPronto = true;

            maior = Integer.MIN_VALUE;
            indexProcesso = -1;
        }
        imprimirTempoEspera(listaProcessos);
    }

    public void RoundRobin() throws CloneNotSupportedException {
        List<Processo> listaProcessos = copiaProcessos();
        Scanner entrada = new Scanner(System.in);

        int tempoRestanteTotal = listaProcessos.stream().mapToInt(Processo::getTempoExecucao).sum();
        int indexProcesso = 0;
        int i = 1;

        System.out.print("Digite o time slice: ");
        int timeSlice = entrada.nextInt();

        while (tempoRestanteTotal != 0) {
            if (listaProcessos.get(indexProcesso).getTempoRestante() != 0) {
                for (int j = 0; j < timeSlice; j++) {
                    if (listaProcessos.get(indexProcesso).getTempoRestante() == 0) break;

                    System.out.println("tempo[" + i++ + "]:" +
                            " processo[" + indexProcesso + "]" +
                            " restante[" + listaProcessos.get(indexProcesso).decrementarTempoRestante() + "]");
                }
            }

            if (indexProcesso == (listaProcessos.size() - 1)) {
                indexProcesso = 0;
            } else {
                indexProcesso++;
            }
            tempoRestanteTotal = listaProcessos.stream().mapToInt(Processo::getTempoRestante).sum();
        }
        imprimirTempoEspera(listaProcessos);
    }

    private void tempoDeEspera(List<Processo> processoList, int tempoAtual, int indexProcessoAtual) {
        boolean chegou;
        boolean terminado;
        boolean processoAtual;
        for (int i = 0; i < processoList.size(); i++) {
            chegou = processoList.get(i).getTempoChegada() <= tempoAtual;
            terminado = processoList.get(i).getTempoRestante() == 0;
            processoAtual = i == indexProcessoAtual;

            if (chegou && !terminado && !processoAtual) {
                processoList.get(i).incrementaTempoEspera();
            }
        }
    }

    private void imprimirTempoEspera(List<Processo> listaProcessos) {
        double soma = 0;
        int tempoEspera;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < listaProcessos.size(); i++) {
            tempoEspera = listaProcessos.get(i).getTempoEspera();
            stringBuilder.append("Processo[")
                    .append(i)
                    .append("]: tempo_espera = ")
                    .append(tempoEspera)
                    .append("\n");

            soma += tempoEspera;
        }
        stringBuilder.append("Tempo médio de espera: ").
                append(soma/listaProcessos.size()).
                append("\n");

        System.out.println(stringBuilder);
    }
}

