package org.stilkuhni.ui.shelves;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import org.stilkuhni.Constants;
import org.stilkuhni.ui.BoxImageBuilder;
import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.shelves.builders.ShelfImageBuilder;

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
        shelvesGroup.getChildren().add(shelf);
    }

    protected void drawBasicExtLine () {

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
