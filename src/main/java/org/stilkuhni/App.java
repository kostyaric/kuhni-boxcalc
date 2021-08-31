package org.stilkuhni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.stilkuhni.ui.BoxImageBuilder;
import org.stilkuhni.ui.Controller;

public class App extends Application {

    public static final String TITLE = "Расчет расстояния между полками";

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

        BoxImageBuilder.imageGroup = (Group) scene.lookup("#imageGroup");

        /*Если привязывать контроллер программно, а не через fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainstyle.fxml"));
        loader.setController(new Controller());
        Parent content = loader.load();
        Scene scene = new Scene(content);
        */
    }

}
