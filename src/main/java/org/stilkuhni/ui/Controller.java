package org.stilkuhni.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.stilkuhni.model.cupboards.CupBoard;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {

    @FXML
    private Button drawButton;
    @FXML
    private CheckBox horisontCheckBox;
    @FXML
    private TextField boxHeight;
    @FXML
    private TextArea distanceBetweenShelves;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        drawButton.setOnAction(actionEvent -> {

            Double height = Double.parseDouble(boxHeight.getCharacters().toString());

            List<Double> shelvesDist = distanceBetweenShelves.getParagraphs().stream()
                    .map(charSequence -> charSequence.toString())
                    .flatMap(dimRow -> Arrays.asList(dimRow.split(" ")).stream())
                    .map(dim -> Double.parseDouble(dim))
                    .sorted()
                    .collect(Collectors.toList());

            CupBoard cupBoard = new CupBoard(height, shelvesDist, horisontCheckBox.isSelected());
            BoxImageBuilder boxImageBuilder = new BoxImageBuilder(height);
            boxImageBuilder.drawShelves(cupBoard.getShelves());

        });

        horisontCheckBox.setOnAction(actionEvent -> {
            BoxImageBuilder boxImageBuilder = new BoxImageBuilder();
            boxImageBuilder.setBottomHorisontType(horisontCheckBox.isSelected());
        });

    }
}
