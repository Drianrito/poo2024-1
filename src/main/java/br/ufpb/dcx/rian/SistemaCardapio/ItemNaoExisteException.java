package br.ufpb.dcx.rian.SistemaCardapio;

public class ItemNaoExisteException extends Exception {
    public ItemNaoExisteException(String msg) {
        super(msg);
    }
}
