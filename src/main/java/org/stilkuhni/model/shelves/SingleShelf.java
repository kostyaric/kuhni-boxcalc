package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.shelves.ShelfImage;
import org.stilkuhni.ui.shelves.SingleShelfImage;

public class SingleShelf extends BottomShelf {


    public SingleShelf(double topDistance, double previousTop, double bottomDistance) {
        super(topDistance, previousTop, bottomDistance);
        this.shelfType = ShelfType.SINGLE;
    }

    public double getBottomDistance() {
        return bottomDistance;
    }

    @Override
    public ShelfImage createImage() {
        return new SingleShelfImage();
    }
}
