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
    protected double realNeighbourDistance;

    public Dot getBaseDot() {
        return baseDot;
    }

    public void setRealNeighbourDistance(double realNeighbourDistance) {
        this.realNeighbourDistance = realNeighbourDistance;
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
        drawExtLineFromDot(baseDot);
    }

    protected void drawExtLineFromDot(Dot dot) {
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        double x = dot.getX();
        double y = dot.getY();

        Line extLine = new Line(x, y, x + Constants.EXT_LINE_LENTH_PIXEL, y);
        extLine.setStrokeWidth(Constants.DIM_LINE_WIDTH_PIXEL);

        shelvesGroup.getChildren().add(extLine);
    }

    protected void drawBasicDimentionLine() {
        drawDimLineFromDotsPaire(baseDot, topDot);
    }

    protected void drawDimLineFromDotsPaire(Dot startDot, Dot endDot) {
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        double x = startDot.getX() + Constants.EXT_LINE_LENTH_PIXEL - Constants.DIM_LINE_OFFSET;

        Line dimLine = new Line(x, startDot.getY(), x, endDot.getY());
        dimLine.setStrokeWidth(Constants.DIM_LINE_WIDTH_PIXEL);

        shelvesGroup.getChildren().add(dimLine);
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
