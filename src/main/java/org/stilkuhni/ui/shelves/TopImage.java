package org.stilkuhni.ui.shelves;

import org.stilkuhni.ui.Draw;

public class TopImage extends MiddleImage implements Draw {

    private void drawTopExtLine () {

    }

    @Override
    public void draw() {
        super.draw();
        drawTopExtLine();
    }
}
