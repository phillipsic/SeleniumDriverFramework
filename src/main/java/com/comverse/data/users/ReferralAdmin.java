package com.comverse.data.users;

import com.framework.common.User;

public class ReferralAdmin extends User {

    public ReferralAdmin() throws Exception {
        setRole("ReferralAdmin");
        setLogin();
        setPassword();
    }
}
