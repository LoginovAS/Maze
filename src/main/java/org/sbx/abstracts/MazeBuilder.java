package org.sbx.abstracts;

import org.sbx.factories.SiteFactory;
import org.sbx.objects.Direction;

import java.util.*;

/**
 * Created by aloginov on 27.09.16.
 */
public abstract class MazeBuilder {

    protected int currentRoom;
    protected int randomNeighbour;

    protected ArrayList<Integer> neighbours;
    protected List<Integer> visitedRooms;
    protected LinkedList<Integer> currentRoomsStack;

    protected ArrayList<Integer> unvisitedList;

    protected SiteFactory siteFactory;

    public MazeBuilder(){
        this.siteFactory = new SiteFactory();
        this.unvisitedList = new ArrayList<Integer>();
        this.currentRoomsStack = new LinkedList<Integer>();
    }

    public abstract void addRoom(HashMap<Direction, String> sites);

    public abstract void createDoor(int room1, int room2);

    public void setCurrentRoom(int roomId){
        this.currentRoom = roomId;
        this.addVisitedRoom(roomId);
    }

    public void addVisitedRoom(int roomId){
        unvisitedList.remove((Integer) roomId);
    }

    public void addRoomToStack(int roomId){
        currentRoomsStack.add(roomId);
    }

    public int getRoomFromStack(){
        return currentRoomsStack.pollLast();
    }
}
