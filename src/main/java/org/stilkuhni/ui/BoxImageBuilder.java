package org.stilkuhni.ui;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.stilkuhni.Constants;
import org.stilkuhni.model.cupboards.CupBoard;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.shelves.builders.ShelfImageBuilder;

public class BoxImageBuilder {
    public static Group imageGroup;
    private double realHeight = 1;
    private double verticalScale = 1;

    public BoxImageBuilder() {
    }

    public BoxImageBuilder(double realHeight) {
        this.realHeight = realHeight;
        this.verticalScale = calcVerticalScale(realHeight);
    }

    public void setBottomHorisontType(boolean bottomHorisontOuter) {
        rebuildBoxBody(bottomHorisontOuter);
    }

    public static double calcVerticalScale(double realHeight) {
        double topY = ElementsFinder.<Rectangle>findElementByID("topHorisont").getBoundsInParent().getMinY();
        double bottomY = ElementsFinder.<Rectangle>findElementByID("bottomHorisont").getBoundsInParent().getMaxY();
        return (bottomY - topY) / realHeight;
    }


    public static void rebuildBoxBody(boolean bottomHorisontOuter) {

        Rectangle box = ElementsFinder.<Rectangle>findElementByID("boxShell");
        Rectangle leftPanel = ElementsFinder.<Rectangle>findElementByID("leftPanel");
        Rectangle rightPanel = ElementsFinder.<Rectangle>findElementByID("rightPanel");
        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");
        Rectangle bottomPanel = ElementsFinder.<Rectangle>findElementByID("bottomHorisont");

        double boxLayoutX = box.getLayoutX();
        double boxLayoutY = box.getLayoutY();

        topPanel.setStrokeWidth(Constants.BASE_LINE_WIDTH);
        topPanel.setLayoutX(boxLayoutX + Constants.PANEL_WIDTH);
        topPanel.setHeight(Constants.PANEL_WIDTH);
        topPanel.setWidth(box.getWidth() - Constants.PANEL_WIDTH * 2);

        bottomPanel.setStrokeWidth(Constants.BASE_LINE_WIDTH);
        bottomPanel.setLayoutY(boxLayoutY + box.getHeight() - Constants.PANEL_WIDTH);
        bottomPanel.setHeight(Constants.PANEL_WIDTH);

        leftPanel.setStrokeWidth(Constants.BASE_LINE_WIDTH);
        leftPanel.setWidth(Constants.PANEL_WIDTH);

        rightPanel.setStrokeWidth(Constants.BASE_LINE_WIDTH);
        rightPanel.setLayoutX(boxLayoutX + box.getWidth() - Constants.PANEL_WIDTH);
        rightPanel.setWidth(Constants.PANEL_WIDTH);

        if (bottomHorisontOuter) {
            leftPanel.setHeight(box.getHeight() - Constants.PANEL_WIDTH);
            rightPanel.setHeight(box.getHeight() - Constants.PANEL_WIDTH);
            bottomPanel.setLayoutX(boxLayoutX);
            bottomPanel.setWidth(box.getWidth());
        }
        else {
            leftPanel.setHeight(box.getHeight());
            rightPanel.setHeight(box.getHeight());
            bottomPanel.setLayoutX(boxLayoutX + Constants.PANEL_WIDTH);
            bottomPanel.setWidth(box.getWidth() - Constants.PANEL_WIDTH * 2);
        }

    }

    public static void clearShelves() {
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        shelvesGroup.getChildren().clear();
    }

    public void drawShelves(CupBoard cupBoard) {
        clearShelves();
        ShelfImageBuilder.buidShelvesImages(cupBoard.getShelves(), cupBoard.getDimentionChain(), verticalScale);
    }

    public static void clearTitle() {
        Text title = ElementsFinder.<Text>findElementByID("itemTitle");
        title.setText("");
    }

    public static void feelTitle(String itemNumber, String itemHeight) {

        String number = itemNumber.trim();
        String height = itemHeight.trim();

        clearTitle();
        if (!number.isBlank() && !height.isBlank()) {
            Text title = ElementsFinder.<Text>findElementByID("itemTitle");
            title.setText("Пр. " + number + " H = " + height);
        }
    }
}
