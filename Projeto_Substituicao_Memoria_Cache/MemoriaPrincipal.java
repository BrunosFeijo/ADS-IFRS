package Projeto_Substituicao_Memoria_Cache;

public class MemoriaPrincipal {
    private static final String caracteres = "ABCDEF";
    public MemoriaPrincipal() {
    }
    //Simular requisicao para memória pricipal
    public static char getMemoriaPrincipal(char requisicao){
        for (int i = 0; i < caracteres.length();i++){
            if (requisicao == caracteres.charAt(i)){
                return caracteres.charAt(i);
            }
        }
        return '\0';
    }


}
