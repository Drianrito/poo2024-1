package br.ufpb.dcx.rian.SistemaCardapio;

import br.ufpb.dcx.rian.Artesanato.ItemJaExisteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeuSistemaCardapio implements SistemaGerenciadorDeCardapio{
    private Map<String,ItemDeCardapio> itensCardapioMap;

    public MeuSistemaCardapio (){
        this.itensCardapioMap = new HashMap<>();
    }
    @Override
    public void cadastrarItemNoCardapio(ItemDeCardapio item) throws ItemJaExisteException {
        if (this.itensCardapioMap.containsKey(item.getCodigo())) {
            throw new ItemJaExisteException("Já existe item com o código "
                    +item.getCodigo());
        } else {
            this.itensCardapioMap.put(item.getCodigo(), item);
        }
    }

    @Override
    public List<ItemDeCardapio> pesquisaItensDoTipo(TipoItemCardapio tipo) {
        List<ItemDeCardapio> itensDoTipo = new ArrayList<>();
        for(ItemDeCardapio itemDeCardapio: itensCardapioMap.values()){
            if(itemDeCardapio.getTipo().equals(tipo)){
                itensDoTipo.add(itemDeCardapio);
            }
        }return itensDoTipo;
    }

    @Override
    public ItemDeCardapio pesquisaItemDoCardapio(String codigo) throws ItemNaoExisteException {
        if (itensCardapioMap.containsKey(codigo)) {
            return this.itensCardapioMap.get(codigo);
        }else{
            throw  new ItemNaoExisteException("ADASDASDASDAS");
            }
    }

    @Override
    public boolean existeItemComNome(String nome) {
        for (ItemDeCardapio itemDeCardapio: itensCardapioMap.values()){
            if (itemDeCardapio.getNome().equals(nome)){
                return true;
            }
        }return false;
    }

    @Override
    public List<ItemDeCardapio> pesquisaItensPeloNome(String nomeItem) {
        List<ItemDeCardapio> itemDeCardapios =new ArrayList<>();
        for(ItemDeCardapio itemDeCardapio: itensCardapioMap.values()){
            if(itemDeCardapio.getNome().startsWith(nomeItem)){
                itemDeCardapios.add(itemDeCardapio);
            }
        }return itemDeCardapios;
    }

    @Override
    public int pesquisaQuantidadeDeItensDoTipo(TipoItemCardapio tipo) {
        int pesquisaQuant =0;
        for(ItemDeCardapio itemDeCardapio: itensCardapioMap.values()){
            if(itemDeCardapio.getTipo().equals(tipo)){
                pesquisaQuant++;
            }
        }return pesquisaQuant;
    }

}
