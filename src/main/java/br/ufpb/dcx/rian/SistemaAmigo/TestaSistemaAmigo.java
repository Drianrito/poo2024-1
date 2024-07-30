package br.ufpb.dcx.rian.SistemaAmigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistemaAmigo = new SistemaAmigo();
        List<Mensagem> exibirMensangens = new ArrayList<>();
        try{
        sistemaAmigo.cadastraAmigo("Jose","jose@dcx");
        sistemaAmigo.cadastraAmigo("Maria","maria@dcx");}
        catch (AmigoJaExisteException e){
            System.out.println("Falhou");
        }
        try {
            sistemaAmigo.configuraAmigoSecretoDe("jose@dcx","maria@dcx");
            sistemaAmigo.configuraAmigoSecretoDe("maria@dcx","jose@dcx");
        } catch (AmigoInexistenteException a) {
            System.out.println("Configuracao falhou");
        }
        sistemaAmigo.enviarMensagemParaAlguem("Oi","maria@dcx","jose@dcx",true);
        sistemaAmigo.enviarMensagemParaTodos("OI TODOS","maria@dcx",true);
        exibirMensangens = sistemaAmigo.pesquisaMensagensAnonimas();
        for(Mensagem men: exibirMensangens){
            System.out.println(men.getTextoCompleto());
        }
        try {
            if(sistemaAmigo.pesquisaAmigoSecretoDe("jose@dcx").equals("maria@dcx")){
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException a) {
            System.out.println("Amigo nao encontrado");
        } catch (AmigoNaoSorteadoException e) {
            System.out.println("Amigo nao sorteado");
        }
    }
}
