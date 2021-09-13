package org.stilkuhni.ui.shelves;

import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.primitiv.Dot;

public class SingleShelfImage extends BottomShelfImage implements Image {

    protected ShelfType shelfType = ShelfType.SINGLE;

    private void drawTopExtLine () {
        drawExtLineFromDot(topDot);
    }

    @Override
    public void draw() {
        super.draw();
        drawTopExtLine();
    }
}
