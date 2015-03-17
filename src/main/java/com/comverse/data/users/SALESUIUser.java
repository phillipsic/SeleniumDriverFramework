package com.comverse.data.users;

import com.framework.common.User;

public class SALESUIUser extends User {

    public SALESUIUser() throws Exception {
        setRole("SALESUIUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
