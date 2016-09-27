package org.sbx.objects;

import org.sbx.interfaces.Site;

/**
 * Created by aloginov on 27.09.16.
 */
public class Door implements Site {

    private Room room1;
    private Room room2;

    public Door(Room room1, Room room2){
        this.room1 = room1;
        this.room2 = room2;
    }

}
