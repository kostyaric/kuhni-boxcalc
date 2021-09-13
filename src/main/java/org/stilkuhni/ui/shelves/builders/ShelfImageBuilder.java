package org.stilkuhni.ui.shelves.builders;

import javafx.scene.shape.Rectangle;
import org.stilkuhni.model.shelves.BottomShelf;
import org.stilkuhni.model.shelves.Shelf;
import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.shelves.BottomShelfImage;
import org.stilkuhni.ui.shelves.ShelfImage;

public class ShelfImageBuilder {

    public static void buildShelfImage(Shelf modelShelf, ShelfImage imageShelf, double verticalScale) {

        imageShelf.setRealNeighbourDistance(modelShelf.getNeighbourDistance());
        imageShelf.setBaseDot(createBaseDot(modelShelf, imageShelf, verticalScale));
        imageShelf.setTopDot(createTopDot(modelShelf, imageShelf, verticalScale));
        if (modelShelf.getShelfType() == ShelfType.BOTTOM || modelShelf.getShelfType() == ShelfType.SINGLE) {
            ((BottomShelfImage) imageShelf).setBottomDot(createBottomDot());
            ((BottomShelfImage) imageShelf).setRealBottomDistance(((BottomShelf) modelShelf).getBottomDistance());
        }

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

    public static Dot createBottomDot() {
        Rectangle rightPanel = ElementsFinder.<Rectangle>findElementByID("rightPanel");
        double bottomDotX = rightPanel.getBoundsInParent().getMinX();
        double bottomDotY = rightPanel.getBoundsInParent().getMaxY();

        return new Dot(bottomDotX, bottomDotY);
    }
}
