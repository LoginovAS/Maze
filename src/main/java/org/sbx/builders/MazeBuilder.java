package org.sbx.builders;

import org.sbx.objects.Maze;

/**
 * Created by aloginov on 27.09.16.
 */
public abstract class MazeBuilder {

    public void buildMaze() { }

    public void buildRoom(int roomId) { }

    public void buildDoor(int roomFrom, int roomTo) { }

    public Maze getMaze(){
        return null;
    }
}
