package Ex9_Livraria_v3;

import java.text.NumberFormat;
import java.util.Objects;

public class Livro {
    private String titulo;
    private int codigo;
    private String editora;
    private String categoria;
    private int ano;
    private double valor;
    private int qtd;

    public Livro(String titulo, int codigo, String editora,
                 String categoria, int ano, double valor, int qtd) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.editora = editora;
        this.categoria = categoria;
        this.ano = ano;
        this.valor = valor;
        this.qtd = qtd;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEditora() {
        return editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }

    public int getQtd() {
        return qtd;
    }

    public double getValorTotal() {

        return valor * qtd;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return getCodigo() == livro.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    public String toString() {
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance();
        return "Cod#" + codigo + "\n" +
                "Titulo/Editora: " + titulo + "/" + editora + "\n" +
                "Categoria: " + categoria + "\n" +
                "Ano: " + ano + "\n" +
                "Valor: R$ " + valor + "\n" +
                "Estoque: " + qtd + " unidades\n" +
                "Valor total em estoque: " + dinheiro.format(getValorTotal()) + "\n";
    }
}
