package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.shelves.TopShelfImage;

public class TopShelf extends Shelf {

    public TopShelf(double topDistance) {
        this.topDistance = topDistance;
        this.neighbourDistance = topDistance;
    }

    @Override
    public Image createImage() {
        return new TopShelfImage();
    }
}
