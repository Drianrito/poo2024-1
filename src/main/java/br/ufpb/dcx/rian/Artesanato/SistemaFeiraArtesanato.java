package br.ufpb.dcx.rian.Artesanato;

import java.util.List;

/**
 *  Sistema para gerenciar itens de artesanato
 *
 *
 */
public  interface SistemaFeiraArtesanato {

    /**
     * Cadastra um novo item no sistema.
     * @param item O item a ser adicionado
     * @return true se o item foi cadastrado, ou false caso ele ja exista no sistema.
     */
    public boolean cadastraItem(ItemDeArtesanato item);

    /**
     * Pesquisa todos os itens cuja o nome começa com o nome passado como parâmetro.
     * @param nome O nome a pesquisar
     * @return uma lista contendo os itens cuja nome começa com o parametro passado.
     * */
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome);


    /**
     * pesqusia os itens cujo o preço é menor ou igual ao valor passado no parâmetro
     *
     * @param preco valor a pesquisar
     * @return Uma lista contendo itens cujo preço é menor ou igual ao valor do parâmetro
     * */
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco);

    public ItemDeArtesanato pesqusiaItemPeloCodigo(String codigo) throws ItemInexistenteException;
}
