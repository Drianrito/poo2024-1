package br.ufpb.dcx.rian.SistemaComercial;

import br.ufpb.dcx.rian.SistemaComercial.Exception.*;

import java.util.Collection;
import java.util.Collections;

public interface SistemaComercial {
    boolean existeProduto(Produto produto);
    Produto pesquisaProduto(String codigoProduto) throws ProdutoNaoExisteException;
    boolean cadastraProduto(Produto produto);
    boolean existeCliente (Cliente cliente);
    public Cliente pesquisaCliente(String id)throws ClienteNaoExisteException;
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria);

}
