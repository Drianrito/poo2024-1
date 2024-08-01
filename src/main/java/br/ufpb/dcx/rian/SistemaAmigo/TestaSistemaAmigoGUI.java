package br.ufpb.dcx.rian.SistemaAmigo;

import br.ufpb.dcx.rian.SistemaAmigo.Exception.AmigoJaExisteException;

import javax.swing.*;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        int quantAmigos = Integer.parseInt(JOptionPane.showInputDialog("Quantos jogadores ? "));
        for (int k=1;k<quantAmigos;k++){
            String nome = JOptionPane.showInputDialog("Nome do jogador : ");
            String email = JOptionPane.showInputDialog("Email do jogador: ");
            try {
                sistema.cadastraAmigo(nome,email);
            } catch (AmigoJaExisteException e) {
                throw new RuntimeException(e);
            }

        }
        
    }
}
