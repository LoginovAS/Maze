package org.sbx.directors;

import org.sbx.abstracts.MazeBuilder;
import org.sbx.builders.StandardMazeBuilder;
import org.sbx.factories.SiteFactory;
import org.sbx.interfaces.Director;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;

import java.util.HashMap;

/**
 * Created by aloginov on 28.09.16.
 */
public class MazeDirector implements Director {

    private StandardMazeBuilder mazeBuilder;
    private HashMap<Direction, String> sites;

    public MazeDirector(){ }

    public void desc(HashMap<Direction, String> sites){
        this.sites = sites;
    }

    public void setBuilder(){
        this.mazeBuilder = new StandardMazeBuilder();
    }

    public void construct(){
        mazeBuilder.addRoom(sites);
    }

    public Maze build(){
        return mazeBuilder.build();
    }
}
