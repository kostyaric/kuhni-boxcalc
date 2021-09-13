package org.stilkuhni.ui.shelves;

import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.primitiv.Dot;

public class BottomShelfImage extends ShelfImage implements Image {

    protected ShelfType shelfType = ShelfType.BOTTOM;
    private Dot bottomDot;
    private double realBottomDistance;

    protected void drawBottomExtLine () {

    }

    protected void drawBottomDimentionLine () {

    }

    @Override
    public void draw() {
        super.draw();
    }
}
