package com.company.data.users;

import com.framework.common.User;

public class CLSAdmin extends User {

    public CLSAdmin() throws Exception {
        setRole("CLSAdmin");
        setLogin();
        setPassword();
    }
}
