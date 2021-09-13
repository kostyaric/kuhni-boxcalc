package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.shelves.ShelfImage;

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

    public ShelfType getShelfType() {
        return shelfType;
    }

    abstract public ShelfImage createImage();

}
