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
            assertEquals(r,item);
        } catch (CodigoInvallidoException e) {
            //OK
        }catch (ItemJaExisteException | ItemInexistenteException e){
            fail("Nao era pra lançar essa exceção");
        }
    }
}
