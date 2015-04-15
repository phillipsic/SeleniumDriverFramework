package com.framework.common;

/**
 * 
 * @author iphilli
 */
public class AlreadyRunException extends Exception {

    /**
     * This class is used to PASS a test without running it.
     * When the DB is installed each test will check to see if it has 
     * already passed on the current build.  If it has passed then we abort 
     * test but make sure a GREEN bar is shown.  
     */
    private static final long serialVersionUID = -2530814572579866798L;

    public AlreadyRunException() {
        super();
    }

}
