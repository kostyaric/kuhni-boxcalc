package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.shelves.MiddleShelfImage;
import org.stilkuhni.ui.shelves.ShelfImage;

public class MiddleShelf extends Shelf {

//    private static final ShelfType shelfType = ShelfType.MIDDLE;

    public MiddleShelf(double topDistance, double previousTop) {
        this.topDistance = topDistance;
        this.neighbourDistance = topDistance - previousTop;
        this.shelfType = ShelfType.MIDDLE;
    }

    @Override
    public ShelfImage createImage() {
        return new MiddleShelfImage();
    }
}
