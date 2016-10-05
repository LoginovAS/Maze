package org.sbx.factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.abstracts.Site;
import org.sbx.exceptions.Errors;
import org.sbx.exceptions.GameplayException;
import org.sbx.objects.Door;
import org.sbx.objects.Wall;

/**
 * Created by aloginov on 27.09.16.
 */
public class SiteFactory {

    private final static Logger logger = LogManager.getLogger(SiteFactory.class);
    public Site createSite(Class<Site> clazz) throws GameplayException{

        Errors error = Errors.CLASS_STRUCTURE_ERROR;

        Site inst = null;
        try{
            inst = clazz.newInstance();
        } catch (InstantiationException ex){
            logger.fatal(ex);
        } catch (IllegalAccessException ex){
            logger.fatal(ex);
        }

        if (inst == null)
            throw new GameplayException(error);

        return inst;
    }
}
