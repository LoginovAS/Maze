package org.sbx.ui;

/**
 * Created by aloginov on 10.10.16.
 */
public abstract class AbstractVisual {
    protected int x0;
    protected int y0;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public void setDimension(int width, int height){
        this.width = width;
        this.height = height;
    }
}
