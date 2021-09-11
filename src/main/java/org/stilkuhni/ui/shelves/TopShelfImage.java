package org.stilkuhni.ui.shelves;

import org.stilkuhni.ui.Image;

public class TopShelfImage extends MiddleShelfImage implements Image {

    private void drawTopExtLine () {

    }

    @Override
    public void draw() {
        super.draw();
        drawTopExtLine();
    }
}
