package br.ufpb.dcx.rian.SistemaAmigo;

public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }
    public String getTextoCompleto(){
        if(ehAnonima()){
        return "Mensagem para todos "+getTexto();
        }else{
           return "Mensagem de" +getEmailRemetente() + "para todos." +  "\n Texto:" +getTexto();
        }
    }
}
