package org.stilkuhni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.stilkuhni.controls.ControlsActions;
import org.stilkuhni.ui.BoxImageBuilder;

public class App extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle(Constants.TITLE);

        Parent content = FXMLLoader.load(getClass().getResource("/fxml/mainstyle.fxml"));
        Scene scene = new Scene(content);

        stage.setScene(scene);
        stage.show();

        BoxImageBuilder.imageGroup = (Group) scene.lookup("#imageGroup");
        BoxImageBuilder.clearTitle();
        BoxImageBuilder.rebuildBoxBody(false);

        ControlsActions.controlsPanel = (AnchorPane) scene.lookup("#controls");
        ControlsActions.setDefaultDspWidth();

        /*Если привязывать контроллер программно, а не через fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainstyle.fxml"));
        loader.setController(new Controller());
        Parent content = loader.load();
        Scene scene = new Scene(content);
        */
    }

}
