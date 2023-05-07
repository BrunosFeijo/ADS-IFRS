package Atividades_Exemplo.Composicao;

public class Carro {
    private Motor motor;

    public Carro() {
        this.motor = new Motor(2.0, 4);
    }

    public void acelerar() {
        motor.injetarCombustivel();
        motor.girar();
    }
}
