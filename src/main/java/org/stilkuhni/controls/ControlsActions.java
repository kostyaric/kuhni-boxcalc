package org.stilkuhni.controls;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    }

}
