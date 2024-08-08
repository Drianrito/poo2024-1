package br.ufpb.dcx.rian.SistemaCardapio;

import br.ufpb.dcx.rian.Artesanato.ItemJaExisteException;

import java.util.List;

public interface SistemaGerenciadorDeCardapio {
    public void cadastrarItemNoCardapio(ItemDeCardapio item) throws ItemJaExisteException;
    public List<ItemDeCardapio> pesquisaItensDoTipo(TipoItemCardapio tipo);
    public ItemDeCardapio pesquisaItemDoCardapio(String codigo) throws
            ItemNaoExisteException;
    public boolean existeItemComNome(String nome);
    public List<ItemDeCardapio> pesquisaItensPeloNome(String nomeItem);
    public int pesquisaQuantidadeDeItensDoTipo(TipoItemCardapio tipo);
}
