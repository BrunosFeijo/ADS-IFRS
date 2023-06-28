package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Clubes {
    private int id;
    private String sigla;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void inserir(){
        Connection conexao = DriverManager.getConnection();

        insert into clubes (sigla, nome) values ('GRE','Grêmio');
    }
}

