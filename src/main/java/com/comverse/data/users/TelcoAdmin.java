package com.comverse.data.users;

import com.comverse.common.User;

public class TelcoAdmin extends User {

    public TelcoAdmin() throws Exception {
        setRole("TelcoAdmin");
        setLogin();
        setPassword();
        setRealm();
    }
}
