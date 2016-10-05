package org.sbx.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.abstracts.Site;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aloginov on 05.10.16.
 */
public class MazePanel extends JPanel {

    private static final Logger logger = LogManager.getLogger(MazePanel.class);
    private Maze maze;

    public void setMaze(Maze maze){
        this.maze = maze;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int x0 = 5;
        int y0 = 5;
        int x = x0;
        int y = y0;
        final int cellSize = 20;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(2));
        System.out.println(maze.getSize());
        Rectangle2D rect = new Rectangle2D.Double(x0, y0, cellSize * maze.getSize(), cellSize * maze.getSize());
        ArrayList<Line2D> lines = new ArrayList<Line2D>();
        int counter = 0;
        for (Room room: maze.getRooms()){
            x += cellSize;
            if (counter % maze.getSize() == 0){
                x = x0;
                y += cellSize;
            }
            for (Map.Entry<Direction, Site> entry: room.getSites().entrySet()){
                switch (entry.getKey()){
                    case NORTH:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)) {
                            Line2D line = new Line2D.Double(x, y, x + cellSize, y);
                            lines.add(line);
                        }
                    case EAST:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                            Line2D line = new Line2D.Double(x + cellSize, y, x + cellSize, y + cellSize);
                            lines.add(line);
                        }
                    case SOUTH:
                            if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                                Line2D line = new Line2D.Double(x, y + cellSize, x + cellSize, y + cellSize);
                                lines.add(line);
                            }
                    case WEST:
                            if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                                Line2D line = new Line2D.Double(x, y, x, y + cellSize);
                                lines.add(line);
                            }
                }
            }
            counter++;
        }
        g2d.draw(rect);
        g2d.setColor(Color.red);
        for (Line2D line: lines)
            g2d.draw(line);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
