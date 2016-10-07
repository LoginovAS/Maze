package org.sbx.directors;

import org.sbx.abstracts.MazeBuilder;
import org.sbx.builders.StandardMazeBuilder;
import org.sbx.factories.SiteFactory;
import org.sbx.interfaces.Director;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;

import java.util.HashMap;

/**
 * Created by aloginov on 28.09.16.
 */
public class MazeDirector implements Director {

    private StandardMazeBuilder mazeBuilder;
    private HashMap<Direction, String> sites;
    private int mazeSize;

    public MazeDirector(){ }

    public void desc(HashMap<Direction, String> sites){
        this.sites = sites;
    }

    public void desc(int mazeSize){
        this.mazeSize = mazeSize;
    }

    public void setBuilder(){
        this.mazeBuilder = new StandardMazeBuilder();
    }

    public void construct(){
        mazeBuilder.setMazeSize(mazeSize);
        mazeBuilder.buildMazeFrame();
        mazeBuilder.createDoors();
    }

    public int getIdByRoom(Room room){
        return mazeBuilder.getRoomId(room);
    }

    public Maze build(){
        return mazeBuilder.build();
    }
}
