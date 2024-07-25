package br.ufpb.dcx.rian.Artesanato;

import javax.swing.*;
import java.util.List;

public class ProgramaArtesanatoRioTinto {
    public static void main(String[] args) {
        SistemaFeiraArtesanato sistema = new SistemaFeiraDeArtesanato();
        boolean continuar = true;
        while(continuar){
            String opcao = JOptionPane.showInputDialog("Digite uma opção \n 1.Cadastrar Item \n 2.Pesquisar item pelo nome \n 3.Pesquisar Item Pelo codigo\n 4.Sair ");
            if(opcao.equals("1")){
                //Cadastrar
                String tipoItem = JOptionPane.showInputDialog("QUAL O TIPO DE ITEM \n 1.Roupa \n 2.Estatua");
                if(tipoItem.equals("1")){
                    Roupa item = new Roupa();
                    item.setCodigo(JOptionPane.showInputDialog("Digite o codigo")) ;
                    item.setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
                    item.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço: ")));
                    String tamanho = JOptionPane.showInputDialog("Qual tamanho da roupa");
                    item.setTamanho(tamanho);
                    try {
                        sistema.cadastraItem(item);
                        JOptionPane.showMessageDialog(null,"Item cadastrado com sucesso: "+ item.toString());

                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                        e.printStackTrace();
                    }
                }if (tipoItem.equals("2")){
                ItemDeArtesanato item = new ItemDeArtesanato();
                item.setCodigo(JOptionPane.showInputDialog("Digite o codigo")) ;
                item.setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
                item.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço: ")));
                try {
                    sistema.cadastraItem(item);
                    JOptionPane.showMessageDialog(null,"Item cadastrado com sucesso: "+ item.toString());

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                    e.printStackTrace();
                }}

            } else if (opcao.equals("2")) {
                String nomeDoItem = JOptionPane.showInputDialog("Digite o nome do item a pesqiosar");
                List<ItemDeArtesanato> itensporNome = sistema.pesquisaItensPeloNome(nomeDoItem);
                if(itensporNome.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nao existe nenhum item com esse nome");
                }else{
                    JOptionPane.showMessageDialog(null,"Itens achados");
                    for(ItemDeArtesanato it: itensporNome){
                        JOptionPane.showMessageDialog(null,it.toString());
                    }
                }
            }else if(opcao.equals("3")){
                String codigoPesq = JOptionPane.showInputDialog("Digite o Codigo");
                try {
                    ItemDeArtesanato itemDeArtesanatoAchado = sistema.pesqusiaItemPeloCodigo(codigoPesq);
                    JOptionPane.showMessageDialog(null,"Item achado: "+ itemDeArtesanatoAchado.toString());
                }catch (ItemInexistenteException e){
                    JOptionPane.showMessageDialog(null,"Não foi encontrado item com o codigo: "+codigoPesq);
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }

            } else if (opcao.equals("4")) {
                continuar= false;
            }

        }
    }
}
