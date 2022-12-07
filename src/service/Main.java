package service;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        ServiceBoundary sb = new ServiceBoundary();

        GridPane gp = new GridPane();
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 500, 200);

        Button btnUser = new Button("Usuarios");
        Button btnService = new Button("Servicos");
        Button btnEncerra = new Button("Fechar");

        gp.add(new Label("Sistema para Service Desk de POO"), 1, 0);
        gp.add(btnUser, 0, 1);
        gp.add(btnService, 1, 1);
        gp.add(btnEncerra, 2, 1);

        gp.setHgap(50);
        gp.setVgap(50);

        bp.setTop(gp);

        BorderPane.setAlignment(gp, Pos.CENTER);
        bp.setPadding(new Insets(10));
        BorderPane.setMargin(gp, new Insets(10));

        btnUser.setOnAction(e-> UserBoundary.launch());
//        btnService.setOnAction(e-> ServiceBoundary.launch());
//        btnService.setOnAction(e-> Application.launch(ServiceBoundary.class));
        btnEncerra.setOnAction(e-> stage.close());

        stage.setScene(scn);
        stage.setTitle("Menu Principal");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
