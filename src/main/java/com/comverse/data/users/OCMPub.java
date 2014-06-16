package com.comverse.data.users;

import com.comverse.common.User;

public class OCMPub extends User {

    public OCMPub() throws Exception {
       
        setLogin();
        setPassword();
        setRole("OCM Publisher");
    }
}
