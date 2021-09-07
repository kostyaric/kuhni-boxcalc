package org.stilkuhni.ui.shelves;

import org.stilkuhni.ui.Draw;
import org.stilkuhni.ui.primitiv.Dot;

public class MiddleImage implements Draw {

    protected Dot baseDot;
    protected Dot topDot;
    protected double realTopDistance;

    protected void drawShelfBody() {

    }

    protected void drawBasicExtLine () {

    }

    protected void drawBasicDimentionLine() {

    }

    protected void drawBaseText() {

    }

    @Override
    public void draw() {
        drawShelfBody();
        drawBasicExtLine();
        drawBasicDimentionLine();
        drawBaseText();
    }

}
