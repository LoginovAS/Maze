package org.sbx.builders;

import org.sbx.interfaces.Buildable;
import org.sbx.interfaces.Builder;
import org.sbx.objects.Maze;
import org.sbx.ui.VisualMaze;

import java.awt.*;

/**
 * Created by aloginov on 12.10.16.
 */
public class VisualMazeBuilder implements Builder {

    private VisualMaze visualMaze;

    public void initVisualMaze(Maze maze){
        this.visualMaze = new VisualMaze(maze);
    }

    public void descVisualParameters(int x0, int y0, int cellSize, Graphics2D g2d){
        visualMaze.initMaze(x0, y0, cellSize);
        visualMaze.initGraphics(g2d);
    }

    public Buildable build() {
        visualMaze.constructVisualMaze();
        return visualMaze;
    }
}
