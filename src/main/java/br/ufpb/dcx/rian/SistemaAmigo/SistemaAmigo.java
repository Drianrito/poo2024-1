package br.ufpb.dcx.rian.SistemaAmigo;

import java.util.*;

public class SistemaAmigo {

    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Amigo> amigos = new ArrayList<>();

    public void cadastrarAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo);
        amigos.add(novoAmigo);
    }
    public Amigo pesquisarAmigo(String amigoEmail){
        for(Amigo ami: amigos){
            if (amigoEmail.equals(ami.getEmail())){
                return ami;
            }
        }
        return null;
    }
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        // TODO
    }
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        //TODO
    }
    public List<Mensagem> pesquisarMensagemAnonima(){
        List<Mensagem> novalista = new ArrayList<>();
        for(Mensagem men: mensagens){
            if(men.ehAnonima()){
                novalista.add(men);
            }
        }
        return novalista;
    }
    public List<Mensagem> pesquisaTodasAsMensagens(){
        return mensagens;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa, String amigoSorteado)throws AmigoInexistenteException{
        try {
            //TODO
        }
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
        return null;
    }
}