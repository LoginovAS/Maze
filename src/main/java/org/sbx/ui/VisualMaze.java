package org.sbx.ui;

import org.sbx.abstracts.Site;
import org.sbx.interfaces.Buildable;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aloginov on 10.10.16.
 */
public class VisualMaze implements Buildable{

    private Maze maze;
    private int x0, y0, x, y, cellSize;
    private ArrayList<ArrayList<Line2D>> visualMazeArray;
    private ArrayList<Line2D> visualRoomsArray;
    private Graphics2D graphics2D;

    public VisualMaze(Maze maze){
        this.maze = maze;
    }

    public void initMaze(int x0, int y0, int cellSize){
        this.x0 = x0;
        this.y0 = y0;
        this.cellSize = cellSize;
    }

    public void initGraphics(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        this.graphics2D.setColor(Color.blue);
        this.graphics2D.setStroke(new BasicStroke(2));
    }

    public void constructVisualMaze(){
        int counter = 0;
        x = x0;
        y = y0;
        visualMazeArray = new ArrayList<ArrayList<Line2D>>();
        for (Room room: maze.getRooms()){
            visualRoomsArray = new ArrayList<Line2D>();
            if ((counter != 0) && (counter % maze.getSize() == 0)){
                x = x0;
                y += cellSize;
            }
            for (Map.Entry<Direction, Site> entry: room.getSites().entrySet()){
                switch (entry.getKey()){
                    case NORTH:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)) {
                            Line2D line = new Line2D.Double(x, y, x + cellSize, y);
                            visualRoomsArray.add(line);
                        }
                        break;
                    case EAST:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                            Line2D line = new Line2D.Double(x + cellSize, y, x + cellSize, y + cellSize);
                            visualRoomsArray.add(line);
                        }
                        break;
                    case SOUTH:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                            Line2D line = new Line2D.Double(x, y + cellSize, x + cellSize, y + cellSize);
                            visualRoomsArray.add(line);
                        }
                        break;
                    case WEST:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                            Line2D line = new Line2D.Double(x, y, x, y + cellSize);
                            visualRoomsArray.add(line);
                        }
                        break;
                }
            }
            if (room.getClass().toString().contains(Classes.CLASS_FINISH_ROOM)){
                Rectangle2D rectangle2D = new Rectangle2D.Double(x, y, cellSize, cellSize);
                graphics2D.setColor(Color.YELLOW);
                graphics2D.fill(rectangle2D);
                graphics2D.draw(rectangle2D);

            }
            visualMazeArray.add(visualRoomsArray);
            x += cellSize;
            counter++;
        }
    }

    public void draw(){
        graphics2D.setColor(Color.BLUE);
        for (ArrayList<Line2D> rooms: visualMazeArray)
            for (Line2D line: rooms)
                graphics2D.draw(line);

    }
}
