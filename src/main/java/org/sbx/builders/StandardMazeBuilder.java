package org.sbx.builders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.abstracts.MazeBuilder;
import org.sbx.directors.RoomDirector;
import org.sbx.exceptions.GameplayException;
import org.sbx.exceptions.Errors;
import org.sbx.interfaces.Builder;
import org.sbx.objects.Direction;
import org.sbx.objects.Maze;
import org.sbx.objects.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by aloginov on 27.09.16.
 */
public class StandardMazeBuilder extends MazeBuilder implements Builder {

    private static final Logger logger = LogManager.getLogger(StandardMazeBuilder.class);
    private Maze currentMaze;
    private int mazeSize;

    public StandardMazeBuilder(){
        super();
        currentMaze = new Maze();
    }

    public void setMazeSize(int mazeSize){
        this.mazeSize = mazeSize;
    }

    public void buildMazeFrame(){
        for (int i = 0; i < mazeSize * mazeSize; i++) {
            this.addRoomFrame();
            this.unvisitedList.add(i);
        }
    }

    private void addRoomFrame(){
        RoomDirector roomDirector = new RoomDirector();
        roomDirector.setBuilder();
        roomDirector.constructRoomFrame();
        currentMaze.addRoom(roomDirector.build());
    }

    public void addRoom(HashMap<Direction, String> sites){
        RoomDirector roomDirector = new RoomDirector();
        roomDirector.setBuilder();
        roomDirector.desc(sites);
        roomDirector.construct();
        currentMaze.addRoom(roomDirector.build());
    }

    public void createDoors(){
        Random random;
        ArrayList<Integer> neighbours;
        this.setCurrentRoom(0);
        while (!this.unvisitedList.isEmpty()){
            neighbours = this.getNeighbours();
            random = new Random(System.currentTimeMillis());
            if (!neighbours.isEmpty()){
                this.addRoomToStack(currentRoom);
                int randomNeighbour = neighbours.get(random.nextInt(neighbours.size()));
                this.createDoor(currentRoom, randomNeighbour);
                this.setCurrentRoom(randomNeighbour);
            } else if (!currentRoomsStack.isEmpty()){
                this.setCurrentRoom(this.getRoomFromStack());
            } else{
                random = new Random(System.currentTimeMillis());
                this.setCurrentRoom(unvisitedList.get(random.nextInt(unvisitedList.size())));
            }
        }
    }

    public Direction getRoomDirection(int roomId1, int roomId2) throws GameplayException {
        Errors error = Errors.DIRECTION_NEIGHBOURHOOD_ERROR;
        Direction direction = null;
        int x = roomId1 - roomId2;
        if (x == -1)
            return Direction.EAST;
        if (x == 1)
            return Direction.WEST;
        if (x == -mazeSize)
            return Direction.SOUTH;
        if (x == mazeSize)
            return Direction.NORTH;

        if (direction == null)
            throw new GameplayException(error);

        return direction;
    }

    public void createDoor(int roomId1, int roomId2){
        RoomDirector roomDirector = new RoomDirector();
        roomDirector.setBuilder();
        try {
            Direction direction1 = this.getRoomDirection(roomId1, roomId2);
            Direction direction2 = this.getRoomDirection(roomId2, roomId1);
            if (direction1 != null){
                Room room = currentMaze.getRoomById(roomId1);
                roomDirector.setDoor(room, direction1);
                currentMaze.changeRoom(roomId1, roomDirector.build());

                room = currentMaze.getRoomById(roomId2);
                roomDirector.setDoor(room, direction2);
                currentMaze.changeRoom(roomId2, roomDirector.build());
            }
        } catch (GameplayException ex){
            logger.error(ex.getErrorMessage(), ex.getErrorCode());
            logger.trace(ex.getStackTrace());
        }
    }

    private int getX(){
        return currentRoom / mazeSize;
    }

    private int getY(){
        return currentRoom % mazeSize;
    }

    private ArrayList<Integer> getNeighbours(){
        this.neighbours = new ArrayList<Integer>();
        if ((this.getY() - 1 >= 0) && (unvisitedList.contains(currentRoom - 1))){
            neighbours.add(currentRoom - 1);
        }

        if ((this.getY() + 1 < mazeSize) && (unvisitedList.contains(currentRoom + 1))){
            neighbours.add(currentRoom + 1);
        }

        if ((this.getX() - 1 >= 0) && (unvisitedList.contains(currentRoom - mazeSize))) {
            neighbours.add(currentRoom - mazeSize);
        }

        if ((this.getX() + 1 < mazeSize) && (unvisitedList.contains(currentRoom + mazeSize))){
            neighbours.add(currentRoom + mazeSize);
        }

        return neighbours;
    }

    public Maze build(){
        return currentMaze;
    }
}
