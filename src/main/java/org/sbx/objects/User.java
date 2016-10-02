package org.sbx.objects;

import java.security.DigestException;

/**
 * Created by aloginov on 02.10.16.
 */
public class User {
    private int currenRoomId;
    private int movingCounter;

    public User(int startRoomId){
        this.currenRoomId = startRoomId;
        this.movingCounter = 0;
    }

    public void move(Direction direction) throws DigestException{

    }
}
