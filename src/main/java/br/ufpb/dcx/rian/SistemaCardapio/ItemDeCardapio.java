package br.ufpb.dcx.rian.SistemaCardapio;

import java.util.Objects;

public class ItemDeCardapio {
    private String codigo;
    private TipoItemCardapio tipo;
    private String nome;
    private double valor;
    public ItemDeCardapio(String codigo, TipoItemCardapio tipo, String nome, double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nome = nome;
        this.valor = valor;
    }

    public ItemDeCardapio() {
        this("",TipoItemCardapio.GERAL, "",0.0);
    }

    @Override
    public String toString() {
        return "ItemDeCardapio{" +
                "codigo='" + codigo + '\'' +
                ", tipo=" + tipo +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoItemCardapio getTipo() {
        return tipo;
    }

    public void setTipo(TipoItemCardapio tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDeCardapio that = (ItemDeCardapio) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
