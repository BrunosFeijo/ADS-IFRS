package EscalonamentoDeProcessos;

public class Processo implements Comparable<Processo>, Cloneable {

    private int tempoExecucao;
    private int tempoRestante;
    private int tempoChegada;
    private int prioridade;
    private int tempoEspera;

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

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int decrementarTempoRestante() {
        return --this.tempoRestante;
    }
    public void incrementaTempoEspera(){
        this.tempoEspera++;
    }

    @Override
    public int compareTo(Processo o) {
        return Integer.compare(this.prioridade, o.getPrioridade());
    }
    @Override
    protected Processo clone() throws CloneNotSupportedException {
        return new Processo(this.tempoExecucao, this.tempoChegada,this.prioridade);
    }
}
