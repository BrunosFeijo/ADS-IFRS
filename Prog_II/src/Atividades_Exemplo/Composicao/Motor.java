package Atividades_Exemplo.Composicao;

public class Motor {
    private double capacidade;
    private int cilindros;

    public Motor(double capacidade, int cilindros) {
        this.capacidade = capacidade;
        this.cilindros = cilindros;
    }

    public void injetarCombustivel() {
        System.out.println("Injetando combustível...");
    }

    public void girar() {
        System.out.println("Motor girando...");
    }
}
