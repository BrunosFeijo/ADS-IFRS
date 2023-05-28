package Projeto_Substituicao_Memoria_Cache;

public class MemoriaPrincipal {
    private final String caracteres = "ABCDEF";
    public MemoriaPrincipal() {
    }

    public char get(int indice){
        return caracteres.charAt(indice);
    }

}
