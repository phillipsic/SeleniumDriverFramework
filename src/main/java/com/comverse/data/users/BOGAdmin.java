package com.comverse.data.users;

import com.framework.common.User;

public class BOGAdmin extends User {

    public BOGAdmin() throws Exception {
        setRole("BOGAdmin");
        setLogin();
        setPassword();
        setRealm();
    }
}
