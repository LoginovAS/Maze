package org.sbx.builders;

import org.sbx.factories.SiteFactory;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;

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

    public void buildRoom(int roomId){
        siteFactory.makeRoom(roomId);
    }

    public void buildDoor(Room roomFrom, Room roomTo){
        siteFactory.makeDoor(roomFrom, roomTo);
    }
}
