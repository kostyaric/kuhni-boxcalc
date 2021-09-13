package org.stilkuhni.ui.shelves.builders;

import javafx.scene.shape.Rectangle;
import org.stilkuhni.model.shelves.Shelf;
import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.shelves.ShelfImage;

public class ShelfImageBuilder {

    public static void buildShelfImage(Shelf modelShelf, ShelfImage imageShelf, double verticalScale) {

/*
        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");
        double neighbourDist = modelShelf.getNeighbourDistance();

        double topDistancePixel = modelShelf.getTopDistance() * verticalScale;
        double topY = topPanel.getBoundsInParent().getMinY();

        double baseDotY = topDistancePixel + topY;
        double baseDotX = topPanel.getBoundsInParent().getMaxX();
*/

        imageShelf.setRealNeighbourDistance(modelShelf.getNeighbourDistance());
        imageShelf.setBaseDot(createBaseDot(modelShelf, imageShelf, verticalScale));
        imageShelf.setTopDot(createTopDot(modelShelf, imageShelf, verticalScale));

    }

    public static Dot createBaseDot(Shelf modelShelf, ShelfImage imageShelf, double verticalScale) {

        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");

        double topDistancePixel = modelShelf.getTopDistance() * verticalScale;
        double topY = topPanel.getBoundsInParent().getMinY();

        double baseDotY = topDistancePixel + topY;
        double baseDotX = topPanel.getBoundsInParent().getMaxX();

        return new Dot(baseDotX, baseDotY);

    }

    public static Dot createTopDot(Shelf modelShelf, ShelfImage imageShelf, double verticalScale) {

        double topDotX;
        double topDotY;

        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");
        topDotX = topPanel.getBoundsInParent().getMaxX();

        if (modelShelf.getShelfType() == ShelfType.TOP) {
            topDotY = topPanel.getBoundsInParent().getMinY();
        }
        else {
            double topY = topPanel.getBoundsInParent().getMinY();
            topDotY = topY + (modelShelf.getTopDistance() - modelShelf.getNeighbourDistance()) * verticalScale;
        }

        return new Dot(topDotX, topDotY);

    }

}
