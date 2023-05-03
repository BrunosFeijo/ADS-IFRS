package Ex4_Livraria;

public enum Categoria {
    FANTASIA(0), FICÇÃO_CIENTÍFICA(1), DISTOPIA(2), AÇÃO_E_AVENTURA(3), FICÇÃO_POLICIAL(4), HORROR(5),
    THRILLER_E_SUSPENSE(6), FICÇÃO_HISTÓRICA(7), ROMANCE(8), NOVELA(9), FICÇÃO_FEMININA(10), LGBTQIA(11),
    FICÇÃO_CONTEMPORÂNEA(12), REALISMO_MÁGICO(13), GRAPHIC_NOVEL(14), CONTO(15), JOVEM_ADULTO(16), INFANTIL(17),
    MEMÓRIAS_E_AUTOBIOGRAFIA(18), BIOGRAFIA(19), GASTRONOMIA(20), ARTE_E_FOTOGRAFIA(21), AUTOAJUDA(22), HISTÓRIA(23),
    VIAGEM(24), CRIMES_REAIS(25), HUMOR(26), ENSAIOS(27), GUIAS(28), RELIGIÃO_E_ESPIRITUALIDADE(29),
    HUMANIDADES_E_CIÊNCIAS_SOCIAIS(30), PATERNIDADE_E_FAMÍLIA(31), TECNOLOGIA_E_CIÊNCIA(32),CANCELAR(-1);

    private int id;
    Categoria(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
