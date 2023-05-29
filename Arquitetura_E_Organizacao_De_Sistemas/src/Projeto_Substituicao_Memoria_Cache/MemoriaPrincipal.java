package Projeto_Substituicao_Memoria_Cache;

public class MemoriaPrincipal {
    private static final String caracteres = "ABCDEF";
    public MemoriaPrincipal() {
    }

    public static char getMemoriaPrincipal(int indice){
        return caracteres.charAt(indice);
    }

}
