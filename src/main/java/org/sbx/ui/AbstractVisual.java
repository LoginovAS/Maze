package org.sbx.ui;

/**
 * Created by aloginov on 10.10.16.
 */
public abstract class AbstractVisual {
    protected int x0 = 5;
    protected int y0 = 5;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public void setDimension(int width, int height){
        this.width = width;
        this.height = height;
    }

    protected int getX0(){
        return x0;
    }

    protected int getY0(){
        return y0;
    }

    protected int getVisualXById(int id){
        x = id % width;
        return x0 + (width * x);
    }

    protected int getVisualYById(int id){
        y = id / height;
        return y0 + (height * y);
    }
}
