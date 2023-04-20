package Ex3_ListaDeUsuarios;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {

    private String nome;
    private int senha;
    private String email;
    private Date dataNascimento;

    public Usuario(String nome, int senha, String email, Date dataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public boolean setSenha(int senhaAntiga, int senhaNova) {
        if (validaSenha(senhaAntiga)){
            this.senha = senhaNova;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email, int senha) {
        if (validaSenha(senha)){
            this.email = email;
            return true;
        }
        return false;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean validaSenha(int senha){

        return this.senha == senha;
    }
    public boolean isMaiorDeIdade(){
        LocalDate hoje = LocalDate.now();

        return false;
    }


    @Override
    public String toString() {
        return "Usuario{\n" +
                "nome='" + nome + '\'' + "\n" +
                "senha=" + senha + "\n" +
                "email='" + email + '\'' + "\n" +
                "dataNascimento=" + dataNascimento +
                '}';
    }
}
