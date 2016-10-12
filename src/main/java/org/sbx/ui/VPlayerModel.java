package org.sbx.ui;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by aloginov on 12.10.16.
 */
public class VPlayerModel {

    private int x, y, w, h;

    public void setBounds(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
        g2d.draw(ellipse);
    }
}
