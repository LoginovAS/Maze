package org.sbx.builders;

<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
import org.sbx.factories.SiteFactory;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;
=======
import org.sbx.abstracts.MazeBuilder;
import org.sbx.directors.RoomDirector;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
>>>>>>> [27/09/2016]

import java.util.HashMap;

/**
 * Created by aloginov on 27.09.16.
 */
public class StandardMazeBuilder extends MazeBuilder {

    private Maze currentMaze;
<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
    private SiteFactory siteFactory;

    public StandardMazeBuilder(){
        currentMaze = new Maze();
        siteFactory = new SiteFactory();
    }

    public void addRoom(HashMap<Direction, String> sites){
        RoomDirector roomDirector = new RoomDirector();
        currentMaze.addRoom(roomDirector.buildRoom(sites));
=======

    public StandardMazeBuilder(){
        super();
        currentMaze = new Maze();
    }

    public void addRoom(HashMap<Direction, String> sites){
        RoomDirector roomDirector = new RoomDirector(sites);
        roomDirector.construct();
        currentMaze.addRoom(roomDirector.build());
    }

    public Maze build(){
        return currentMaze;
>>>>>>> [27/09/2016]
    }
}
