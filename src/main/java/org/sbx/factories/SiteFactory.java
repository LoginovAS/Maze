package org.sbx.factories;

import org.sbx.abstracts.Site;
import org.sbx.objects.Door;
import org.sbx.objects.Wall;

/**
 * Created by aloginov on 27.09.16.
 */
public class SiteFactory {

    public Site createSite(Class<Site> clazz){
        Site inst = null;
        try{
            inst = clazz.newInstance();
        } catch (InstantiationException ex){
            ex.printStackTrace();
        } catch (IllegalAccessException ex){
            ex.printStackTrace();
        }

        return inst;
    }
}
