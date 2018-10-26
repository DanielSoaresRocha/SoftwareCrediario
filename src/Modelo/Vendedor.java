package Modelo;

public class Vendedor {
    
    private int IdVendedor, cpf;
    private String nome;
    private String senha;

    public Vendedor(String nome, int cpf, int IdVendedor, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.IdVendedor = IdVendedor;
        this.senha = senha;
    }

    public Vendedor(String nome, int cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
