package org.stilkuhni.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Group imageGroup;
    @FXML
    private Button drawButton;
    @FXML
    private CheckBox horisontCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        drawButton.setOnAction(actionEvent -> {
            System.out.println("Button was pressed down");
        });

        horisontCheckBox.setOnAction(actionEvent -> {
            BoxImageBuilder boxImageBuilder = new BoxImageBuilder();
            boxImageBuilder.setBottomHorisontType(horisontCheckBox.isSelected());
        });

    }
}
