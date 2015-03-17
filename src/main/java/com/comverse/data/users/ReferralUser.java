package com.comverse.data.users;

import com.framework.common.User;

public class ReferralUser extends User {

    public ReferralUser() throws Exception {
        setRole("ReferralUser");
        setLogin();
        setPassword();
    }
}
