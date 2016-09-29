package org.sbx.factories;

import org.sbx.abstracts.Site;
import org.sbx.objects.Door;
import org.sbx.objects.Wall;

/**
 * Created by aloginov on 27.09.16.
 */
public class SiteFactory {

<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
    public Site getSite(String siteName){
        if (siteName.equals("room"))
            return new Wall();
        else if (siteName.equals("door"))
            return new Door();

        return null;
    }

=======
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
>>>>>>> [27/09/2016]
}
