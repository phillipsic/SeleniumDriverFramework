package com.company.data.users;

import com.framework.common.User;

public class NormalUser extends User {

    public NormalUser() throws Exception {
        setRole("NormalUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
