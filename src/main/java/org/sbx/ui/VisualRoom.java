package org.sbx.ui;

import org.sbx.abstracts.Site;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aloginov on 10.10.16.
 */
public class VisualRoom extends AbstractVisual{

    private Room room;
    private ArrayList<Line2D> lines = new ArrayList();

    private int x;
    private int y;
    private int width;
    private int height;

    public VisualRoom(){

    }

    public void setObject(Room room){
        this.room = room;
    }

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setDimentions(int width, int height){
        this.width = width;
        this.height = height;
    }

    private void construct(){
        for (Map.Entry<Direction, Site> entry: room.getSites().entrySet()){
            Site site = null;
            switch (entry.getKey()){
                case NORTH:
                    site = entry.getValue();
                    if (site.toString().contains(Classes.CLASS_WALL)) {
                        Line2D line = new Line2D.Double(x, y, x + width, y);
                        lines.add(line);
                    }
                    break;
                case EAST:
                    site = entry.getValue();
                    if (site.toString().contains(Classes.CLASS_WALL)){
                        Line2D line = new Line2D.Double(x + width, y, x + width, y + height);
                        lines.add(line);
                    }
                    break;
                case SOUTH:
                    site = entry.getValue();
                    if (site.toString().contains(Classes.CLASS_WALL)){
                        Line2D line = new Line2D.Double(x, y + height, x + width, y + height);
                        lines.add(line);
                    }
                    break;
                case WEST:
                    site = entry.getValue();
                    if (site.toString().contains(Classes.CLASS_WALL)){
                        Line2D line = new Line2D.Double(x, y, x, y + height);
                        lines.add(line);
                    }
                    break;
            }
        }
    }

    public void build(){
        construct();
    }

    public ArrayList<Line2D> getLines(){
        return lines;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
