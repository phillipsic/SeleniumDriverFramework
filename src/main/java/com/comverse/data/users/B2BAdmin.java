package com.comverse.data.users;

import com.framework.common.User;
import com.framework.app.common.Common;

public class B2BAdmin extends User {

    public B2BAdmin() throws Exception {
        setRole("B2BAdmin");
        setNewLogin(Common.getBusinessAdminLogin());
        setNewPassword(Common.getBusinessAdminPassword());
    }
}
