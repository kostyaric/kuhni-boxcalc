package org.stilkuhni.ui.finders;

import org.stilkuhni.ui.BoxImageBuilder;

public class ElementsFinder {

    public static <T> T findElementByID(String elementID) {
        return (T) BoxImageBuilder.imageGroup.lookup("#" + elementID);
    }

}
