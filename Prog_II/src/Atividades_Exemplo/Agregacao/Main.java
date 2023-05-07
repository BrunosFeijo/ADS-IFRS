package Atividades_Exemplo.Agregacao;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua A", 123, "Bairro X", "Cidade Y");
        Pessoa pessoa = new Pessoa("Fulano", endereco);
        System.out.println(pessoa.getNome() + " mora na " + pessoa.getEndereco().getRua() + ", " + pessoa.getEndereco().getNumero());
    }
}
