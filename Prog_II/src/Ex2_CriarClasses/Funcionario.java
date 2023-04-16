package Ex2_CriarClasses;

public class Funcionario {
    String nome;
    String sobrenome;
    String cpf;
    double salario;
    String cargo;

    public Funcionario(String nome, String sobrenome, String cpf, double salario, String cargo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' + "\n" +
                "sobrenome='" + sobrenome + '\'' + "\n" +
                "cpf='" + cpf + '\'' + "\n" +
                "salario=" + salario + "\n" +
                "cargo='" + cargo + '\'' +
                '}';
    }
}
