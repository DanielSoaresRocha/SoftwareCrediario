package Modelo;

import java.util.Date;

public class Venda {

    private int IdVenda, numParcelas;
    private String nomeMercadoria;
    private double valorMercadoria, valorParcelas;
    private Date dataVenda;
    private Cliente cliente;

    public Venda(int IdVenda, int numParcelas, String nomeMercadoria, double valorMercadoria, double valorParcelas, Date dataVenda, Cliente cliente) {
        this.IdVenda = IdVenda;
        this.numParcelas = numParcelas;
        this.nomeMercadoria = nomeMercadoria;
        this.valorMercadoria = valorMercadoria;
        this.valorParcelas = valorParcelas;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
    }

  
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNomeMercadoria() {
        return nomeMercadoria;
    }

    public void setNomeMercadoria(String nomeMercadoria) {
        this.nomeMercadoria = nomeMercadoria;
    }

    public double getValorMercadoria() {
        return valorMercadoria;
    }

    public void setValorMercadoria(double valorMercadoria) {
        this.valorMercadoria = valorMercadoria;
    }

    public int getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(int IdVenda) {
        this.IdVenda = IdVenda;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    

    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

}
