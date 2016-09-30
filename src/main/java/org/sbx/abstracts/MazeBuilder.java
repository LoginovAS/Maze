package org.sbx.abstracts;

import org.sbx.factories.SiteFactory;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;

import java.util.HashMap;

/**
 * Created by aloginov on 27.09.16.
 */
public abstract class MazeBuilder {

    protected SiteFactory siteFactory;

    public MazeBuilder(){
        this.siteFactory = new SiteFactory();
    }

    public abstract void addRoom(HashMap<Direction, String> sites);
}
