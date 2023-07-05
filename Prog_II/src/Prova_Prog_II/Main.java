package Prova_Prog_II;

public class Main {
    public static void main(String[] args) {
        Pessoa donaDoUno = new Pessoa("Mara Oliveira","51992539595");
        Carro uno = new Carro("Fiat Uno",2023,donaDoUno);
        Mecanico mecanico = new Mecanico("Seo Zé","51985865050","Geometria e Balanciamento");
        Servico servico = new Servico(123,mecanico,uno);

        //Infos iniciais
        donaDoUno.info();
        uno.info();
        mecanico.info();
        servico.info();

        //métodos
        donaDoUno.alteraContatos();
        uno.alteraObservacoes("Quase novo");
        mecanico.alteraEspecialidade();
        servico.atualizaServico();
        mecanico.listarServicos(); // este já é aplicado na info() do mecânico

        //infos finais
        donaDoUno.info();
        uno.info();
        mecanico.info();
        servico.info();

        //Atribuição de serviços do mecânico é feita no contrutor de Servico
        //Dessa forma, abaixo está apenas uma simulação manual, conforme solicitado em aula:
        mecanico.limparListaServicos();
        mecanico.atribuirServico(servico);

        mecanico.info();

        //Atribuir mais um serviço criando novo objeto Servico
        Servico servico2 = new Servico(321,mecanico,uno);

        servico2.atualizaServico();
        mecanico.info();

    }

}
