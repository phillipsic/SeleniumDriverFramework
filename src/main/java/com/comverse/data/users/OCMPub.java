package com.comverse.data.users;

import com.framework.common.User;

public class OCMPub extends User {

    public OCMPub() throws Exception {
        setRole("OCMPub");
        setLogin();
        setPassword();
        setRole("OCM Publisher");
    }
}
