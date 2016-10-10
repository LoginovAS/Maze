package org.sbx.main;

import org.sbx.directors.MazeDirector;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;
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

        mazeDirector.desc(5);
        mazeDirector.construct();
        final Maze maze = mazeDirector.build();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Paint(maze);
            }
        });
    }
}

