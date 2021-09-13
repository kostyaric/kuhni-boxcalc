package org.stilkuhni.ui.shelves;

import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.primitiv.Dot;

public class BottomShelfImage extends ShelfImage implements Image {

    protected ShelfType shelfType = ShelfType.BOTTOM;
    protected Dot bottomDot;
    protected double realBottomDistance;

    public Dot getBottomDot() {
        return bottomDot;
    }

    public void setBottomDot(Dot bottomDot) {
        this.bottomDot = bottomDot;
    }

    public double getRealBottomDistance() {
        return realBottomDistance;
    }

    public void setRealBottomDistance(double realBottomDistance) {
        this.realBottomDistance = realBottomDistance;
    }

    protected void drawBottomExtLine () {
        drawExtLineFromDot(bottomDot);
    }

    protected void drawBottomDimentionLine () {

    }

    @Override
    public void draw() {
        super.draw();
        drawBottomExtLine();
        drawBottomDimentionLine();
    }
}
