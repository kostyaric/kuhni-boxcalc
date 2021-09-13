package org.stilkuhni.ui.shelves;

import org.stilkuhni.model.shelves.ShelfType;
import org.stilkuhni.ui.Image;

public class TopShelfImage extends ShelfImage implements Image {

    protected ShelfType shelfType = ShelfType.TOP;

    private void drawTopExtLine () {
        drawExtLineFromDot(topDot);
    }

    @Override
    public void draw() {
        super.draw();
        drawTopExtLine();
    }
}
