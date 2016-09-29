package org.sbx.directors;

import org.sbx.abstracts.MazeBuilder;
import org.sbx.builders.StandardMazeBuilder;
import org.sbx.factories.SiteFactory;
import org.sbx.interfaces.Director;
import org.sbx.objects.Maze;

/**
 * Created by aloginov on 28.09.16.
 */
public class MazeDirector implements Director {

    protected SiteFactory siteFactory;

    private MazeBuilder mazeBuilder;

    public void setBuilder(){
        this.mazeBuilder = new StandardMazeBuilder();
    }

    public void construct(){

    }

    public Maze build(){
        return mazeBuilder.build();
    }
}
