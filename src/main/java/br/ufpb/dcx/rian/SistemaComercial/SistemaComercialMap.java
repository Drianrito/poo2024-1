package br.ufpb.dcx.rian.SistemaComercial;

import br.ufpb.dcx.rian.SistemaComercial.Exception.ClienteNaoExisteException;
import br.ufpb.dcx.rian.SistemaComercial.Exception.ProdutoNaoExisteException;

import java.util.*;

public class SistemaComercialMap implements SistemaComercial {
    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;
    public SistemaComercialMap () {
        this.clientes = new HashMap<String, Cliente>();
        this.produtos = new HashMap<String, Produto>();
    }
    @Override
    public boolean existeProduto(Produto produto) {
        if (this.produtos.containsKey(produto.getCodigo())){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Produto pesquisaProduto(String codigoProduto)
            throws ProdutoNaoExisteException {
        if (this.produtos.containsKey(codigoProduto)) {
            return this.produtos.get(codigoProduto);
        }
        throw new ProdutoNaoExisteException("Não foi encontrado produto"
                +" com o código "+codigoProduto);
    }
    @Override
    public boolean cadastraProduto(Produto produto) {
        if (existeProduto(produto)) {
            return false;
        } else {
            this.produtos.put(produto.getCodigo(),produto);
            return true;
        }
    }

    @Override
    public boolean existeCliente(Cliente cliente) {
        if(this.clientes.containsKey(cliente.getId())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
        Cliente clientePesq = this.clientes.get(id);
        if(clientePesq == null){
            throw new ClienteNaoExisteException("Cliente inexistente");
        }else{
            return clientePesq;}
    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
        Collection<Produto> produtosDaCategoria = new ArrayList<>();
        for(Produto pro: produtos.values()){
            if(pro.getCategoria().equals(categoria)){
                produtosDaCategoria.add(pro);
            }
        }return produtosDaCategoria;
    }
}
