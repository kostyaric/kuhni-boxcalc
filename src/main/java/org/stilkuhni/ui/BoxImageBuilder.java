package org.stilkuhni.ui;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import org.stilkuhni.Constants;
import org.stilkuhni.model.shelves.Shelf;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.shelves.ShelfImage;
import org.stilkuhni.ui.shelves.builders.ShelfImageBuilder;

import java.util.List;

public class BoxImageBuilder {
    public static Group imageGroup;
    private double realHeight = 1;
    private double verticalScale = 1;

    public BoxImageBuilder() {
    }

    public BoxImageBuilder(double realHeight) {
        this.realHeight = realHeight;
        this.verticalScale = calcVerticalScale();
    }

    public void setBottomHorisontType(boolean bottomHorisontOuter) {

        Rectangle box = ElementsFinder.<Rectangle>findElementByID("boxShell");
        Rectangle leftPanel = ElementsFinder.<Rectangle>findElementByID("leftPanel");
        Rectangle rightPanel = ElementsFinder.<Rectangle>findElementByID("rightPanel");
        Rectangle bottomPanel = ElementsFinder.<Rectangle>findElementByID("bottomHorisont");

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

    private double calcVerticalScale() {
        double topY = ElementsFinder.<Rectangle>findElementByID("topHorisont").getBoundsInParent().getMinY();
        double bottomY = ElementsFinder.<Rectangle>findElementByID("bottomHorisont").getBoundsInParent().getMaxY();
        return (bottomY - topY) / realHeight;
    }

    public void drawShelves(List<Shelf> shelves) {

        for (Shelf shelf : shelves) {
            ShelfImage shelfImage = shelf.createImage();
            ShelfImageBuilder.buildShelfImage(shelf, shelfImage, verticalScale);
            shelfImage.draw();
        }

    }

}
