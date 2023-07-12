package Ex9_Livraria_v3;

import java.util.List;
import java.util.Objects;

public class Filial extends Livraria{
    private String codigo;
    private String nome;
    private String endereco;
    private String contato;

    public Filial(String codigo, String nome, String endereco, String contato) {
        super();
        this.codigo = codigo.contains("#FL") ? codigo : "#FL" + codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filial filial)) return false;
        return getCodigo().equals(filial.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }
    public String formatoEntreVirgulas() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(codigo).append(",")
                    .append(nome).append(",")
                    .append(endereco).append(",")
                    .append(contato).append("\n");

        for (Livro livro : livros) {
            stringBuilder.append(livro.getCodigo()).append(",")
                    .append(livro.getTitulo()).append(",")
                    .append(livro.getAno()).append(",")
                    .append(livro.getCategoria()).append(",")
                    .append(livro.getEditora()).append(",")
                    .append("R$").append(String.format("%.2f", livro.getValor()).replace(",", ".")).append(",")
                    .append(livro.getQtd()).append("\n");
        }
        return stringBuilder.toString();
    }
}
