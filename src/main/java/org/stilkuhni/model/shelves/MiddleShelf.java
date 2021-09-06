package org.stilkuhni.model.shelves;

public class MiddleShelf extends Shelf {

    public MiddleShelf(double topDistance, double previousTop) {
        this.topDistance = topDistance;
        this.neighbourDistance = topDistance - previousTop;
    }


}
