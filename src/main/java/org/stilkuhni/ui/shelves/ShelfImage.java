package org.stilkuhni.ui.shelves;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        double minY = baseDot.getY() - Constants.PANEL_WIDTH / 2;

        Rectangle shelf = new Rectangle(minX, minY, topPanel.getWidth(), Constants.PANEL_WIDTH);
        shelf.setFill(Color.WHITE);
        shelf.setStroke(Color.BLACK);
        shelf.setStrokeWidth(Constants.BASE_LINE_WIDTH);
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

        Line extLine = new Line(x, y, x + Constants.EXT_LINE_LENTH, y);
        extLine.setStrokeWidth(Constants.DIM_LINE_WIDTH);

        shelvesGroup.getChildren().add(extLine);
    }

    protected void drawBasicDimentionLine() {
        drawDimLineFromDotsPaire(baseDot, topDot);
    }

    protected void drawDimLineFromDotsPaire(Dot startDot, Dot endDot) {
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        double x = startDot.getX() + Constants.EXT_LINE_LENTH - Constants.DIM_LINE_OFFSET;

        Line dimLine = new Line(x, startDot.getY(), x, endDot.getY());
        dimLine.setStrokeWidth(Constants.DIM_LINE_WIDTH);

        Circle startNock = new Circle(x, startDot.getY(), Constants.DIM_NOCK_RADIUS);
        Circle endNock = new Circle(x, endDot.getY(), Constants.DIM_NOCK_RADIUS);

        shelvesGroup.getChildren().add(dimLine);
        shelvesGroup.getChildren().add(startNock);
        shelvesGroup.getChildren().add(endNock);
    }

    protected void drawBaseText() {
        drawTextFromDotPair(baseDot, topDot, realNeighbourDistance);
    }

    protected void drawTextFromDotPair(Dot startDot, Dot endDot, double distance) {

        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        double x = startDot.getX() + Constants.EXT_LINE_LENTH - Constants.DIM_LINE_OFFSET;
        double y = (startDot.getY() + endDot.getY()) / 2;
        String textDist;
        if (distance % 1 == 0) {
            textDist = String.format("%.0f", distance);
        }
        else {
            textDist = String.format("%.1f", distance);
        }

        Text dimText = new Text(x, y, textDist);
        dimText.setRotate(-90);
        dimText.setWrappingWidth(Constants.TEXT_WRAPPING_WIDTH);
        dimText.setTextAlignment(TextAlignment.CENTER);
        dimText.setTextOrigin(VPos.CENTER);
        dimText.setFont(Font.font(Constants.TEXT_HEIGHT));
        if (Constants.TEXT_BOLD) {
            dimText.setStyle("-fx-font-weight: bold");
        }
        else {
            dimText.setStyle("-fx-font-weight: regular");
        }
        dimText.setLayoutX(Constants.TEXT_DIM_LINE_OFFSET * Constants.TEXT_HEIGHT);

        shelvesGroup.getChildren().add(dimText);

    }

    @Override
    public void draw() {
        drawShelfBody();
        drawBasicExtLine();
        drawBasicDimentionLine();
        drawBaseText();
    }

}
