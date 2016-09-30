package org.sbx.abstracts;

import org.sbx.factories.SiteFactory;

/**
 * Created by aloginov on 30.09.16.
 */
public abstract class RoomBuilder {

    protected SiteFactory siteFactory;

    public RoomBuilder(){
        siteFactory = new SiteFactory();
    }
}
