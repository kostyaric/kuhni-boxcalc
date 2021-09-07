package org.stilkuhni.ui;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import org.stilkuhni.Constants;
import org.stilkuhni.model.shelves.Shelf;

import java.util.List;

public class BoxImageBuilder {
    public static Group imageGroup;

    private Rectangle getRectangleElement(String rectangleID) {

        return (Rectangle) imageGroup.lookup("#" + rectangleID);

    }

    public void setBottomHorisontType(boolean bottomHorisontOuter) {

        Rectangle box = getRectangleElement("boxShell");
        Rectangle leftPanel = getRectangleElement("leftPanel");
        Rectangle rightPanel = getRectangleElement("rightPanel");
        Rectangle bottomPanel = getRectangleElement("bottomHorisont");

        if (bottomHorisontOuter) {
            leftPanel.setHeight(box.getHeight() - Constants.PANEL_WIDTH_PIXEL);
            rightPanel.setHeight(box.getHeight() - Constants.PANEL_WIDTH_PIXEL);
            bottomPanel.setX(box.getX() - Constants.PANEL_WIDTH_PIXEL);
            bottomPanel.setWidth(box.getWidth());
        }
        else {
            leftPanel.setHeight(box.getHeight());
            rightPanel.setHeight(box.getHeight());
            bottomPanel.setX(box.getX());
            bottomPanel.setWidth(box.getWidth() - Constants.PANEL_WIDTH_PIXEL * 2);
        }

    }

    public static void drawShelves(List<Shelf> shelves) {

    }

}
