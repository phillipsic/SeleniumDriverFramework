package com.company.data.users;

import com.framework.common.User;

public class NormalUser extends User {

    public NormalUser() throws Exception {
        setRole("CSRUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
