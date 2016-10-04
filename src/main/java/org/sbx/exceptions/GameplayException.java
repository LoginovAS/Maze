package org.sbx.exceptions;

import org.sbx.interfaces.MazeException;

/**
 * Created by aloginov on 04.10.16.
 */
public class GameplayException extends Exception implements MazeException {

    private Errors error;

    public GameplayException() {
        super();
    }

    public GameplayException(String msg){
        super(msg);
    }

    public GameplayException(String msg, Errors error){
        super(msg);
        this.error = error;
    }

    public GameplayException(Errors error){
        this.error = error;
    }

    public int getErrorCode(){
        return error.getErrorCode();
    }

    public String getErrorMessage(){
        return error.getErrorMessage();
    }
}
