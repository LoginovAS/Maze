package org.sbx.exceptions;

/**
 * Created by aloginov on 02.10.16.
 */
public class DirectionException extends Exception {

    private int errorCode;

    public DirectionException(String message){
        this(0, message);
    }

    public DirectionException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode(){
        return errorCode;
    }
}
