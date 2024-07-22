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
        Mensagem novaMensagem = new MensagemParatodos(texto,emailRemetente,ehAnonima);
        mensagens.add(novaMensagem);
    }
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem novaMensagemAlguem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        mensagens.add(novaMensagemAlguem);
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
        Amigo amgSecreto = pesquisarAmigo(emailDaPessoa);
        if(amgSecreto == null){
            throw new AmigoInexistenteException("Amigo Nao existe");
        }else{
            amgSecreto.setAmigoSorteado(amigoSorteado);
        }
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo pesquisaSecreta = pesquisarAmigo(emailDaPessoa);
        if(pesquisaSecreta==null){
            throw new AmigoNaoSorteadoException("Voce nao foi sorteado");
        } else if (pesquisaSecreta.getEmailAmigoSorteado()==null) {
            throw new AmigoInexistenteException("Esse amigo nao existe");
        }else{
            return pesquisaSecreta.getEmailAmigoSorteado();
        }
    }
    public int sortear(){
        int posicaoDaListaSorteada = (int)(Math.random()*amigos.size());
        return posicaoDaListaSorteada;
    }
}