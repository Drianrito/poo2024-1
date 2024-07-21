package br.ufpb.dcx.rian.SistemaAmigo;

import java.io.StringBufferInputStream;

public abstract class  Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoCompleto(){
        if (ehAnonima()){
            return "\n Texto:" +getTexto();
        }else{
            return "Mensagem de: " +getEmailRemetente() + "Texto: " + getTexto();
        }
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }


    public boolean ehAnonima(){
        if(this.anonima){
            return true;
        }else{
            return false;
        }
    }
}

