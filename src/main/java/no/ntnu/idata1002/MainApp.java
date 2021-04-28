package no.ntnu.idata1002;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
            primaryStage.setTitle("ToDo-App");
            primaryStage.setScene(new Scene(root, 700, 400));
            primaryStage.show();

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {

        launch(args);
    }

}
