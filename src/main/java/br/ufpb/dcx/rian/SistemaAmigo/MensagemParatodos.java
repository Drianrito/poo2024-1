package br.ufpb.dcx.rian.SistemaAmigo;

public class MensagemParatodos extends Mensagem {
    public MensagemParatodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }
    public String getTextoCompleto(){
        if(ehAnonima()){
        return "Mensagem para todos."+getTexto();
        }else{
           return "Mensagem de" +getEmailRemetente() + "para todos." +  "\n Texto:" +getTexto();
        }
    }
}
