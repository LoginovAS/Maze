package org.sbx.builders;

import org.sbx.objects.Maze;

/**
 * Created by aloginov on 28.09.16.
 */
public class Director {

    private MazeBuilder mazeBuilder;

    public void setMazeBuilder(MazeBuilder mazeBuilder){
        this.mazeBuilder = mazeBuilder;
    }

    public Maze getMaze(){
        return mazeBuilder.getMaze();
    }

    public void constructMaze(){
        mazeBuilder.buildRoom(0);
        mazeBuilder.buildRoom(1);
        mazeBuilder.buildRoom(2);
        mazeBuilder.buildRoom(3);
        mazeBuilder.buildRoom(4);
        mazeBuilder.buildDoor(0, 1);
        mazeBuilder.buildDoor(0, 2);
        mazeBuilder.buildDoor(0, 3);
        mazeBuilder.buildDoor(0, 4);
    }
}
