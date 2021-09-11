package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.shelves.MiddleShelfImage;

public class MiddleShelf extends Shelf {

    public MiddleShelf(double topDistance, double previousTop) {
        this.topDistance = topDistance;
        this.neighbourDistance = topDistance - previousTop;
    }

    @Override
    public Image createImage() {
        return new MiddleShelfImage();
    }
}
