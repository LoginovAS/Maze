package org.sbx.ui;

import org.sbx.objects.Maze;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by aloginov on 14.10.16.
 */
public class GUIManager {
    private static MazeWindow mazeWindow;
    private MazePanel mazePanel;

    public void constructMazePanel(Maze maze){
        this.mazePanel = new MazePanel();
        this.mazePanel.setMaze(maze);
        this.mazePanel.initPlayer();
    }

    public void constructMazeWindow(){
        this.mazeWindow = new MazeWindow();
        this.mazeWindow.getContentPane().add(mazePanel);
        this.mazeWindow.pack();
        this.mazeWindow.setSize(1024, 768);
    }

    public void constructFinishDialog(){

    }

    public JFrame getMazeWindow(){
        return mazeWindow;
    }

    public JPanel getMazePanel(){
        return mazePanel;
    }

    public static void getFinishDialog(){
        FinishDialog finishDialog = new FinishDialog(mazeWindow);
        finishDialog.setVisible(true);
    }
}
