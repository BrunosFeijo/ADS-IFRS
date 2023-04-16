package Ex2_CriarClasses;

public class Empresa {
    String nome;
    String cnpj;
    String endereco;
    String servico;

    public Empresa(String nome, String cnpj, String endereco, String servico) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' + "\n" +
                "cnpj='" + cnpj + '\'' + "\n" +
                "endereco='" + endereco + '\'' + "\n" +
                "servico='" + servico + '\'' +
                '}';
    }
}
