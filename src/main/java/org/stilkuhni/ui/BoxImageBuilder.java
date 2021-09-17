package org.stilkuhni.ui;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.stilkuhni.Constants;
import org.stilkuhni.model.cupboards.CupBoard;
import org.stilkuhni.ui.corners.CornerImage;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
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
        Rectangle leftPanel = ElementsFinder.<Rectangle>findElementByID("leftPanel");
        return (leftPanel.getBoundsInParent().getMaxY() - leftPanel.getBoundsInParent().getMinY()) / realHeight;
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

    public static void drawCorners(String formula) {

        if (formula.isBlank()) {
            return;
        }

        DoubleEvaluator doubleEvaluator = new DoubleEvaluator();
        Double cornerDimention = doubleEvaluator.evaluate(formula);

        Rectangle bottomPanel = ElementsFinder.<Rectangle>findElementByID("bottomHorisont");
        Rectangle leftPanel = ElementsFinder.<Rectangle>findElementByID("leftPanel");
        Rectangle rightPanel = ElementsFinder.<Rectangle>findElementByID("rightPanel");

        double y = bottomPanel.getBoundsInParent().getMinY() - Constants.CORNER_FROM_BOTTOM;
        double leftX = leftPanel.getBoundsInParent().getMaxX() + Constants.CORNER_FROM_SIDE_PANEL;
        double rightX = rightPanel.getBoundsInParent().getMinX() - Constants.CORNER_FROM_SIDE_PANEL;

        double lineLenth = Constants.CORNER_LENTH;

        CornerImage leftCorner = new CornerImage(new Dot(leftX, y), lineLenth, -lineLenth);
        CornerImage rightCorner = new CornerImage(new Dot(rightX, y), -lineLenth, -lineLenth);

        leftCorner.draw();
        rightCorner.draw();
    }

}
