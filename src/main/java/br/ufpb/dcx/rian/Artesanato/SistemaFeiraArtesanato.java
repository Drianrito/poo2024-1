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
    public void cadastraItem(ItemDeArtesanato item) throws CodigoInvallidoException,ItemJaExisteException;

    /**
     * Pesquisa todos os itens cuja o nome começa com o nome passado como parâmetro.
     * @param nome O nome a pesquisar
     * @return uma lista contendo os itens cuja nome começa com o parametro passado.
     */
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome);


    /**
     * pesqusia os itens cujo o preço é menor ou igual ao valor passado no parâmetro
     *
     * @param preco valor a pesquisar
     * @return Uma lista contendo itens cujo preço é menor ou igual ao valor do parâmetro
     *
     */
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco);

    /**
     * Pesquisa o item cujo codigo é passado por parâmetro
     * @param codigo O codigo do item a pesquisar
     * @return o item encontrrado
     * @throws ItemInexistenteException Se nao for encontrado nenhum item com o codigo passado.
     */
    public ItemDeArtesanato pesqusiaItemPeloCodigo(String codigo) throws ItemInexistenteException;
}
