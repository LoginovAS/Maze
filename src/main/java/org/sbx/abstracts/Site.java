package org.sbx.abstracts;

/**
 * Created by aloginov on 27.09.16.
 */
public abstract class Site {

    protected int roomFromId;
    protected int roomToId;

    public void makeCommon(int roomFromId, int roomToId){
        this.roomFromId = roomFromId;
        this.roomToId = roomToId;
    }

}
