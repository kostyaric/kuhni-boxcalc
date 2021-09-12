package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.shelves.ShelfImage;
import org.stilkuhni.ui.shelves.ShelfType;

abstract public class Shelf {

    protected double topDistance;
    protected double neighbourDistance;
    protected ShelfType shelfType;

    public double getTopDistance() {
        return topDistance;
    }

    public double getNeighbourDistance() {
        return neighbourDistance;
    }

    abstract public ShelfImage createImage();

}
