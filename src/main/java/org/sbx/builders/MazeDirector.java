package org.sbx.builders;

import org.sbx.objects.Maze;

/**
 * Created by aloginov on 28.09.16.
 */
public class MazeDirector {

    private MazeBuilder mazeBuilder;

    public void setMazeBuilder(MazeBuilder mazeBuilder){
        this.mazeBuilder = mazeBuilder;
    }

    public void constructMaze(){
        // TODO
    }

    public Maze build(){
        return mazeBuilder.getMaze();
    }
}
