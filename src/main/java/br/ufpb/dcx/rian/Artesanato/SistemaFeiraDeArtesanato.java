package br.ufpb.dcx.rian.Artesanato;

import java.util.*;

public class SistemaFeiraDeArtesanato implements SistemaFeiraArtesanato {
    private Map<String,ItemDeArtesanato> ItensDeArtesanato;
    public static final String  PREFIXO_CODIGO= "COD";

    public SistemaFeiraDeArtesanato(){
        this.ItensDeArtesanato=new HashMap<>();
    }

    @Override
    public void cadastraItem(ItemDeArtesanato item)throws CodigoInvallidoException,ItemJaExisteException {
        if(this.ItensDeArtesanato.containsKey(item.getCodigo())){
            throw new ItemJaExisteException("Ja existe item com o codigo: "+ item.getCodigo());
        }else{
            if(item.getCodigo().startsWith(PREFIXO_CODIGO)){
                this.ItensDeArtesanato.put(item.getCodigo(),item);
            }else{
                throw new CodigoInvallidoException("Codigo Invalido, digite novamente");
            }
        }
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome) {
        List<ItemDeArtesanato> itensPesquisadosPeloNome = new LinkedList<>();
        for(ItemDeArtesanato item: this.ItensDeArtesanato.values()){
            if(item.getNome().startsWith(nome)){
                itensPesquisadosPeloNome.add(item);
            }
        }
        Collections.sort(itensPesquisadosPeloNome);
        return itensPesquisadosPeloNome;
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco) {
        List<ItemDeArtesanato> itensAbaixoDoPreco = new LinkedList<>();
        for(ItemDeArtesanato item: this.ItensDeArtesanato.values()){
            if(item.getPreco()<= preco){
                itensAbaixoDoPreco.add(item);
            }
        }
        Collections.sort(itensAbaixoDoPreco);
        return  itensAbaixoDoPreco;
    }

    @Override
    public ItemDeArtesanato pesqusiaItemPeloCodigo(String codigo) throws ItemInexistenteException {
        ItemDeArtesanato item = this.ItensDeArtesanato.get(codigo);
        if(item ==null){
            throw new ItemInexistenteException("Não existe item com o codigo : "+ codigo);
        }else{
            return item;
        }
    }
}
