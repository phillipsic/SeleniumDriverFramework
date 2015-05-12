package com.company.mercurytours.app;

import com.framework.common.Application;

public class MercuryTours extends Application {

    public MercuryTours() throws Exception {
        setName("MercuryTours"); // this is the name of the application.  If set in the init.properties file
        // then the name will be appended to the base url. No app name in this case.
        setCommonName("Mercury Tours");
        setMainURLKey("MercuryTours_base_url"); // this is the key for the base URL

        /*
         The base URL should not be set here but in the <ENV>_init.properties file.
         The base URL could change from one environment to another.
         If there is no application name in the URL then leave out of the 
         <ENV>_init.properties file.
         */
    }
}
