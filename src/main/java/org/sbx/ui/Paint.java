package org.sbx.ui;

import org.sbx.objects.Maze;

import java.awt.*;

/**
 * Created by aloginov on 05.10.16.
 */
public class Paint {
    public Paint(Maze maze){
        MazePanel mazePanel = new MazePanel();
        MazeWindow mazeWindow = new MazeWindow();
        mazePanel.setMaze(maze);
        mazeWindow.setSize(500, 500);
        mazeWindow.setLayout(new BorderLayout());
        mazeWindow.getContentPane().add(mazePanel);
        mazePanel.repaint();
        mazeWindow.setVisible(true);
    }
}
