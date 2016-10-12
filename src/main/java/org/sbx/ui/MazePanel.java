package org.sbx.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.builders.VisualMazeBuilder;
import org.sbx.objects.Maze;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aloginov on 05.10.16.
 */
public class MazePanel extends JPanel {

    private static final Logger logger = LogManager.getLogger(MazePanel.class);

    private final int CELL_SIZE = 40;
    private final int X0 = 5;
    private final int Y0 = 5;

    private Maze maze;

    public void setMaze(Maze maze){
        this.maze = maze;
    }

    public void initPlayer(){
        VisualPlayer player = new VisualPlayer();
        player.setDimension(CELL_SIZE / 2, CELL_SIZE / 2, maze.getSize(), maze.getSize(), CELL_SIZE);
        player.init();
        add(player.getPlayer());
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        VisualMazeBuilder visualMazeBuilder = new VisualMazeBuilder();
        visualMazeBuilder.initVisualMaze(maze);
        visualMazeBuilder.descVisualParameters(X0, Y0, CELL_SIZE, g2d);
        ((VisualMaze) visualMazeBuilder.build()).draw();
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
