package org.sbx.ui;

import org.sbx.objects.Maze;

import java.awt.*;

/**
 * Created by aloginov on 05.10.16.
 */
public class Paint {
    public Paint(Maze maze){
        MazeWindow mazeWindow = new MazeWindow(maze);
        mazeWindow.setSize(500, 500);
        mazeWindow.setVisible(true);
    }
}
