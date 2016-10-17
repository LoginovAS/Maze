package org.sbx.ui;

import org.sbx.objects.Maze;
import org.sbx.objects.Player;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by aloginov on 05.10.16.
 */
public class Paint{

    private GUIManager guiManager;

    public Paint(Maze maze){
        this.guiManager = new GUIManager();

        guiManager.constructMazePanel(maze);
        guiManager.constructMazeWindow();
        guiManager.getMazeWindow().setVisible(true);
    }
}
