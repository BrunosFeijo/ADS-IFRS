package Ex9_Livraria_v3;

import java.util.List;

public class Filial extends Livraria{
    private String codigo;
    private String nome;
    private String endereco;
    private String contato;

    public Filial(String codigo, String nome, String endereco, String contato) {
        super();
        this.codigo = "#FL" + codigo;
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

}
