package com.company.mercurytours.app;

import com.framework.common.Application;

public class MercuryTours extends Application {

    public MercuryTours() throws Exception {
        setName("MercuryTours"); // Also used as a key in INI file for application name.
        setCommonName("Mercury Tours");
       
        
        /*
        The base URL should not be set here but in the <ENV>_init.properties file.
        The base URL could change from one environment to another.
        If there is no application name in the URL then leave out of the 
        <ENV>_init.properties file.
        */
    }
}
