package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;

abstract public class Shelf {

    protected double topDistance;
    protected double neighbourDistance;

    public double getTopDistance() {
        return topDistance;
    }

    public double getNeighbourDistance() {
        return neighbourDistance;
    }

    abstract public Image createImage();

}
