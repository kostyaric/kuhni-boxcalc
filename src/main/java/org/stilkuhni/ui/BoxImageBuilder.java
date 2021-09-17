package org.stilkuhni.ui;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.stilkuhni.Constants;
import org.stilkuhni.model.cupboards.CupBoard;
import org.stilkuhni.ui.corners.CornerImage;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.shelves.builders.ShelfImageBuilder;

import java.util.List;

public class BoxImageBuilder {
    public static Group imageGroup;
    private double realHeight = 1;
    private double verticalScale = 1;
    private boolean supportedHorisont;

    public BoxImageBuilder() {
    }

    public BoxImageBuilder(double realHeight, boolean supportedHorisont) {
        this.realHeight = realHeight;
        this.supportedHorisont = supportedHorisont;
        this.verticalScale = calcVerticalScale(realHeight, supportedHorisont);
    }

    public static void setBottomHorisontType(boolean bottomHorisontOuter) {
        rebuildBoxBody(bottomHorisontOuter);
    }

    private double calcVerticalScale(double realHeight, boolean supportedHorisont) {
        Rectangle leftPanel = ElementsFinder.<Rectangle>findElementByID("leftPanel");
        return (leftPanel.getBoundsInParent().getMaxY() - leftPanel.getBoundsInParent().getMinY()) / (realHeight - (supportedHorisont ? Constants.PANEL_WIDTH_MM : 0));
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

    public void drawCorners(String formula, CupBoard cupBoard) {

        if (formula.isBlank()) {
            return;
        }

        DoubleEvaluator doubleEvaluator = new DoubleEvaluator();
        Double cornerDimention = doubleEvaluator.evaluate(formula);

        Rectangle bottomPanel = ElementsFinder.<Rectangle>findElementByID("bottomHorisont");
        Rectangle leftPanel = ElementsFinder.<Rectangle>findElementByID("leftPanel");
        Rectangle rightPanel = ElementsFinder.<Rectangle>findElementByID("rightPanel");

        List<Double> imageChain = ShelfImageBuilder.createImageDimentionChain(cupBoard.getDimentionChain(), verticalScale);
        double imageTopOffset = Constants.CORNER_TOP_OFFSET_MM * verticalScale;
        double y = leftPanel.getBoundsInParent().getMaxY() - imageChain.get(imageChain.size() - 1) + imageTopOffset;
        double imageBottomOffset = bottomPanel.getBoundsInParent().getMinY() - y;
        if (imageBottomOffset < Constants.CORNER_MIN_BOTTOM_OFFSET) {
            y = bottomPanel.getBoundsInParent().getMinY() - Constants.CORNER_MIN_BOTTOM_OFFSET;
        }

        double leftX = leftPanel.getBoundsInParent().getMaxX() + Constants.CORNER_SIDE_PANEL_OFFSET;
        double rightX = rightPanel.getBoundsInParent().getMinX() - Constants.CORNER_SIDE_PANEL_OFFSET;

        double lineLenth = Constants.CORNER_LENTH;

        CornerImage leftCorner = new CornerImage(new Dot(leftX, y), lineLenth, -lineLenth);
        CornerImage rightCorner = new CornerImage(new Dot(rightX, y), -lineLenth, -lineLenth);

        leftCorner.draw();
        rightCorner.draw();

        String textValue;
        if (cornerDimention % 1 == 0) {
            textValue = String.format("%.0f", cornerDimention);
        }
        else {
            textValue = String.format("%.1f", cornerDimention);
        }

        Text cornerText = new Text(leftX, y, textValue);
        cornerText.setWrappingWidth(rightX - leftX);
        cornerText.setTextAlignment(TextAlignment.CENTER);
        cornerText.setTextOrigin(VPos.BOTTOM);
        cornerText.setFont(Font.font(Constants.TEXT_HEIGHT));
        if (Constants.TEXT_BOLD) {
            cornerText.setStyle("-fx-font-weight: bold");
        }
        else {
            cornerText.setStyle("-fx-font-weight: regular");
        }

        ShelfImageBuilder.addElementToImage(cornerText);
        
    }

}
