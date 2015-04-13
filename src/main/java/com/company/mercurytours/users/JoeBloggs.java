package com.company.mercurytours.users;

import com.framework.common.User;

public class JoeBloggs extends User {

    public JoeBloggs() throws Exception {
        setRole("NormalUser");
        
        /* Following will be read from INI file       
        */
        setLogin();
        setPassword();
        setRealm();
    }
}
