package org.stilkuhni.ui.corners;

import org.stilkuhni.Constants;
import org.stilkuhni.ui.Image;
import org.stilkuhni.ui.primitiv.Dot;
import org.stilkuhni.ui.primitiv.HLine;
import org.stilkuhni.ui.primitiv.VLine;

public class CornerImage implements Image {

    private Dot baseDot;
    private double deltaX;
    private double deltaY;

    public CornerImage(Dot baseDot, double deltaX, double deltaY) {
        this.baseDot = baseDot;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }


    @Override
    public void draw() {
        VLine vLine = new VLine(baseDot, deltaY, Constants.CORNER_LINE_WIDTH);
        HLine hLine = new HLine(baseDot, deltaX, Constants.CORNER_LINE_WIDTH);
        vLine.draw();
        hLine.draw();
    }
}
