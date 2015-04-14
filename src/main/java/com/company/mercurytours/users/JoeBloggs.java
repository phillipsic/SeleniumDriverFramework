package com.company.mercurytours.users;

import com.framework.common.User;

public class JoeBloggs extends User {

    public JoeBloggs() throws Exception {

        /* The role is needed to find the users login and password
         in the <ENV>_init.properties file
         LOGIN.NormalUser=JoeBlogs
         PASSWD.NormalUser=J03Bl0g5        
         */
        setRole("NormalUser"); //the role is needed to find the 

        /* Following will be read from INI file using the set role above      
         */
        setLogin();
        setPassword();
        // setRealm();
    }
}
