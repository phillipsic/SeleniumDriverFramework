package com.comverse.data.users;

import com.comverse.common.User;

public class CSRUser extends User {

    public CSRUser() throws Exception {
        setRole("CSRUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
