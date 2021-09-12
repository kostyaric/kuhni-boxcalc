package org.stilkuhni.ui.shelves.builders;

import javafx.scene.shape.Rectangle;
import org.stilkuhni.model.shelves.Shelf;
import org.stilkuhni.ui.finders.ElementsFinder;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.shelves.ShelfImage;

import java.lang.reflect.Field;

public class ShelfImageBuilder {

    public static void buildShelfImage(Shelf modelShelf, ShelfImage imageShelf, double verticalScale) {

        double neighbourDist = modelShelf.getNeighbourDistance();
        imageShelf.setRealTopDistance(neighbourDist);

        double topDistance = modelShelf.getTopDistance() * verticalScale;
        Rectangle topHorisont = ElementsFinder.<Rectangle>findElementByID("topHorisont");
        double topY = topHorisont.getBoundsInParent().getMinY();

        int baseDotY = (int) (topDistance + topY);
        int baseDotX = (int) topHorisont.getBoundsInParent().getMaxX();

        imageShelf.setBaseDot(new Dot(baseDotX, baseDotY));

//        imageShelf.setTopDot(new Dot(baseDotX, ));

//        switch (imageShelf.)
    }

}
