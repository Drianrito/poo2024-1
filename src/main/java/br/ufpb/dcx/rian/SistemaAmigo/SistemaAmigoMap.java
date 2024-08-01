package br.ufpb.dcx.rian.SistemaAmigo;


import br.ufpb.dcx.rian.SistemaAmigo.Exception.AmigoInexistenteException;
import br.ufpb.dcx.rian.SistemaAmigo.Exception.AmigoJaExisteException;
import br.ufpb.dcx.rian.SistemaAmigo.Exception.AmigoNaoSorteadoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap{
    private List<Mensagem> mensagens;
    private Map<String,Amigo> amigos;


    public SistemaAmigoMap(){
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nome, String email)throws AmigoJaExisteException {
        if(this.amigos.containsKey(email)){
            throw new AmigoJaExisteException("Esse amigo ja cadastrado");
        }else{
            Amigo novoAmigo =new Amigo (nome,email);
            this.amigos.put(email,novoAmigo);
        }
    }

    public Amigo pesquisaAmigo(String amigoEmail)throws AmigoInexistenteException {
        Amigo amigoEncontrado = null;
        for(Amigo ami: this.amigos.values())
            if (amigoEmail.equals(ami.getEmail())){
                amigoEncontrado = ami;
            }

        if(amigoEncontrado ==null){
            throw new AmigoInexistenteException("Nenhum Amigo encontrado");
        }
        return amigoEncontrado;
    }
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem novaMensagem = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
        mensagens.add(novaMensagem);
    }
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem novaMensagemAlguem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        mensagens.add(novaMensagemAlguem);
    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
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
        Amigo amgSecreto = pesquisaAmigo(emailDaPessoa);
        if(amgSecreto == null){
            throw new AmigoInexistenteException("Amigo Nao existe");
        }else{
            amgSecreto.setAmigoSorteado(amigoSorteado);
        }
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo pesquisaSecreta = pesquisaAmigo(emailDaPessoa);
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