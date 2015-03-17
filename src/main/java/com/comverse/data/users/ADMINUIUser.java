package com.comverse.data.users;

import com.framework.common.User;

public class ADMINUIUser extends User {

    public ADMINUIUser() throws Exception {
        setRole("ADMINUIUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
