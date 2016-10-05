package org.sbx.ui;

import org.sbx.objects.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by aloginov on 05.10.16.
 */
public class MazePanel extends JPanel {

    private Maze maze;

    public void setMaze(Maze maze){
        this.maze = maze;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        final int x0 = 5;
        final int y0 = 5;
        final int cellSize = 10;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(6));
        Rectangle2D rect = new Rectangle2D.Double(x0, y0, cellSize * maze.getSize(), cellSize * maze.getSize());
        g2d.draw(rect);
    }

    public Dimension getPreferredSize() {
        return new Dimension(110, 110);
    }
}
