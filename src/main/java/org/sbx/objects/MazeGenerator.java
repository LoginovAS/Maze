package org.sbx.objects;

import org.sbx.directors.MazeDirector;

/**
 * Created by aloginov on 14.10.16.
 */
public class MazeGenerator {
    public static Maze generateNewMaze(int size){
        MazeDirector mazeDirector = new MazeDirector();
        mazeDirector.setBuilder();

        mazeDirector.desc(size);
        mazeDirector.construct();

        return mazeDirector.build();
    }
}
