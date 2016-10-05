package org.sbx.main;

import org.sbx.directors.MazeDirector;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.service.Classes;
import org.sbx.service.RandomSiteGenerator;
import org.sbx.ui.Paint;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by aloginov on 01.10.16.
 */
public class Application {
    public static void main(String[] args){

        MazeDirector mazeDirector = new MazeDirector();
        mazeDirector.setBuilder();

        mazeDirector.desc(3);
        mazeDirector.construct();
        final Maze maze = mazeDirector.build();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Paint(maze);
            }
        });
        /*
        HashMap<Direction, String> sites = new HashMap<Direction, String>();
        RandomSiteGenerator siteGenerator = new RandomSiteGenerator();
        MazeDirector mazeDirector = new MazeDirector();
        mazeDirector.setBuilder();
        for (int i = 0; i < 10; i++){
            sites.put(Direction.NORTH, siteGenerator.generate(100));
            sites.put(Direction.EAST, siteGenerator.generate(100));
            sites.put(Direction.SOUTH, siteGenerator.generate(100));
            sites.put(Direction.WEST, siteGenerator.generate(100));

            mazeDirector.desc(sites);
            mazeDirector.construct();
            sites = new HashMap<Direction, String>();
        }

        Maze maze = mazeDirector.build();
        System.out.println(maze.toString());
        */
    }
}

