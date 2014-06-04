package com.comverse.data.users;

import com.comverse.common.User;

public class ReferralAdmin extends User {

    public ReferralAdmin() throws Exception {
        setRole("ReferralAdmin");
        setLogin();
        setPassword();
    }
}
