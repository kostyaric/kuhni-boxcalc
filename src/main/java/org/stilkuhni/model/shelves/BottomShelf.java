package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.shelves.BottomShelfImage;
import org.stilkuhni.ui.shelves.ShelfImage;
import org.stilkuhni.ui.shelves.ShelfType;

public class BottomShelf extends MiddleShelf{

//    private static final ShelfType shelfType = ShelfType.BOTTOM;
    private double bottomDistance;

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
