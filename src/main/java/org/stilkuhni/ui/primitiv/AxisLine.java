package org.stilkuhni.ui.primitiv;

import org.stilkuhni.ui.Image;

public abstract class AxisLine implements Image {

    protected Dot baseDot;
    protected double delta;
    protected int widh;

    public AxisLine(Dot baseDot, double delta, int widh) {
        this.baseDot = baseDot;
        this.delta = delta;
        this.widh = widh;
    }

    @Override
    abstract public void draw();

}
