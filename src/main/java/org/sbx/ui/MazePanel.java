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
    private int cellSize = 20;
    private Maze maze;

    public void setMaze(Maze maze){
        this.maze = maze;
    }

    public void initPlayer(){
        VisualPlayer player = new VisualPlayer();
        //player.setCoords(x0, y0);
        player.setDimension(cellSize / 3, cellSize / 3);
        player.init();
        add(player.getPlayer());
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int x0 = 5;
        int y0 = 5;
        int x = x0;
        int y = y0;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(2));
        Rectangle2D rect = new Rectangle2D.Double(x0, y0, cellSize * maze.getSize(), cellSize * maze.getSize());
        int counter = 0;
        for (Room room: maze.getRooms()){
            if ((counter != 0) && (counter % maze.getSize() == 0)){
                x = x0;
                y += cellSize;
            }
            for (Map.Entry<Direction, Site> entry: room.getSites().entrySet()){
                switch (entry.getKey()){
                    case NORTH:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)) {
                            Line2D line = new Line2D.Double(x, y, x + cellSize, y);
                            g2d.draw(line);
                        }
                        break;
                    case EAST:
                        if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                            Line2D line = new Line2D.Double(x + cellSize, y, x + cellSize, y + cellSize);
                            g2d.draw(line);
                        }
                        break;
                    case SOUTH:
                            if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                                Line2D line = new Line2D.Double(x, y + cellSize, x + cellSize, y + cellSize);
                                g2d.draw(line);
                            }
                        break;
                    case WEST:
                            if (entry.getValue().toString().contains(Classes.CLASS_WALL)){
                                Line2D line = new Line2D.Double(x, y, x, y + cellSize);
                                g2d.draw(line);
                            }
                        break;
                }
            }
            x += cellSize;
            counter++;
        }
        g2d.draw(rect);
        g2d.setColor(Color.red);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
