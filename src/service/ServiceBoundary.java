package service;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ServiceBoundary extends Application {
    private TextField txtNomeCliente = new TextField();
    private TextField txtNomeOperador = new TextField();
    private TextField txtstatusProblema = new TextField();
    private TextField txtDataServico = new TextField();
    private TextField txtDetalhamentoServico = new TextField();

    private ServiceControl control = new ServiceControl();
    private TableView<Service> tableService = new TableView<>();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 900, 700);

        Button btnAdicionar = new Button("Adicionar");
        Button btnPesquisar = new Button("Pesquisar");
        Button btnApagar = new Button("Apagar");
        Button btnAtualizar = new Button("Atualizar");

        gp.add(new Label("Nome Cliente"), 0, 0);
        gp.add(txtNomeCliente, 1, 0);
        gp.add(new Label("Nome Operador"), 0, 1);
        gp.add(txtNomeOperador, 1, 1);
        gp.add(new Label("Status Problema"), 0, 2);
        gp.add(txtstatusProblema, 1, 2);
        gp.add(new Label("Data Servico"), 0, 3);
        gp.add(txtDataServico,1, 3);
        gp.add(new Label("Detalhamento Servico"), 0, 4);
        gp.add(txtDetalhamentoServico, 1, 4);
        gp.add(btnAdicionar, 0, 5);
        gp.add(btnPesquisar, 1, 5);
        gp.add(btnApagar, 2, 5);
        gp.add(btnAtualizar, 3, 5);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(50);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(50);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPercentWidth(50);
        gp.getColumnConstraints().addAll(col1, col2, col3, col4, col5);

        bp.setTop(gp);
        bp.setCenter(tableService);

        BorderPane.setAlignment(gp, Pos.CENTER);
        bp.setPadding(new Insets(50));
        BorderPane.setMargin(gp, new Insets(50));

        vincular();
        alimentarTable();

        btnAdicionar.setOnAction(e-> control.adicionarService());
        btnPesquisar.setOnAction(e-> control.pesquisarService());
        btnApagar.setOnAction(e-> control.apagarService());
        btnAtualizar.setOnAction(e-> control.atualizarService());

        stage.setScene(scn);
        stage.setTitle("Controle dos Servicos");
        stage.show();
    }

    public void alimentarTable() {
        TableColumn<Service, String> col1 = new TableColumn<>("Cliente");
        col1.setCellValueFactory(
                new PropertyValueFactory<Service, String>("nomeCliente"));

        TableColumn<Service, String> col2 = new TableColumn<>("Operador");
        col2.setCellValueFactory(
                new PropertyValueFactory<Service, String>("nomeOperador"));

        TableColumn<Service, String> col3 = new TableColumn<>("Status");
        col3.setCellValueFactory(
                new PropertyValueFactory<Service, String>("statusProblema"));

        TableColumn<Service, String> col4 = new TableColumn<>("Data Servico");
        col4.setCellValueFactory(
                new PropertyValueFactory<Service, String>("dataServico"));

        TableColumn<Service, String> col5 = new TableColumn<>("Detalhamento");
        col5.setCellValueFactory(
                new PropertyValueFactory<Service, String>("detalhamentoServico"));

        tableService.getColumns().addAll(col1, col2, col3, col4, col5);
        tableService.setItems(control.getListaService());

        tableService.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, antigo, novo) -> {
                    // System.out.println(novo.getModelo());
                    control.entityToBoundaryService(novo);
                    control.setServiceAtualService(novo);
                });

    }

    public void vincular() {
        Bindings.bindBidirectional(txtNomeCliente.textProperty(),
                control.nomeClienteProperty());
        Bindings.bindBidirectional(txtNomeOperador.textProperty(),
                control.nomeOperadorProperty());
        Bindings.bindBidirectional(txtstatusProblema.textProperty(),
                control.statusProblemaProperty());
        Bindings.bindBidirectional(txtDataServico.textProperty(),
                control.dataServicoProperty());
        Bindings.bindBidirectional(txtDetalhamentoServico.textProperty(),
                control.detalhamentoServico());
    }

//    public static void main(String[] args) {
//        Application.launch(ServiceBoundary.class, args);
//    }


}
