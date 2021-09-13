package org.stilkuhni.ui.shelves;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import org.stilkuhni.Constants;
import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;

public class ShelfImage implements Image {

    protected Dot baseDot;
    protected Dot topDot;
    protected double realTopDistance;

    public Dot getBaseDot() {
        return baseDot;
    }

    public void setRealTopDistance(double realTopDistance) {
        this.realTopDistance = realTopDistance;
    }

    public void setBaseDot(Dot baseDot) {
        this.baseDot = baseDot;
    }

    public Dot getTopDot() {
        return topDot;
    }

    public void setTopDot(Dot topDot) {
        this.topDot = topDot;
    }

    protected void drawShelfBody() {
        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");

        double minX = topPanel.getBoundsInParent().getMinX();
        double minY = baseDot.getY() - Constants.PANEL_WIDTH_PIXEL / 2;

        Rectangle shelf = new Rectangle(minX, minY, topPanel.getWidth(), Constants.PANEL_WIDTH_PIXEL);
        shelf.setFill(Color.WHITE);
        shelf.setStroke(Color.BLACK);
        shelf.setStrokeWidth(Constants.BASE_LINE_WIDTH_PIXEL);
        shelf.setStrokeType(StrokeType.INSIDE);

        shelvesGroup.getChildren().add(shelf);
    }

    protected void drawBasicExtLine () {

        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");

        Line extLine = new Line(baseDot.getX(), baseDot.getY(), baseDot.getX() + Constants.EXT_LINE_LENTH_PIXEL, baseDot.getY());
        extLine.setStrokeWidth(Constants.DIM_LINE_WIDTH_PIXEL);

        shelvesGroup.getChildren().add(extLine);
    }

    protected void drawBasicDimentionLine() {

    }

    protected void drawBaseText() {

    }

    @Override
    public void draw() {
        drawShelfBody();
        drawBasicExtLine();
        drawBasicDimentionLine();
        drawBaseText();
    }

}
