package br.ufpb.dcx.rian.SistemaAmigo;

import javax.swing.*;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        int quantAmigos = Integer.parseInt(JOptionPane.showInputDialog("Quantos jogadores ? "));
        for (int k=1;k<quantAmigos;k++){
            String nome = JOptionPane.showInputDialog("Nome do jogador : ");
            String email = JOptionPane.showInputDialog("Email do jogador: ");
            sistema.cadastrarAmigo(nome,email);

        }
    }
}
