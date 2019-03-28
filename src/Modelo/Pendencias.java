package Modelo;

import java.sql.Date;

public class Pendencias {

    private int id;
    private Date dataVenda;
    private Date dataCobranca;
    private String nome;
    private String nomeMercadoria;
    private double valorTotal, valorPago, valorRestante, mensalidade;

    public Pendencias() {

    }

    public Pendencias(int id, Date dataVenda, Date dataCobranca, String nome, String nomeMercadoria, double valorTotal, double valorPago, double valorRestante, double mensalidade) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.dataCobranca = dataCobranca;
        this.nome = nome;
        this.nomeMercadoria = nomeMercadoria;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.valorRestante = valorRestante;
        this.mensalidade = mensalidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMercadoria() {
        return nomeMercadoria;
    }

    public void setNomeMercadoria(String nomeMercadoria) {
        this.nomeMercadoria = nomeMercadoria;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataCobranca() {
        return dataCobranca;
    }

    public void setDataCobranca(Date dataCobranca) {
        this.dataCobranca = dataCobranca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(double valorRestante) {
        this.valorRestante = valorRestante;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public String toString() {
        return nomeMercadoria;
    }

}
