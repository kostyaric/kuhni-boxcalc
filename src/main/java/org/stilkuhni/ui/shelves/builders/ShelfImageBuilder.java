package org.stilkuhni.ui.shelves.builders;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import org.stilkuhni.Constants;
import org.stilkuhni.model.shelves.BottomShelf;
import org.stilkuhni.model.shelves.Shelf;
import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.shelves.BottomShelfImage;
import org.stilkuhni.ui.shelves.ShelfImage;

import java.util.ArrayList;
import java.util.List;

public class ShelfImageBuilder {

    public static void buildShelfImage(Shelf modelShelf, double topDistance, double neighbourDistance) {

        ShelfImage imageShelf = modelShelf.createImage();
        imageShelf.setRealNeighbourDistance(modelShelf.getNeighbourDistance());
        imageShelf.setBaseDot(createBaseDot(modelShelf, topDistance));
        imageShelf.setTopDot(createTopDot(modelShelf, topDistance, neighbourDistance));
        if (modelShelf.getShelfType() == ShelfType.BOTTOM || modelShelf.getShelfType() == ShelfType.SINGLE) {
            ((BottomShelfImage) imageShelf).setBottomDot(createBottomDot());
            ((BottomShelfImage) imageShelf).setRealBottomDistance(((BottomShelf) modelShelf).getBottomDistance());
        }
        imageShelf.draw();
    }


    public static void buidShelvesImages(List<Shelf> shelves, List<Double> dimentionChain, double verticalScale) {

        List<Double> imageChain = createImageDimentionChain(dimentionChain, verticalScale);
        double topImageDistance = 0;

        for (int i = 0; i < shelves.size(); i++) {
            Shelf shelf = shelves.get(i);
            double neihbourImageDistance = imageChain.get(i);
            topImageDistance += neihbourImageDistance;
            buildShelfImage(shelf, topImageDistance, neihbourImageDistance);
        }

    }

    private static List<Double> createImageDimentionChain(List<Double> realChain, double scale) {
        List<Double> imageChain = new ArrayList<>();
        double minDistance = Constants.MINIMUM_DIST_BETWEEN_SHELVES;
        double unchangeDistance = Constants.UNCHANGEABLE_DIST_BETWEEN_SHELVES;
        List<Integer> distributionIndexes = new ArrayList<>();
        double distributionTail = 0;
        double distributionLenth = 0;
        int count = 0;

        for (Double realDistance : realChain) {
            double imageDistance = realDistance * scale;
            if (imageDistance < minDistance) {
                imageChain.add(minDistance);
                distributionTail += minDistance - imageDistance;
            } else {
                imageChain.add(imageDistance);
                if (imageDistance > unchangeDistance) {
                    distributionIndexes.add(count);
                    distributionLenth += imageDistance;
                }
            }
            count++;
        }

        for (int i = 0; i < distributionIndexes.size(); i++) {
            int index = distributionIndexes.get(i);
            double currentDist = imageChain.get(index);
            if (i == distributionIndexes.size() - 1) {
                imageChain.set(index, currentDist - distributionTail);
                distributionTail = 0;
            } else {
                double currentDelta = distributionTail / distributionLenth * currentDist;
                imageChain.set(index, currentDist - currentDelta);
                distributionTail -= currentDelta;
                distributionLenth -= currentDist;
            }

        }

        return imageChain;
    }

    public static Dot createBaseDot(Shelf modelShelf, double topDistance) {

        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");

        double topY = topPanel.getBoundsInParent().getMinY();
        double baseDotY = topY + topDistance;
        double baseDotX = topPanel.getBoundsInParent().getMaxX();

        return new Dot(baseDotX, baseDotY);

    }

    public static Dot createTopDot(Shelf modelShelf, double topDistance, double neighbourDistance) {

        Rectangle topPanel = ElementsFinder.<Rectangle>findElementByID("topHorisont");
        double topDotX = topPanel.getBoundsInParent().getMaxX();
        double topDotY = topPanel.getBoundsInParent().getMinY() + topDistance - neighbourDistance;

        return new Dot(topDotX, topDotY);
    }

    public static Dot createBottomDot() {
        Rectangle rightPanel = ElementsFinder.<Rectangle>findElementByID("rightPanel");
        double bottomDotX = rightPanel.getBoundsInParent().getMinX();
        double bottomDotY = rightPanel.getBoundsInParent().getMaxY();

        return new Dot(bottomDotX, bottomDotY);
    }

    public static void addElementToImage(Node node) {
        Group shelvesGroup = ElementsFinder.<Group>findElementByID("shelvesGroup");
        shelvesGroup.getChildren().add(node);
    }
}
