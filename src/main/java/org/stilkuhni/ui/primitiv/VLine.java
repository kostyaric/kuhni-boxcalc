package org.stilkuhni.ui.primitiv;

import javafx.scene.shape.Line;
import org.stilkuhni.ui.shelves.builders.ShelfImageBuilder;

public class VLine extends AxisLine {

    public VLine(Dot baseDot, double delta, int width) {
        super(baseDot, delta, width);
    }

    @Override
    public void draw() {
        double x = baseDot.getX();
        double startY = baseDot.getY();
        double endY = startY + delta;
        Line line = new Line(x, startY, x, endY);
        line.setStrokeWidth(widh);
        ShelfImageBuilder.addElementToImage(line);
    }
}
