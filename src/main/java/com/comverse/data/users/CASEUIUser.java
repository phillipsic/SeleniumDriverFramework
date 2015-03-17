package com.comverse.data.users;

import com.framework.common.User;

public class CASEUIUser extends User {

    public CASEUIUser() throws Exception {
        setRole("CASEUIUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
