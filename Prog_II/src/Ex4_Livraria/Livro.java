package Ex4_Livraria;

public class Livro {
    private String titulo;
    private int codigo;
    private String editora;
    private Categoria categoria;
    private int ano;
    private double valor;
    private int qtd;

    public Livro(String titulo, int codigo, String editora,
                 Categoria categoria, int ano, double valor, int qtd) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.editora = editora;
        this.categoria = categoria;
        this.ano = ano;
        this.valor = valor;
        this.qtd = qtd;
    }
}
