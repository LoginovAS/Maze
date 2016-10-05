package org.sbx.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aloginov on 05.10.16.
 */
public class VisualWall extends JPanel{

    private int x1, x2, y1, y2;

    public void setCoords(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    protected void paintComponent(Graphics g){

    }
}
