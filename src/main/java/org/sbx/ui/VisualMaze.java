package org.sbx.ui;

import org.sbx.abstracts.Site;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by aloginov on 05.10.16.
 */
public class VisualMaze {
   /* public void drawMaze(Maze maze){
        for (Room room: maze.getRooms()){
            HashMap<Direction, Site> site = (HashMap<Direction, Site>) room.getSites();
            for (Map.Entry<Direction, Site> entry: site.entrySet()){
                Direction key = entry.getKey();
                Site value = entry.getValue();
                switch (key){
                    case WEST:
                        try {
                            if (value.getClass() == Class.forName(Classes.CLASS_WALL))
                                System.out.
                        }
                }
            }
        }
    }*/
}
