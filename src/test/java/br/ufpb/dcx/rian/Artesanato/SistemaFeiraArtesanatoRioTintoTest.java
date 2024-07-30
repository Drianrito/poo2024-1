package br.ufpb.dcx.rian.Artesanato;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFeiraArtesanatoRioTintoTest {
    @Test
    public void testaCadastro(){
        SistemaFeiraDeArtesanato sistema = new SistemaFeiraDeArtesanato();
        try {
            Roupa r = new Roupa();
            sistema.cadastraItem(r);
            ItemDeArtesanato item = sistema.pesqusiaItemPeloCodigo(r.getCodigo());
            assertEquals(item,r);
        } catch (CodigoInvallidoException | ItemJaExisteException | ItemInexistenteException e) {
            fail();
        }
    }
}
