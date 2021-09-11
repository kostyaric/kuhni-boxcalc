package org.stilkuhni.model.shelves;

import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.shelves.BottomShelfImage;

public class BottomShelf extends MiddleShelf{

    private double bottomDistance;

    public BottomShelf(double topDistance, double previousTop, double bottomDistance) {
        super(topDistance, previousTop);
        this.bottomDistance = bottomDistance;
    }

    public double getBottomDistance() {
        return bottomDistance;
    }

    @Override
    public Image createImage() {
        return new BottomShelfImage();
    }
}
