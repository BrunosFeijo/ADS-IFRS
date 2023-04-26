package Ex3_ListaDeUsuarios;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {

    private final String nome;
    private String senha;
    private String email;
    private final Date dataNascimento;


    public Usuario(String nome, String senha, String email, Date dataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public boolean setSenha(String senhaAntiga, String senhaNova) {
        if (validaSenha(senhaAntiga)) {
            this.senha.equals(senhaNova) ;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email, String senha) {
        if (validaSenha(senha)) {
            this.email = email;
            return true;
        }
        return false;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    /*
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    */

    public boolean validaSenha(String senha) {

        return this.senha.equals(senha) ;
    }

    public boolean isMaiorDeIdade() {

        return idade() >= 18;
    }

    public int idade() {
        Date hoje = new Date();

        if (hoje.getMonth() > dataNascimento.getMonth()) {
            return (1900 + hoje.getYear()) - dataNascimento.getYear();
        } else if (hoje.getMonth() == dataNascimento.getMonth()) {
            if (hoje.getDate() >= dataNascimento.getDate()) {
                return (1900 + hoje.getYear()) - dataNascimento.getYear();
            } else {
                return (1900 + hoje.getYear()) - dataNascimento.getYear() - 1;
            }
        }
        return (1900 + hoje.getYear()) - dataNascimento.getYear() - 1;
    }
    @Override
    public String toString() {
        return "Usuario{\n" +
                "nome=' " + nome + '\'' + "\n" +
                "senha= " + senha + "\n" +
                "email=' " + email + '\'' + "\n" +
                "dataNascimento= " + dataNascimento.getDate() + "/" + dataNascimento.getMonth() + "/" + dataNascimento.getYear() +
                '}';
    }
}
