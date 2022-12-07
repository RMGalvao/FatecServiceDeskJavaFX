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


public class UserBoundary extends Application {
    private TextField txtNomeUsuario = new TextField();
    private TextField txtFuncaoUsuario = new TextField();
    private TextField txtTelefoneUsuario = new TextField();
    private TextField txtEmpresaUsuario = new TextField();

    private UserControl control = new UserControl();
    private TableView<User> tableUser = new TableView<>();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 800, 600);

        Button btnAdicionar = new Button("Adicionar");
        Button btnPesquisar = new Button("Pesquisar");
        Button btnApagar = new Button("Apagar");

        gp.add(new Label("Usuario"), 0, 0);
        gp.add(txtNomeUsuario, 1, 0);
        gp.add(new Label("Funcao"), 0, 1);
        gp.add(txtFuncaoUsuario, 1, 1);
        gp.add(new Label("Telefone"), 0, 2);
        gp.add(txtTelefoneUsuario, 1, 2);
        gp.add(new Label("Empresa"), 0, 3);
        gp.add(txtEmpresaUsuario,1, 3);
        gp.add(btnAdicionar, 0, 4);
        gp.add(btnPesquisar, 1, 4);
        gp.add(btnApagar, 2, 4);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(100);
        ColumnConstraints col3 = new ColumnConstraints();
        col2.setPercentWidth(100);
        ColumnConstraints col4 = new ColumnConstraints();
        col2.setPercentWidth(100);
        gp.getColumnConstraints().addAll(col1, col2, col3, col4);

        bp.setTop(gp);
        bp.setCenter(tableUser);

        BorderPane.setAlignment(gp, Pos.CENTER);
        bp.setPadding(new Insets(50));
        BorderPane.setMargin(gp, new Insets(50));

        vincular();
        alimentarTable();

        btnAdicionar.setOnAction(e-> control.adicionarUser());
        btnPesquisar.setOnAction(e-> control.pesquisarUser());
        btnApagar.setOnAction(e-> control.apagarUser());

        stage.setScene(scn);
        stage.setTitle("Controle de Usuarios");
        stage.show();

    }

    public void alimentarTable() {
        TableColumn<User, String> col1 = new TableColumn<>("Usuario");
        col1.setCellValueFactory(
                new PropertyValueFactory<User, String>("nomeUsuario"));

        TableColumn<User, String> col2 = new TableColumn<>("Funcao");
        col2.setCellValueFactory(
                new PropertyValueFactory<User, String>("funcaoUsuario"));

        TableColumn<User, String> col3 = new TableColumn<>("Telefone");
        col3.setCellValueFactory(
                new PropertyValueFactory<User, String>("telefoneUsuario"));

        TableColumn<User, String> col4 = new TableColumn<>("Empresa");
        col4.setCellValueFactory(
                new PropertyValueFactory<User, String>("empresaUsuario"));

        tableUser.getColumns().addAll(col1, col2, col3, col4);
        tableUser.setItems(control.getListaUser());

        tableUser.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, antigo, novo) -> {
                    // System.out.println(novo.getModelo());
                    control.entityToBoundaryUser(novo);
                    control.setUserAtual(novo);
                });

    }

    public void vincular() {
        Bindings.bindBidirectional(txtNomeUsuario.textProperty(),
                control.nomeUsuarioProperty());
        Bindings.bindBidirectional(txtFuncaoUsuario.textProperty(),
                control.funcaoUsuarioProperty());
        Bindings.bindBidirectional(txtTelefoneUsuario.textProperty(),
                control.telefoneUsuarioProperty());
        Bindings.bindBidirectional(txtEmpresaUsuario.textProperty(),
                control.empresaUsuarioProperty());
    }

    public static void main(String[] args) {
        Application.launch(UserBoundary.class, args);
    }
}
