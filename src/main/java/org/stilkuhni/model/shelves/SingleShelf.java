package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.shelves.BottomShelfImage;
import org.stilkuhni.ui.shelves.ShelfImage;

public class SingleShelf extends BottomShelf {

    protected ShelfType shelfType = ShelfType.SINGLE;

    public SingleShelf(double topDistance, double previousTop, double bottomDistance) {
        super(topDistance, previousTop, bottomDistance);
        this.bottomDistance = bottomDistance;
    }

    public double getBottomDistance() {
        return bottomDistance;
    }

/*
    @Override
    public ShelfImage createImage() {
        return new BottomShelfImage();
    }
*/
}
