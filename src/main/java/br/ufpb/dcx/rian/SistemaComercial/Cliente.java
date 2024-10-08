package br.ufpb.dcx.rian.SistemaComercial;

public abstract class Cliente {
    public String nome;
    public String endereco;
    public String email;

    public abstract String getId();

    public Cliente(String nome, String endereco, String email){
        this.nome=nome;
        this.endereco= endereco;
        this.email=email;
    }
    public Cliente(){
        this("","","");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
