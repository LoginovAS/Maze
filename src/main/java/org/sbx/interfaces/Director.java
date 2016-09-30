package org.sbx.interfaces;

import org.sbx.objects.Direction;

import java.util.HashMap;

/**
 * Created by aloginov on 29.09.16.
 */
public interface Director {

    public void setBuilder();

    public void desc(HashMap<Direction, String> sites);

    public void construct();

    public Buildable build();

}
