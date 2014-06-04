package com.comverse.data.users;

import com.comverse.common.User;

public class B2BAdmin extends User {

    public B2BAdmin() throws Exception {
        setRole("B2BAdmin");
        setLogin();
        setPassword();
    }
}
