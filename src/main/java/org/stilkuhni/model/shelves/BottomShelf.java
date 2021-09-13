package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.shelves.BottomShelfImage;
import org.stilkuhni.ui.shelves.ShelfImage;

public class BottomShelf extends MiddleShelf {

    protected double bottomDistance;

    public BottomShelf(double topDistance, double previousTop, double bottomDistance) {
        super(topDistance, previousTop);
        this.bottomDistance = bottomDistance;
        this.shelfType = ShelfType.BOTTOM;
    }

    public double getBottomDistance() {
        return bottomDistance;
    }

    @Override
    public ShelfImage createImage() {
        return new BottomShelfImage();
    }
}
