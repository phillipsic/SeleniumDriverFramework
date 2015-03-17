package com.comverse.data.users;

import com.framework.common.User;

public class WPMCAdmin extends User {

    public WPMCAdmin() throws Exception {
        setRole("WPMCAdmin");
        setLogin();
        setPassword();
    }
}
