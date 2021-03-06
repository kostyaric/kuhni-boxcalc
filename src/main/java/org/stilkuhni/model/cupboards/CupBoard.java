package org.stilkuhni.model.cupboards;

import org.stilkuhni.Constants;
import org.stilkuhni.model.shelves.*;

import java.util.ArrayList;
import java.util.List;

public class CupBoard {

    private double height;
    private List<Shelf> shelves;
    private boolean basicHorisont;
    private List<Double> dimentionChain = new ArrayList<>();

    public CupBoard(double height, List<Double> shelvesDistnce, boolean basicHorisont) {
        this.height = height;
        this.basicHorisont = basicHorisont;
        this.shelves = createShelves(shelvesDistnce);
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public List<Double> getDimentionChain() {
        return dimentionChain;
    }

    private List<Shelf> createShelves(List<Double> shelvesDistnce) {

        List<Shelf> shelfList = new ArrayList<>();
        int shelvesCount = shelvesDistnce.size();
        double prevTopDistance = 0;

        for (int i = 0; i < shelvesCount; i++) {

            double topDistance = shelvesDistnce.get(i);
            dimentionChain.add(topDistance - prevTopDistance);

            if (i == shelvesCount - 1) {
                double bottomDistance = height - topDistance - (basicHorisont ? Constants.PANEL_WIDTH_MM : 0);
                if (shelvesCount == 1) {
                    shelfList.add(new SingleShelf(topDistance, prevTopDistance, bottomDistance));
                }
                else {
                    shelfList.add(new BottomShelf(topDistance, prevTopDistance, bottomDistance));
                }
                dimentionChain.add(bottomDistance);
            }
            else if (i == 0) {
                shelfList.add(new TopShelf(topDistance));
            }
            else {
                shelfList.add(new MiddleShelf(topDistance, prevTopDistance));
            }

            prevTopDistance = topDistance;

        }

        return shelfList;

    }

}
