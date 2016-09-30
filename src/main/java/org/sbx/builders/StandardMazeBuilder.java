package org.sbx.builders;

import org.sbx.abstracts.MazeBuilder;
import org.sbx.directors.RoomDirector;
import org.sbx.interfaces.Builder;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;

import java.util.HashMap;

/**
 * Created by aloginov on 27.09.16.
 */
public class StandardMazeBuilder extends MazeBuilder implements Builder {

    private Maze currentMaze;

    public StandardMazeBuilder(){
        super();
        currentMaze = new Maze();
    }

    public void addRoom(HashMap<Direction, String> sites){
        RoomDirector roomDirector = new RoomDirector();
        roomDirector.setBuilder();
        roomDirector.desc(sites);
        roomDirector.construct();
        currentMaze.addRoom(roomDirector.build());
    }

    public Maze build(){
        return currentMaze;
    }
}
