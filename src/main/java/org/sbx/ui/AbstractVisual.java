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
    protected int cellsCountX;
    protected int cellsCountY;
    protected int cellSize;

    public void setDimension(int width, int height, int cellsCountX, int cellsCountY, int cellSize){
        this.width = width;
        this.height = height;
        this.cellsCountX = cellsCountX;
        this.cellsCountY = cellsCountY;
        this.cellSize = cellSize;
    }

    protected int getX0(){
        return x0;
    }

    protected int getY0(){
        return y0;
    }

    protected int getVisualXById(int id){
        x = id % cellsCountX;
        return x0 + (cellSize * x);
    }

    protected int getVisualYById(int id){
        y = id / cellsCountY;
        return y0 + (cellSize * y);
    }
}
