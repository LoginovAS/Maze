package org.sbx.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by aloginov on 10.10.16.
 */
public class VisualPanel extends JPanel {

    private static final Logger logger = LogManager.getLogger(VisualPanel.class);

    private int x0 = 5;
    private int y0 = 5;
    private int x = x0;
    private int y = y0;
    private int width = 20;
    private int height = 20;
    private Graphics2D g2d;


    private Maze maze;

    public void setMaze(Maze maze){
        this.maze = maze;
    }

    public void initPlayer(){
        VisualPlayer player = new VisualPlayer();
        player.setCoords(x0, y0);
        player.setDimension(width / 3, height / 3);
        player.init();
        add(player.getPlayer());
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.g2d = (Graphics2D) g;
        setView(g2d);
        int counter = 0;
        for (Room room: maze.getRooms()){
            if ((counter != 0) && (counter % maze.getSize() == 0)){
                x = x0;
                y += height;
            }

            VisualRoom visualRoom = new VisualRoom();
            visualRoom.setObject(room);
            visualRoom.setCoords(x, y);
            visualRoom.setDimentions(width, height);
            visualRoom.build();
            for (Line2D line2D: visualRoom.getLines())
                g2d.draw(line2D);
            x+=width;
            counter++;
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    private void setView(Graphics2D g2d){
        this.g2d.setColor(Color.blue);
        this.g2d.setStroke(new BasicStroke(2));
        this.setLayout(null);
    }
}
