package org.stilkuhni.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import org.stilkuhni.Constants;
import org.stilkuhni.controls.ControlsActions;
import org.stilkuhni.model.cupboards.CupBoard;
import org.stilkuhni.ui.finders.ElementsFinder;

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
    private TextArea cornerEval;
    @FXML
    private TextArea distanceBetweenShelves;
    @FXML
    private RadioButton dspw16;
    @FXML
    private RadioButton dspw18;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        drawButton.setOnAction(actionEvent -> {
            buildShelves();
            BoxImageBuilder.feelTitle(itemNumber.getCharacters().toString(), boxHeight.getCharacters().toString());
        });

        clearButton.setOnAction(actionEvent -> {
            BoxImageBuilder.clearShelves();
            BoxImageBuilder.clearTitle();
            ControlsActions.clearControls();
        });

        horisontCheckBox.setOnAction(actionEvent -> {
            BoxImageBuilder.setBottomHorisontType(horisontCheckBox.isSelected());
            rebuildShelves();
        });

        dspw16.setOnAction(event -> {
            Constants.PANEL_WIDTH_MM = 16;
            rebuildShelves();
        });

        dspw18.setOnAction(event -> {
            Constants.PANEL_WIDTH_MM = 18;
            rebuildShelves();
        });
    }

    private void rebuildShelves() {
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        if (shelvesGroup.getChildren().size() > 0) {
            buildShelves();
        }
    }

    private void buildShelves() {

        String textHeight = boxHeight.getCharacters().toString();
        boolean supportedHorisont = horisontCheckBox.isSelected();

        List<Double> shelvesDist = distanceBetweenShelves.getParagraphs().stream()
                .filter(f -> !f.toString().isBlank())
                .map(charSequence -> charSequence.toString())
                .flatMap(dimRow -> Arrays.asList(dimRow.split(" ")).stream())
                .map(dim -> Double.parseDouble(dim))
                .sorted()
                .collect(Collectors.toList());


        StringBuilder formula = new StringBuilder();
        cornerEval.getParagraphs().stream()
                .filter(f -> !f.toString().isBlank())
                .forEach(charSequence -> formula.append(charSequence.toString()));

        if (!textHeight.isBlank()) {
            Double height = Double.parseDouble(textHeight);
            CupBoard cupBoard = new CupBoard(height, shelvesDist, supportedHorisont);
            BoxImageBuilder boxImageBuilder = new BoxImageBuilder(height, supportedHorisont);
            boxImageBuilder.drawShelves(cupBoard);
            boxImageBuilder.drawCorners(formula.toString(), cupBoard);
        }
        else {
            BoxImageBuilder.clearShelves();
        }
    }
}
