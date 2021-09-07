package org.stilkuhni.model.cupboards;

import org.stilkuhni.Constants;
import org.stilkuhni.model.shelves.BottomShelf;
import org.stilkuhni.model.shelves.MiddleShelf;
import org.stilkuhni.model.shelves.Shelf;
import org.stilkuhni.model.shelves.TopShelf;

import java.util.ArrayList;
import java.util.List;

public class CupBoard {

    private double height;
    private List<Shelf> shelves;
    private boolean basicHorisont;

    public CupBoard(double height, List<Double> shelvesDistnce, boolean basicHorisont) {
        this.height = height;
        this.basicHorisont = basicHorisont;
        this.shelves = createShelves(shelvesDistnce);
    }

    private List<Shelf> createShelves(List<Double> shelvesDistnce) {

        List<Shelf> shelfList = new ArrayList<>();
        int shelvesCount = shelvesDistnce.size();
        double prevTopDistance = 0;

        for (int i = 0; i < shelvesCount; i++) {

            double topDistance = shelvesDistnce.get(i);

            if (i == 0) {
                shelfList.add(new TopShelf(topDistance));
            }
            else if (i == shelvesCount - 1) {
                double bottomDistance = height - topDistance - (basicHorisont ? Constants.PANEL_WIDTH_MM : 0);
                shelfList.add(new BottomShelf(topDistance, prevTopDistance, bottomDistance));
            }
            else {
                shelfList.add(new MiddleShelf(topDistance, prevTopDistance));
            }

            prevTopDistance = topDistance;

        }

        return shelfList;

    }

    public void drawShelves() {

    }

}
