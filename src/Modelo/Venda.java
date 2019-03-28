package Modelo;

import java.util.Date;

public class Venda {

    private int IdVenda;
    private String status;
    private String nomeMercadoria;
    private double valorMercadoria, numParcelas, valorParcelas;
    private Date dataVenda;
    private int diasAtrasados;
    private double valorPago;
    private Cliente cliente;

    public Venda(int IdVenda, String status, String nomeMercadoria, double valorMercadoria, double numParcelas,
            double valorParcelas, Date dataVenda, int diasAtrasados, double valorPago, Cliente cliente) {
        this.IdVenda = IdVenda;
        this.status = status;
        this.nomeMercadoria = nomeMercadoria;
        this.valorMercadoria = valorMercadoria;
        this.numParcelas = numParcelas;
        this.valorParcelas = valorParcelas;
        this.dataVenda = dataVenda;
        this.diasAtrasados = diasAtrasados;
        this.valorPago = valorPago;
        this.cliente = cliente;
    }

    public int getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(int IdVenda) {
        this.IdVenda = IdVenda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public double getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(double numParcelas) {
        this.numParcelas = numParcelas;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getDiasAtrasados() {
        return diasAtrasados;
    }

    public void setDiasAtrasados(int diasAtrasados) {
        this.diasAtrasados = diasAtrasados;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

}
