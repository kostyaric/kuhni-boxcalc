package org.stilkuhni.ui.primitiv;

import javafx.scene.shape.Line;
import org.stilkuhni.ui.shelves.builders.ShelfImageBuilder;

public class HLine extends AxisLine {

    public HLine(Dot baseDot, double delta, int width) {
        super(baseDot, delta, width);
    }

    @Override
    public void draw() {
        double y = baseDot.getY();
        double startX = baseDot.getX();
        double endX = startX + delta;
        Line line = new Line(startX, y, endX, y);
        line.setStrokeWidth(widh);
        ShelfImageBuilder.addElementToImage(line);

    }
}
