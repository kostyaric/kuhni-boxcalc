package org.stilkuhni.model.shelves;

public class MiddleShelf extends Shelf {

    public MiddleShelf(double topDistance, Shelf previousShelf) {
        this.topDistance = topDistance;
        this.neighbourDistance = topDistance - previousShelf.getTopDistance();
    }




}
