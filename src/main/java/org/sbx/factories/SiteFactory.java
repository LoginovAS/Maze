package org.sbx.factories;

import org.sbx.abstracts.Site;
import org.sbx.objects.Door;
import org.sbx.objects.Wall;

/**
 * Created by aloginov on 27.09.16.
 */
public class SiteFactory {

    public Site getSite(String siteName){
        if (siteName.equals("room"))
            return new Wall();
        else if (siteName.equals("door"))
            return new Door();

        return null;
    }

}
