package org.sbx.ui;

import org.sbx.directors.MazeDirector;
import org.sbx.objects.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by aloginov on 05.10.16.
 */
public class MazeWindow extends JFrame {

    public MazeWindow(Maze maze){
        super("Maze window");

        MazePanel mazePanel = new MazePanel();
        mazePanel.setMaze(maze);
        getContentPane().add(mazePanel);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MazeWindow.this.setVisible(false);
                MazeWindow.this.dispose();
            }
        });

        pack();
    }
}
