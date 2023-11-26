package EscalonamentoDeProcessos;

public class Processo implements Comparable<Processo> {
    private int tempoExecucao;
    private int tempoRestante;
    private int tempoChegada;
    private int prioridade;
    private int tempoEspera;
    private boolean preemptivo;

    public Processo(int tempoExecucao,int tempoChegada, int prioridade) {
        this.tempoExecucao = tempoExecucao;
        this.tempoRestante = tempoExecucao;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
        this.tempoEspera = 0;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }


    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int DecrementarTempoRestante() {
        return --this.tempoRestante;
    }

    @Override
    public int compareTo(Processo o) {
        return Integer.compare(this.prioridade, o.getPrioridade());
    }
}
