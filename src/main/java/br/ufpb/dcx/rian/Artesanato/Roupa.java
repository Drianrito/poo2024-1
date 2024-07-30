package br.ufpb.dcx.rian.Artesanato;

public class Roupa extends ItemDeArtesanato{
    private String material;
    private String tamanho;

    public Roupa(String codigo, String nome, double preco, String material, String tamanho) {
        super(codigo, nome, preco,TipoItem.ROUPA);
        this.material = material;
        this.tamanho =tamanho;
    }
    public Roupa() {
        this("","",0,"","");
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao(){
        return  "Roupa de codigo"+ super.getCodigo() + "de nome " +super.getNome() + "e de tamanho" + this.tamanho;
    }
    public String toString(){
        return getDescricao();
    }

}
