package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.shelves.ShelfImage;
import org.stilkuhni.ui.shelves.ShelfType;
import org.stilkuhni.ui.shelves.TopShelfImage;

public class TopShelf extends Shelf {

//    private static final ShelfType shelfType = ShelfType.TOP;

    public TopShelf(double topDistance) {
        this.topDistance = topDistance;
        this.neighbourDistance = topDistance;
        this.shelfType = ShelfType.TOP;
    }

    @Override
    public ShelfImage createImage() {
        return new TopShelfImage();
    }
}
