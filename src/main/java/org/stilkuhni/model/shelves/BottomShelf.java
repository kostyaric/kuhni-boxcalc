package org.stilkuhni.model.shelves;

public class BottomShelf extends MiddleShelf{

    private double bottomDistance;

    public BottomShelf(double topDistance, double previousTop, double bottomDistance) {
        super(topDistance, previousTop);
        this.bottomDistance = bottomDistance;
    }

    public double getBottomDistance() {
        return bottomDistance;
    }

}
