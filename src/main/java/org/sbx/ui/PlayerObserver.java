package org.sbx.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.objects.FinishRoom;
import org.sbx.objects.Maze;
import org.sbx.objects.Player;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by aloginov on 13.10.16.
 */
public class PlayerObserver implements Observer{
    private static final Logger logger = LogManager.getLogger(PlayerObserver.class);

    public void update(Observable o, Object arg) {
        Room room = Maze.getRooms().get(((Player) o).getCurrentRoomId());
        if (room.getClass().toString().contains(Classes.CLASS_FINISH_ROOM)){
            GUIManager.getFinishDialog();
        }
    }
}
