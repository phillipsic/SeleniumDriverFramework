package com.company.data.users;

import com.framework.common.User;

public class AdminUser extends User {

    public AdminUser() throws Exception {
        setRole("AdminUser");
        setLogin();
        setPassword();
        setRealm();
    }
}
