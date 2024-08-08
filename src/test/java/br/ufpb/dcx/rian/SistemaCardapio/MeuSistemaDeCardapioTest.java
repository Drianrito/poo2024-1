package br.ufpb.dcx.rian.SistemaCardapio;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MeuSistemaDeCardapioTest {
    MeuSistemaCardapio sistema = new MeuSistemaCardapio();

    @Test
    public void test(){
        ItemDeCardapio item1 = new ItemDeCardapio("B01", TipoItemCardapio.BEBIDA,"Suco de Laranja",8.00);
        try {
            assertFalse(sistema.existeItemComNome("Suco de Laranja"));
            sistema.cadastrarItemNoCardapio(item1);
            assertTrue(sistema.existeItemComNome("B01"));
            int pesquisaItem =sistema.pesquisaQuantidadeDeItensDoTipo(TipoItemCardapio.BEBIDA);
            assertTrue(pesquisaItem == 1);
            ItemDeCardapio item2 = new ItemDeCardapio("B02", TipoItemCardapio.BEBIDA,"Suco de Uva",7.00);
            sistema.cadastrarItemNoCardapio(item2);
            List<ItemDeCardapio> pesquisaGeral = sistema.pesquisaItensDoTipo(TipoItemCardapio.LANCHE);
            assertTrue(pesquisaGeral.isEmpty());
        }catch (Exception e){
            fail("nao deveria lançar excecao");
        }
    }
}
