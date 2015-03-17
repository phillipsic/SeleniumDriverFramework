package com.company.data.users;

import com.framework.common.User;

public class TelcoAdmin extends User {

    public TelcoAdmin() throws Exception {
        setRole("TelcoAdmin");
        setLogin();
        setPassword();
        setRealm();
    }
}
