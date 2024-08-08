package br.ufpb.dcx.rian.SistemaComercial;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SistemaComercialMapTest {

    @Test
    public void testaCadastroProdutos(){
        SistemaComercialMap sistema = new SistemaComercialMap();
        Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertTrue(alimentos.size()==0);
        Produto produto1 = new Produto("123","Produto Novo",30.0,6,CategoriaProduto.ALIMENTO);
        sistema.cadastraProduto(produto1);
        alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertTrue(sistema.existeProduto(produto1));
        assertTrue((alimentos.size()== 1));
    }

}
