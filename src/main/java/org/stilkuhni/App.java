package org.stilkuhni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static final String TITLE = "Расчет расстояния между полками";
/*
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 500;
*/


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle(TITLE);

        Parent content = FXMLLoader.load(getClass().getResource("/fxml/mainstyle.fxml"));
        Scene scene = new Scene(content);

        stage.setScene(scene);
        stage.show();
    }

}
