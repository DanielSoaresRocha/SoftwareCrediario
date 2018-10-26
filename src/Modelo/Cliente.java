package Modelo;

public class Cliente {
    private int IdCliente;
    private String nome;
    private int cpf;     
    private String endereco;
    private int numero;
    private String nomeMae;


    public Cliente(int IdCliente, String nome, int cpf, String endereco, int numero, String nomeMae) {
        this.IdCliente = IdCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.nomeMae = nomeMae;
    }
    
    
    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.IdCliente != other.IdCliente) {
            return false;
        }
        return true;
    }
    
    

}
