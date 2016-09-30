package org.sbx.interfaces;

/**
 * Created by aloginov on 29.09.16.
 */
public interface Director {

    public void setBuilder();

    public void construct();

    public Buildable build();

}
