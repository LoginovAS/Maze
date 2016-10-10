package org.sbx.objects;

import javax.swing.*;

/**
 * Created by aloginov on 10.10.16.
 */
public class Player {

    private int currentRoomId;

    public void move(int roomId){
        this.currentRoomId = roomId;
    }


}
