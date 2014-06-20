package com.comverse.data.users;

import com.comverse.common.User;
import com.comverse.css.common.Common;

public class B2BAdmin extends User {

    public B2BAdmin() throws Exception {
        setRole("B2BAdmin");
        setNewLogin(Common.getBusinessAdminLogin());
        setNewPassword(Common.getBusinessAdminPassword());
    }
}
