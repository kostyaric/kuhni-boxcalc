package org.stilkuhni.controls;

import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.stilkuhni.Constants;

import java.util.Set;

public class ControlsActions {

    public static AnchorPane controlsPanel;

    public static void clearControls() {

        Set<Node> textAreas = controlsPanel.lookupAll("TextArea");
        for(Node area : textAreas) {
            ((TextArea) area).clear();
        }

        Set<Node> textFields = controlsPanel.lookupAll("TextField");
        for (Node field : textFields) {
            ((TextField) field).clear();
        }

        setDefaultDspWidth();

    }

    public static void setDefaultDspWidth() {

        Constants.PANEL_WIDTH_MM = 18;

        RadioButton dspw18 = (RadioButton) controlsPanel.lookup("#dspw18");
        dspw18.setSelected(true);

        RadioButton dspw16 = (RadioButton) controlsPanel.lookup("#dspw16");
        dspw16.setSelected(false);

    }
}
