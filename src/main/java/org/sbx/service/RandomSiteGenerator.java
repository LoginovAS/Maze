package org.sbx.service;

import java.util.Random;

/**
 * Created by aloginov on 01.10.16.
 */
public class RandomSiteGenerator {
    public String generate(int n){
        Random random = new Random(System.currentTimeMillis());
        int r = random.nextInt(n);

        if (r < n / 2)
            return Classes.CLASS_DOOR;
        else
            return Classes.CLASS_WALL;
    }
}
