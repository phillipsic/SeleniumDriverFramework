package com.company.mercurytours.app;

import com.framework.common.Application;

public class Google extends Application {

    public Google() throws Exception {
        setName("Google");
        setCommonName("Google");
        setMainURLKey("Google_url");

        /*
         The base URL should not be set here but in the <ENV>_init.properties file.
         The base URL could change from one environment to another.
         If there is no application name in the URL then leave out of the 
         <ENV>_init.properties file.
         */
    }
}
