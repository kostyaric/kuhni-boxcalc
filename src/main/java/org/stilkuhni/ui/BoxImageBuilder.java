package org.stilkuhni.ui;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class BoxImageBuilder {
    public static Group imageGroup;
    public static final int PANEL_WIDTH = 10;

    private Rectangle getRectangleElement(String rectangleID) {

        return (Rectangle) imageGroup.lookup("#" + rectangleID);

    }

    public void setBottomHorisontType(boolean bottomHorisontOuter) {

        Rectangle box = getRectangleElement("boxShell");
        Rectangle leftPanel = getRectangleElement("leftPanel");
        Rectangle rightPanel = getRectangleElement("rightPanel");
        Rectangle bottomPanel = getRectangleElement("bottomHorisont");

        if (bottomHorisontOuter) {
            leftPanel.setHeight(box.getHeight() - PANEL_WIDTH);
            rightPanel.setHeight(box.getHeight() - PANEL_WIDTH);
            bottomPanel.setX(box.getX() - PANEL_WIDTH);
            bottomPanel.setWidth(box.getWidth());
        }
        else {
            leftPanel.setHeight(box.getHeight());
            rightPanel.setHeight(box.getHeight());
            bottomPanel.setX(box.getX());
            bottomPanel.setWidth(box.getWidth() - PANEL_WIDTH * 2);
        }

    }

}
