package com.comverse.data.users;

import com.comverse.common.User;

public class CSRAdmin extends User {

    public CSRAdmin() throws Exception {
        setRole("CSRAdmin");
        setLogin();
        setPassword();
        setRealm();
    }
}
