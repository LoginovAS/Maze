package org.sbx.builders;

import org.sbx.factories.SiteFactory;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;

import java.util.HashMap;

/**
 * Created by aloginov on 27.09.16.
 */
public class StandardMazeBuilder extends MazeBuilder {

    private Maze currentMaze;
    private SiteFactory siteFactory;

    public StandardMazeBuilder(){
        currentMaze = new Maze();
        siteFactory = new SiteFactory();
    }

    public void addRoom(HashMap<Direction, String> sites){
        RoomDirector roomDirector = new RoomDirector();
        currentMaze.addRoom(roomDirector.buildRoom(sites));
    }
}
