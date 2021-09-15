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
    private Button clearButton;
    @FXML
    private CheckBox horisontCheckBox;
    @FXML
    private TextField boxHeight;
    @FXML
    private TextField itemNumber;
    @FXML
    private TextArea distanceBetweenShelves;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        drawButton.setOnAction(actionEvent -> {
            buildShelves();
            BoxImageBuilder.feelTitle(itemNumber.getCharacters().toString(), boxHeight.getCharacters().toString());
        });

        clearButton.setOnAction(actionEvent -> {
            BoxImageBuilder.clearShelves();
            BoxImageBuilder.clearTitle();
        });

        horisontCheckBox.setOnAction(actionEvent -> {
            BoxImageBuilder boxImageBuilder = new BoxImageBuilder();
            boxImageBuilder.setBottomHorisontType(horisontCheckBox.isSelected());
            buildShelves();
        });

    }

    private void buildShelves() {

        List<Double> shelvesDist = distanceBetweenShelves.getParagraphs().stream()
                .filter(f -> !f.toString().isBlank())
                .map(charSequence -> charSequence.toString())
                .flatMap(dimRow -> Arrays.asList(dimRow.split(" ")).stream())
                .map(dim -> Double.parseDouble(dim))
                .sorted()
                .collect(Collectors.toList());

        String textHeight = boxHeight.getCharacters().toString();
        if (!textHeight.isBlank()) {
            Double height = Double.parseDouble(textHeight);
            CupBoard cupBoard = new CupBoard(height, shelvesDist, horisontCheckBox.isSelected());
            BoxImageBuilder boxImageBuilder = new BoxImageBuilder(height);
            boxImageBuilder.drawShelves(cupBoard);
        }
        else {
            BoxImageBuilder.clearShelves();
        }
    }
}
