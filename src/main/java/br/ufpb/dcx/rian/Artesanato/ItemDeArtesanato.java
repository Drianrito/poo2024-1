package br.ufpb.dcx.rian.Artesanato;

import java.util.Objects;

public abstract class ItemDeArtesanato implements Comparable<ItemDeArtesanato>{
    private String codigo;
    private String nome;
    private double preco;

    public ItemDeArtesanato(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public ItemDeArtesanato() {
        this("","",0);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public abstract String getDescricao();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDeArtesanato that = (ItemDeArtesanato) o;
        return Objects.equals(codigo, that.codigo);
    }
    @Override
    public String toString(){
        return "Nome: " + this.nome + "Codigo: " +this.codigo +"preço" + this.preco;
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public int compareTo(ItemDeArtesanato o) {
       // return this.nome.compareTo((o.getNome()));
        if (this.preco <o.getPreco()){
            return -1;
        } else if (this.preco==o.getPreco()) {
            return 0;
        }else {
            return 1;
        }
    }
}

