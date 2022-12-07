package service;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceControl {

    private ObservableList<Service> lista =
            FXCollections.observableArrayList();

    private StringProperty nomeCliente = new SimpleStringProperty("");
    private StringProperty nomeOperador = new SimpleStringProperty("");
    private StringProperty statusProblema = new SimpleStringProperty("");
    private StringProperty dataServico = new SimpleStringProperty("");
    private StringProperty detalhamentoServico = new SimpleStringProperty("");

    public Service getServiceAtual() {
        return serviceAtual;
    }

    public void setServiceAtualService(Service serviceAtual) {
        this.serviceAtual = serviceAtual;
    }

    private Service serviceAtual;

    public void entityToBoundaryService(Service s) {
        if (s != null) {
            nomeCliente.set(s.getNomeCliente());
            nomeOperador.set(s.getNomeOperador());
            statusProblema.set(s.getStatusProblema());
            dataServico.set(s.getDataServico());
            detalhamentoServico.set(s.getDetalhamentoServico());
        }
    }

    public void adicionarService() {
        Service s = new Service();
        s.setNomeCliente(nomeCliente.get());
        s.setNomeOperador(nomeOperador.get());
        s.setStatusProblema(statusProblema.get());
        s.setDataServico(dataServico.get());
        s.setDetalhamentoServico(detalhamentoServico.get());
        lista.add(s);
    }

    public void pesquisarService() {
        for (Service s : lista) {
            if (s.getNomeCliente().contains(nomeCliente.get())) {
                entityToBoundaryService(s);
                break;
            }
        }
    }

    public void atualizarService(){
        if(this.serviceAtual != null){
            Service s = serviceAtual;
            s.setNomeCliente(nomeCliente.get());
            s.setNomeOperador(nomeOperador.get());
            s.setStatusProblema(statusProblema.get());
            s.setDataServico(dataServico.get());
            s.setDetalhamentoServico(detalhamentoServico.get());
//            lista.add(s);
        }
    }

    public void apagarService() {
        if (this.serviceAtual != null) {
            lista.remove(serviceAtual);
        }
    }

    public StringProperty nomeClienteProperty() {
        return nomeCliente;
    }
    public StringProperty nomeOperadorProperty() {
        return nomeOperador;
    }
    public StringProperty statusProblemaProperty() {
        return statusProblema;
    }
    public StringProperty dataServicoProperty() {
        return dataServico;
    }
    public StringProperty detalhamentoServico() {return detalhamentoServico; }

    public ObservableList<Service> getListaService() {
       return this.lista;
    }
}
