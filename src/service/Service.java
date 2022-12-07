package service;

import java.util.Date;

public class Service {
    private String nomeCliente;
    private String nomeOperador;
    private String statusProblema;
    private String dataServico;
    private String detalhamentoServico;

    public String getDetalhamentoServico() {
        return detalhamentoServico;
    }

    public void setDetalhamentoServico(String detalhamentoServico) {
        this.detalhamentoServico = detalhamentoServico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getStatusProblema() {
        return statusProblema;
    }

    public void setStatusProblema(String statusProblema) {
        this.statusProblema = statusProblema;
    }

    public String getDataServico() {
        return dataServico;
    }

    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
    }
}
